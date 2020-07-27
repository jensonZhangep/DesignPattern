package com.pattern.proxy.staticProxy;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:31
 */
public class Father implements Person {
  private Son son;

  public Father(Son son) {
    this.son = son;
  }

  public void findLove() {
    System.out.println("父亲帮忙，物色对象");
    son.findLove();
    System.out.println("同意交往");
  }
}
