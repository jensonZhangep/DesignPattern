package com.pattern.singleton.seriable;

import java.io.Serializable;

/*
 *
 * @author Jenson
 * @date 2020/7/16 11:51
 */
public class SeriableSingleton implements Serializable {
  //序列化就是把内存中的状态转换成字节码的形式
  //从而转换一个IO流，写入到其他地方（可以是磁盘。网络IO）
  //内存中的状态永久保留下来了

  //反序列化
  //将已经持久化的字节码转换成IO流
  //通过IO流的读取，进而读取内容转换为Java对象
  //在转换过程中会重新创建对象
  private static SeriableSingleton INSTANCE = new SeriableSingleton();
  private SeriableSingleton(){
  }

  public static SeriableSingleton getInstance() {
    return INSTANCE;
  }

  //改方法保证序列化破坏的情况下也能实现单例
  //缺点：实际上还会创建多次，只不过新创建的对象没有返回
  private Object readResolve() {
    return INSTANCE;
  }
}
