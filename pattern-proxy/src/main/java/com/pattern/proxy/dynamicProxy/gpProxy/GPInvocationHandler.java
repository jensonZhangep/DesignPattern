package com.pattern.proxy.dynamicProxy.gpProxy;

import java.lang.reflect.Method;

/*
 *
 * @author Jenson
 * @date 2020/7/23 16:18
 */
public interface GPInvocationHandler {
  Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
