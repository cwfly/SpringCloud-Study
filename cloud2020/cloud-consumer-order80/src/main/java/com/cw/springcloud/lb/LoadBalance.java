package com.cw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author cwfly
 * @date 2020/7/3
 */
public interface LoadBalance {
    ServiceInstance getInstances(List<ServiceInstance> instances);
}
