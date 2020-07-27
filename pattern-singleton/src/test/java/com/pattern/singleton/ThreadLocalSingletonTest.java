package com.pattern.singleton;

import com.pattern.singleton.threadLocal.ThreadLocalSingleton;

/*
 *
 * @author Jenson
 * @date 2020/7/16 14:51
 */
public class ThreadLocalSingletonTest {
  public static void main(String[] args) {

    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());

    Thread t1 = new Thread(new ExectorThread());
    Thread t2 = new Thread(new ExectorThread());
    t1.start();
    t2.start();
    System.out.println("End");

  }
}
