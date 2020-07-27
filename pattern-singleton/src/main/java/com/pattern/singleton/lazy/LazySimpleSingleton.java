package com.pattern.singleton.lazy;

/*
 * 懒汉式单例
 * @author Jenson
 * @date 2020/7/16 10:27
 */
public class LazySimpleSingleton {
  private static LazySimpleSingleton singleton;
  private LazySimpleSingleton(){}

  //加上synchronized之后就是线程安全的，但是如果大量并发的时候会阻塞，导致性能下降(类阻塞)
  public synchronized static LazySimpleSingleton getInstance(){
    if(singleton == null) {
      singleton = new LazySimpleSingleton();
    }
    return singleton;
  }
}
