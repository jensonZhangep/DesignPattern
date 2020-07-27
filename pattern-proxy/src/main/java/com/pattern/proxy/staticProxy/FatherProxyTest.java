package com.pattern.proxy.staticProxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:33
 */
public class FatherProxyTest {

  public static void main(String[] args) {
    Father father = new Father(new Son());
    father.findLove();
  }
}
