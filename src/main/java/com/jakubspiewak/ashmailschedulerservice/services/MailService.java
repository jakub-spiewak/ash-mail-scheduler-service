package com.jakubspiewak.ashmailschedulerservice.services;

import com.jakubspiewak.ashapimodellib.model.mail.ApiFetchMailRequest;
import com.jakubspiewak.ashapimodellib.model.mail.ApiFetchMailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

 @FeignClient(name = "ash-mail-service")
public interface MailService {

  @PostMapping("/fetch")
  List<ApiFetchMailResponse> fetchMails(@RequestBody ApiFetchMailRequest request);
}
