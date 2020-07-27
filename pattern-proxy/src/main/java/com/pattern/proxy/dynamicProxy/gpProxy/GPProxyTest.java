package com.pattern.proxy.dynamicProxy.gpProxy;

import com.pattern.proxy.dynamicProxy.jdkProxy.Customer;
import com.pattern.proxy.staticProxy.Person;

/*
 *
 * @author Jenson
 * @date 2020/7/23 17:05
 */
public class GPProxyTest {
  public static void main(String[] args) {
    try {
      Person person = (Person) new GPMeipo().getInstance(new Customer());
      System.out.println(person.getClass());
      person.findLove();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
