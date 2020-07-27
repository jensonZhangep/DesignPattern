package com.pattern.singleton.register;

/*
 * 枚举式单例
 * @author Jenson
 * @date 2020/7/16 12:22
 */
public enum EnumSingleton {
  INSTANCE;
  //如果攻击该类本身还是无法避免的
  private Object data;
  EnumSingleton() {
    data = new Object();
  }
  public static EnumSingleton getInstance(){
    return INSTANCE;
  }
}
