package com.jakubspiewak.ashmailschedulerservice.services;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentGetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ash-document-service")
public interface DocumentService {
  @PostMapping
  void save(ApiDocumentCreateRequest request);

  @GetMapping
  Page<ApiDocumentGetResponse> get(
      @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size);
}
