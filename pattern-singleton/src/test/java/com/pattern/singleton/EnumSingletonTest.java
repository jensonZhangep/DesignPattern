package com.pattern.singleton;

import com.pattern.singleton.register.EnumSingleton;

/*
 *
 * @author Jenson
 * @date 2020/7/16 12:23
 */
public class EnumSingletonTest {
  public static void main(String[] args) {
    EnumSingleton s1 = EnumSingleton.getInstance();
    EnumSingleton s2 = EnumSingleton.getInstance();
    System.out.println(s1 == s2);
  }
}
