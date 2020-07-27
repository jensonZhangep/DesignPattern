package com.pattern.proxy.dynamicProxy.gpProxy;

import java.lang.reflect.Method;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:28
 */
public class GPMeipo implements GPInvocationHandler {
  //被代理的对象，把引用保存下来
  private Object target;

  public Object getInstance(Object target) throws Exception {
    this.target = target;
    Class<?> clazz = target.getClass();
    return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
    before();
    method.invoke(this.target, args);
    after();
    return null;
  }

  private void before() {
    System.out.println("媒婆帮你找对象");
    System.out.println("开始物色");
  }

  private void after() {
    System.out.println("如果合适就准备办事");
  }
}
