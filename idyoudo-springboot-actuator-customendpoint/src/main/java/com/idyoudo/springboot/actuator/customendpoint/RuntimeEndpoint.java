package com.idyoudo.springboot.actuator.customendpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回程序已经持续运行的时间
 */
@Component
@WebEndpoint(id = "runtime")
public class RuntimeEndpoint {
    public long starttime = 0L;
    public Map runtimeMap = new HashMap<>();

    public RuntimeEndpoint(){
        starttime = System.currentTimeMillis() ;
        runtimeMap.put("startTime" , starttime);
        runtimeMap.put("currentTime" , System.currentTimeMillis());
        runtimeMap.put("interval" , 0);
    }

    @ReadOperation
    public Map runtime() {
        long currentTime = System.currentTimeMillis() ;
        long interval = currentTime - starttime;

        runtimeMap.put("currentTime" , currentTime);
        runtimeMap.put("interval" , interval);

        return  runtimeMap;
    }
    @ReadOperation
    public Map runtimeKey(@Selector String name) {
        Map runtimeKey = new HashMap<>();
        runtimeKey.put(name,runtimeMap.get(name)) ;
        return  runtimeKey;
    }

    @WriteOperation
    public Map writeRuntimeKey(@Selector String name, String value) {
        runtimeMap.put(name, value);
        return  runtimeMap;
    }

    @DeleteOperation
    public Map deleteRuntimeKey(@Selector String name) {
        runtimeMap.remove(name);
        return  runtimeMap;
    }


}