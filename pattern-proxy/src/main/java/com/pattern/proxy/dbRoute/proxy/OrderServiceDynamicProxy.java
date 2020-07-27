package com.pattern.proxy.dbRoute.proxy;

import com.pattern.proxy.dbRoute.db.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:06
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
  private Object target;

  public Object getInstance(Object target) {
    this.target = target;
    Class<?> clazz = target.getClass();
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before(args[0]);
    Object object = method.invoke(target, args);
    after();
    return object;
  }

  private void before(Object target) {
    try {
      System.out.println("proxy before method.");
      Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
      Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
      System.out.println("静态代理自动分配到【DB_" + dbRouter + "】数据源处理数据");
      DynamicDataSourceEntry.set(dbRouter);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

  }

  private void after() {
    System.out.println("proxy after method.");
  }
}
