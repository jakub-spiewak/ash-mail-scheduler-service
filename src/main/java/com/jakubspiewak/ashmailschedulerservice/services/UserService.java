package com.jakubspiewak.ashmailschedulerservice.services;

import com.jakubspiewak.ashapimodellib.model.user.ApiUserGetMailConfigurationResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "ash-user-service")
public interface UserService {
    @GetMapping("/mail/configuration")
    List<ApiUserGetMailConfigurationResponse> getAllUsersWithMailConfiguration();
}
