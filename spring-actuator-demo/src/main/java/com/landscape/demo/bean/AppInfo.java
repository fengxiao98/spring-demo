package com.landscape.demo.bean;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.xml.ws.WebEndpoint;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengxiao
 * @date 2020-07-18
 */
@Component
@Endpoint(id = "appInfo")
public class AppInfo {
    private final HashMap<String, String> map = new HashMap<>();

    public AppInfo() {
        map.put("ApplicationName", "ActuatorApplication");
        map.put("Description", "Spring Boot Actuator Demo");
    }

    @ReadOperation
    public Map<String, String> appInfo() {
        return map;
    }

    @WriteOperation
    public String updateInfo(
            @Nullable String key,
            @Nullable String value

    ) {
        return map.put(key, value);
    }

    @DeleteOperation
    public String deleteInfo(@Nullable String key) {
        return map.remove(key);
    }
}
