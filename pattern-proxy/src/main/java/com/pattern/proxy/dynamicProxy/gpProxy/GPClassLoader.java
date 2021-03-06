package com.pattern.proxy.dynamicProxy.gpProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:20
 */
public class GPClassLoader extends ClassLoader {
  private File classPathFile;

  public GPClassLoader() {
    String classPath = GPClassLoader.class.getResource("").getPath();
    this.classPathFile = new File(classPath);
  }

  protected Class<?> findClass(String name) throws ClassNotFoundException {
    String className = GPClassLoader.class.getPackage().getName() + "." + name;
    if(classPathFile != null) {
      File classFile = new File(classPathFile, name.replaceAll("\\.","/") + ".class");
      if(classFile.exists()) {
        FileInputStream fis = null;
        ByteArrayOutputStream out = null;
        try {
          fis = new FileInputStream(classFile);
          out = new ByteArrayOutputStream();
          byte[] buff = new byte[1024];
          int len;
          while ((len = fis.read(buff)) != -1) {
            out.write(buff, 0, len);
          }
          return defineClass(className, out.toByteArray(), 0, out.size());
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if(fis != null) {
            try {
              fis.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
          if(out != null){
            try {
              out.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }
    return null;
  }
}
