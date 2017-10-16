package com.example.timed_execution.mses;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class Periodic {

    @Resource
    ManagedScheduledExecutorService mses;

    public void startAsyncJobs() {
        mses.schedule(this::execute, 1, TimeUnit.SECONDS);
        mses.scheduleAtFixedRate(this::execute, 6, 1, TimeUnit.SECONDS);
    }

    private void execute() {
        // ...
    }

}
