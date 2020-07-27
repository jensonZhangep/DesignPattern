package com.pattern.proxy.dbRoute.db;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:41
 */
public class DynamicDataSourceEntry {
  public static final String DEFAULT_SOURCE = null;
  public static final ThreadLocal<String> local = new ThreadLocal<String>();

  private DynamicDataSourceEntry(){}

  public static void clear() {
    local.remove();
  }

  public static String get() {
    return local.get();
  }

  public static void restore() {
    local.set(DEFAULT_SOURCE);
  }

  public static void set(String source) {
    local.set(source);
  }

  public static void set(int year) {
    local.set("DB_" + year);
  }
}
