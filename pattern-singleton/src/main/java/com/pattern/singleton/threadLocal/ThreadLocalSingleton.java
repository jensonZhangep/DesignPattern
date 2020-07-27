package com.pattern.singleton.threadLocal;

/*
 * ThreadLocal 不能保证其创建的对象是全局唯一，但是能保证在单个线程中是唯一的
 * @author Jenson
 * @date 2020/7/16 14:46
 */
public class ThreadLocalSingleton {
  private ThreadLocalSingleton(){}
  private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>() {
    @Override
    protected ThreadLocalSingleton initialValue() {
      return new ThreadLocalSingleton();
    }
  };

  public static ThreadLocalSingleton getInstance(){
    return threadLocalInstance.get();
  }
}
