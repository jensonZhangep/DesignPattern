package com.pattern.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:57
 */
public class JdkMeipo implements InvocationHandler {

  private Object target;

  public Object getInstance(Object target) {
    this.target = target;
    Class<?> clazz = target.getClass();
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    Object object = method.invoke(this.target, args);
    after();
    return object;
  }

  private void before() {
    System.out.println("媒婆帮你找对象");
    System.out.println("开始物色");
  }

  private void after() {
    System.out.println("如果合适就准备办事");
  }
}
