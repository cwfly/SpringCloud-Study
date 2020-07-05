package com.cw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cwfly
 * @date 2020/7/3
 */
@Component
public class MyLoadBalance implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current+1;
        }while (!atomicInteger.compareAndSet(current, next));
        System.out.println("**********第几次访问， 次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance getInstances(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}
