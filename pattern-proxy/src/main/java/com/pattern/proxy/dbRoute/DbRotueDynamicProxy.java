package com.pattern.proxy.dbRoute;

import com.pattern.proxy.dbRoute.bean.Order;
import com.pattern.proxy.dbRoute.proxy.OrderServiceDynamicProxy;
import com.pattern.proxy.dbRoute.service.IOrderService;
import com.pattern.proxy.dbRoute.service.impl.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:13
 */
public class DbRotueDynamicProxy {
  public static void main(String[] args) {
    Order order = new Order();
    order.setCreateTime(new Date().getTime());
    IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
    orderService.createOrder(order);
  }
}
