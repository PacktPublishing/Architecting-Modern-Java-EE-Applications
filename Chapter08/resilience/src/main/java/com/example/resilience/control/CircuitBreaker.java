package com.example.resilience.control;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class CircuitBreaker {

    // ...

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) {
        // close circuit after recovery time

        // if circuit is open
        //   return null;

        try {
            return context.proceed();
        } catch (Exception e) {

            // record exception
            // increase failure counter
            // open circuit if failure exceeds threshold

            return null;
        }
    }

}
