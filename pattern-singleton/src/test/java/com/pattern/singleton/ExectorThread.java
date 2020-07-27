package com.pattern.singleton;

import com.pattern.singleton.lazy.LazySimpleSingleton;
import com.pattern.singleton.threadLocal.ThreadLocalSingleton;

/*
 *
 * @author Jenson
 * @date 2020/7/16 10:34
 */
public class ExectorThread implements Runnable {
  public void run() {
    ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
    System.out.println(Thread.currentThread().getName() + ":" + singleton);
  }
}
