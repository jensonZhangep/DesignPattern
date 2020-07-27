package com.pattern.proxy.simpleProxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:26
 */
public class RealSubject implements Subject {
  public void request() {
    System.out.println("real service is called");
  }
}
