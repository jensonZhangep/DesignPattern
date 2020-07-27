package com.pattern.singleton;

import com.pattern.singleton.seriable.SeriableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 序列化破坏单例（需要类实现了Serializable就）
 * 当我们将一个单例对象创建好，有时候需要将对象序列化然后写入到磁盘，下次使用时
 * 再从磁盘中读取到对象，反序列化转化为内存对象。反序列化后的对象会重新分配内存，
 * 即重新创建。那如果序列化的目标的对象为单例对象，就违背了单例模式的初衷，相当
 * 于破坏了单例
 * @author Jenson
 * @date 2020/7/16 11:56
 */
public class SeriableSingletonTest {
  public static void main(String[] args) {
    SeriableSingleton s1 = null;
    SeriableSingleton s2 = SeriableSingleton.getInstance();

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream("SeriableSingleton.obj");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(s2);
      oos.flush();
      oos.close();
      fos.close();

      FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
      ObjectInputStream ois = new ObjectInputStream(fis);
      s1 = (SeriableSingleton) ois.readObject();
      ois.close();
      fis.close();

      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s1 == s2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
