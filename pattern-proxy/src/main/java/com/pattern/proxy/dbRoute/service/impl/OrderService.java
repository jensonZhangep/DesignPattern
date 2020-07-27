package com.pattern.proxy.dbRoute.service.impl;

import com.pattern.proxy.dbRoute.bean.Order;
import com.pattern.proxy.dbRoute.dao.OrderDao;
import com.pattern.proxy.dbRoute.service.IOrderService;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:39
 */
public class OrderService implements IOrderService {

  private OrderDao orderDao;

  public OrderService() {
    orderDao = new OrderDao();
  }

  public int createOrder(Order order) {
    System.out.println("创建订单");
    return orderDao.insert(order);
  }
}
