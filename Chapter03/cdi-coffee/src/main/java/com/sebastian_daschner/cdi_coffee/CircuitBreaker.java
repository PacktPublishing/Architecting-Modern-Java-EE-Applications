package com.sebastian_daschner.cdi_coffee;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.concurrent.atomic.AtomicInteger;

@Interceptor
public class CircuitBreaker {

    private static final int FAILURE_THRESHOLD = 3;
    private static final int RECOVERY_TIME = 300;

    private AtomicInteger failures;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) {
        interceptOpenCircuit();
        try {
            return context.proceed();
        } catch (Exception e) {
            // record exception

            failures.incrementAndGet();
            return null;
        }
    }

}
