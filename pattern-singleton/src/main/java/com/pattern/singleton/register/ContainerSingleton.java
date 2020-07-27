package com.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 容器缓存式单例
 * @author Jenson
 * @date 2020/7/16 14:41
 */
public class ContainerSingleton {
  private ContainerSingleton(){}
  private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();
  public static Object getInstance(String className) {
    synchronized (ioc) {
      if(!ioc.containsKey(className)) {
        Object obj = null;
        try{
          obj = Class.forName(className);
          ioc.put(className, obj);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return obj;
      } else {
        return ioc.get(className);
      }
    }
  }
}
