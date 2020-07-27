package com.pattern.singleton;

/*
 *
 * @author Jenson
 * @date 2020/7/16 10:35
 */
public class LazySimpleSingletonTest {
  public static void main(String[] args) {
    Thread t1 = new Thread(new ExectorThread());
    Thread t2 = new Thread(new ExectorThread());
    t1.start();
    t2.start();
    System.out.println("End");
  }
}
