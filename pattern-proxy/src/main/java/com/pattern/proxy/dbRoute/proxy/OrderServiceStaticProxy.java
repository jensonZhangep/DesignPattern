package com.pattern.proxy.dbRoute.proxy;

import com.pattern.proxy.dbRoute.bean.Order;
import com.pattern.proxy.dbRoute.db.DynamicDataSourceEntry;
import com.pattern.proxy.dbRoute.service.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * @author Jenson
 * @date 2020/7/23 15:46
 */
public class OrderServiceStaticProxy implements IOrderService {

  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
  private IOrderService orderService;

  public OrderServiceStaticProxy(IOrderService orderService) {
    this.orderService = orderService;
  }

  public int createOrder(Order order) {
    before();
    long time = order.getCreateTime();
    Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
    System.out.println("静态代理自动分配到【DB_" + dbRouter + "】数据源处理数据");
    DynamicDataSourceEntry.set(dbRouter);
    orderService.createOrder(order);
    after();
    return 0;
  }

  private void before() {
    System.out.println("proxy before method.");
  }

  private void after() {
    System.out.println("proxy after method.");
  }
}
