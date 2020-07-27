package com.pattern.singleton.lazy;

/*
 * 静态内部类单例模式
 * 兼顾饿汉模式的内存浪费，也兼顾synchronized的性能问题
 * @author Jenson
 * @date 2020/7/16 10:49
 */
public class LazyInnerClassSingleton {
  private LazyInnerClassSingleton(){
    //防止通过反射破坏单例
    if(LazyHolder.LAZY != null) {
      throw new RuntimeException("不允许创建多个实例");
    }
  }

  public static final LazyInnerClassSingleton getInstance() {
    return LazyHolder.LAZY;
  }

  private static class LazyHolder {
    public static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
  }
}
