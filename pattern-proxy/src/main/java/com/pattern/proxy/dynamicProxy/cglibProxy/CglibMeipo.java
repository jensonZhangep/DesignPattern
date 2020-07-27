package com.pattern.proxy.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
 *
 * @author Jenson
 * @date 2020/7/23 17:32
 */
public class CglibMeipo implements MethodInterceptor {

  public Object getInstance(Class<?> clazz) throws Exception {
    Enhancer enhancer = new Enhancer();
    //把那个类设置成即将生成的新父类
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    before();
    Object object = methodProxy.invokeSuper(o, objects);
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
