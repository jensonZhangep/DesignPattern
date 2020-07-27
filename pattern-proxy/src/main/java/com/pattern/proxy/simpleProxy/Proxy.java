package com.pattern.proxy.simpleProxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:27
 */
public class Proxy implements Subject {
  private Subject subject;

  public Proxy(Subject subject) {
    this.subject = subject;
  }

  public void request() {
    before();
    subject.request();
    after();
  }

  private void before(){
    System.out.println("called before request().");
  }

  private void after() {
    System.out.println("called after request().");
  }
}
