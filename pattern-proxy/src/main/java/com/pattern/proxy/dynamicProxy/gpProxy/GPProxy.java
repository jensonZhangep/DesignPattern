package com.pattern.proxy.dynamicProxy.gpProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:19
 */
public class GPProxy {

  public static final String ln = "\r\n";

  public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
    try{
      if(interfaces.length > 65535) {
        throw new Exception("接口数量超出限制");
      }
      //1.动态生成源代码.java文件
      String src = generateSrc(interfaces);
      //2. Java文件输出磁盘
      String filePath = GPProxy.class.getResource("").getPath();
      File f = new File(filePath + "$Proxy0.java");
      FileWriter fw = new FileWriter(f);
      fw.write(src);
      fw.flush();
      fw.close();
      //3.把生成的.java文件编译成class文件
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
      Iterable iterable = manager.getJavaFileObjects(f);
      JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
      task.call();
      manager.close();
      //4.编译生成的.class文件加载到jvm中
      Class proxyClass = classLoader.findClass("$Proxy0");
      Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
      f.delete();
      //5.返回字节码重组以后的新的代理对象
      return c.newInstance(h);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String generateSrc(Class<?>[] interfaces) {
    StringBuffer sb = new StringBuffer();
    StringBuffer interfaceNames = getInterfaceNames(interfaces);
    sb.append("package com.pattern.proxy.dynamicProxy.gpProxy;" + ln);
    sb.append("import com.pattern.proxy.staticProxy.Person;" + ln);
    sb.append("import com.pattern.proxy.staticProxy.Job;" + ln);
    sb.append("import java.lang.reflect.*;" + ln);
    sb.append("public class $Proxy0 implements " + interfaceNames + "{ " + ln);
    sb.append("GPInvocationHandler h;");
    sb.append("public $Proxy0(GPInvocationHandler h){ " + ln);
    sb.append("this.h = h;" + ln);
    sb.append("}" + ln);
    for (int i = 0; i < interfaces.length; i++) {
      for (Method m : interfaces[i].getMethods()) {
        Class<?>[] params = m.getParameterTypes();
        StringBuffer paramNames = new StringBuffer();
        StringBuffer paramValues = new StringBuffer();
        StringBuffer paramClasses = new StringBuffer();

        for (int j = 0; j < params.length; j++) {
          Class clazz = params[j];
          String type = clazz.getName();
          String paramName = toLowerFirstCase(clazz.getSimpleName());
          paramNames.append(type + " " + paramName);
          paramValues.append(paramName);
          paramClasses.append(clazz.getName() + ".class");
          if(j > 0 && j < params.length - 1) {
            paramNames.append(",");
            paramValues.append(",");
            paramClasses.append(",");
          }
        }
        sb.append("public "+ m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" +ln);
        sb.append("try{" + ln);
        sb.append("Method m = " + interfaces[i].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
        sb.append((hasReturnValue(m.getReturnType()) ? "return" : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
        sb.append("}catch(Error _ex){}" + ln);
        sb.append("catch(Throwable e){" + ln);
        sb.append("throw new UndeclaredThrowableException(e);" + ln);
        sb.append("}" + ln);
        sb.append(getReturnEmptyCode(m.getReturnType()));
        sb.append("}" + ln);
      }
    }
    sb.append("}" + ln);
    return sb.toString();
  }

  private static Map<Class, Class> mappings = new HashMap<Class, Class>();
  static {
    mappings.put(int.class, Integer.class);
  }

  private static StringBuffer getInterfaceNames(Class<?>[] interfaces) {
    StringBuffer interfaceNames = new StringBuffer();
    for (int i = 0; i < interfaces.length; i++) {
      interfaceNames.append(interfaces[i].getSimpleName());
      if(i >= 0 && i < interfaces.length - 1) {
        interfaceNames.append(", ");
      }
    }
    return interfaceNames;
  }

  private static String getReturnEmptyCode(Class<?> returnClass) {
    if(mappings.containsKey(returnClass)) {
      return "return 0;";
    } else if(returnClass == void.class) {
      return "";
    } else {
      return "return null;";
    }
  }

  private static String getCaseCode(String code, Class<?> returnClass) {
    if(mappings.containsKey(returnClass)) {
      return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
    }
    return code;
  }

  private static boolean hasReturnValue(Class<?> clazz) {
    return clazz != void.class;
  }

  private static String toLowerFirstCase(String str) {
    char[] chars = str.toCharArray();
    chars[0] += 32;
    return String.valueOf(chars);
  }
}
