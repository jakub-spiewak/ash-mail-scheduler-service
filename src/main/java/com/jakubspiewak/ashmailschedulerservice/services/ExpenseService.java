package com.jakubspiewak.ashmailschedulerservice.services;

import com.jakubspiewak.ashapimodellib.model.expense.ApiExpenseCreateRequest;
import com.jakubspiewak.ashapimodellib.model.expense.ApiExpenseGetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient("ash-expense-service")
public interface ExpenseService {
  @PostMapping
  UUID create(@RequestBody ApiExpenseCreateRequest request);

  @GetMapping
  List<ApiExpenseGetResponse> readAll();

  @PutMapping("/{id}")
  void update(@PathVariable UUID id, @RequestBody ApiExpenseCreateRequest request);

  @DeleteMapping("/{id}")
  void delete(@PathVariable UUID id);
}
