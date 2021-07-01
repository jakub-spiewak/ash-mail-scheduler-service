package com.jakubspiewak.ashmailschedulerservice.scheduler.context.consumer;

import com.jakubspiewak.ashapimodellib.model.expense.ApiExpenseGetResponse;
import com.jakubspiewak.ashapimodellib.model.expense.MailExpenseConfig;
import com.jakubspiewak.ashmailschedulerservice.scheduler.context.Context;
import com.jakubspiewak.ashmailschedulerservice.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Order(3)
@Component
@RequiredArgsConstructor
public class ExpensesStep implements Consumer<Context> {

  private final ExpenseService expenseService;

  @Override
  public void accept(Context context) {
    final var expenses = expenseService.readAll();

//    expenses.stream().collect(Collectors.toMap(Api))

    expenses.stream()
        .map(ApiExpenseGetResponse::getMailConfig)
        .map(MailExpenseConfig::getMailAddress)
        .forEach(context.getMailsAddresses()::add);
  }
}
