package com.pattern.singleton.hungry;

/*
 * 饿汉式单例
 * @author Jenson
 * @date 2020/7/16 10:23
 */
public class HungrySingleton {
  private static final HungrySingleton hungrySingleton = new HungrySingleton();
  private HungrySingleton(){}
  public static HungrySingleton getInstance() {
    return hungrySingleton;
  }

}
