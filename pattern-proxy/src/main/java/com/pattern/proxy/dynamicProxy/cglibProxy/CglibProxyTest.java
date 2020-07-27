package com.pattern.proxy.dynamicProxy.cglibProxy;

import com.pattern.proxy.dynamicProxy.jdkProxy.Customer;

/*
 *
 * @author Jenson
 * @date 2020/7/23 17:38
 */
public class CglibProxyTest {
  public static void main(String[] args) {
    try {
      Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
      obj.findLove();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
