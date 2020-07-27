package com.pattern.proxy.dbRoute.service;

import com.pattern.proxy.dbRoute.bean.Order;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:38
 */
public interface IOrderService {
  int createOrder(Order order);
}
