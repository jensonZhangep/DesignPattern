package com.pattern.proxy.dynamicProxy.jdkProxy;

import com.pattern.proxy.staticProxy.Job;
import com.pattern.proxy.staticProxy.Person;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:01
 */
public class Customer implements Person, Job {
  public void findLove() {
    System.out.println("肤白");
    System.out.println("貌美");
    System.out.println("大长腿");
    System.out.println("前凸后翘");
  }

  @Override
  public void toWork() {
    System.out.println("搬砖");
  }
}
