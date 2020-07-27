package com.pattern.singleton.lazy;

/*
 * 双重验证单例模式
 * @author Jenson
 * @date 2020/7/16 10:45
 */
public class LazyDoubleCheckSingleton {

  private static LazyDoubleCheckSingleton singleton;
  private LazyDoubleCheckSingleton(){}

  //方法内部阻塞
  public synchronized static LazyDoubleCheckSingleton getInstance(){
    if(singleton == null) {
      synchronized (LazyDoubleCheckSingleton.class) {
        if(singleton == null) {
          singleton = new LazyDoubleCheckSingleton();
        }
      }
    }
    return singleton;
  }
}
