package com.pattern.singleton;

import com.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

/*
 * 反射破坏单例
 * @author Jenson
 * @date 2020/7/16 11:42
 */
public class LazyInnerClassSingletonTest {
  public static void main(String[] args) {
    try {
      Class<?> clazz = LazyInnerClassSingleton.class;
      Constructor c = clazz.getDeclaredConstructor();
      c.setAccessible(true);
      Object o1 = c.newInstance();
      Object o2 = c.newInstance();
      System.out.println(o1 == o2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
