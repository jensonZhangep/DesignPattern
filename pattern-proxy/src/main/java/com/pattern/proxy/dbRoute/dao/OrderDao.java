package com.pattern.proxy.dbRoute.dao;

import com.pattern.proxy.dbRoute.bean.Order;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:37
 */
public class OrderDao {
  public int insert(Order order) {
    System.out.println("订单新建成功");
    return 1;
  }
}
