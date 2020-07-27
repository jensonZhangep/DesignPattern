package com.pattern.proxy.simpleProxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:28
 */
public class Client {
  public static void main(String[] args) {
    Proxy proxy = new Proxy(new RealSubject());
    proxy.request();
  }
}
