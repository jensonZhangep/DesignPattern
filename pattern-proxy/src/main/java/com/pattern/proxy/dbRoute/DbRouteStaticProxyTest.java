package com.pattern.proxy.dbRoute;

import com.pattern.proxy.dbRoute.bean.Order;
import com.pattern.proxy.dbRoute.proxy.OrderServiceStaticProxy;
import com.pattern.proxy.dbRoute.service.IOrderService;
import com.pattern.proxy.dbRoute.service.impl.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:51
 */
public class DbRouteStaticProxyTest {
  public static void main(String[] args) {
    Order order = new Order();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    order.setCreateTime(new Date().getTime());
    IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
    orderService.createOrder(order);
  }
}
