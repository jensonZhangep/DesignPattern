package com.pattern.proxy.dynamicProxy.jdkProxy;

import com.pattern.proxy.staticProxy.Job;
import com.pattern.proxy.staticProxy.Person;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:03
 */
public class JdkProxyTest {
  public static void main(String[] args) {
    Person person = (Person) new JdkMeipo().getInstance(new Customer());
    person.findLove();

    Job job = (Job) new JdkMeipo().getInstance(new Customer());
    job.toWork();
  }
}
