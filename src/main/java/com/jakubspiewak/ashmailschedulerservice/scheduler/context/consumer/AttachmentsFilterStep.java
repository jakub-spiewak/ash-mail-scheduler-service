package com.jakubspiewak.ashmailschedulerservice.scheduler.context.consumer;

import com.jakubspiewak.ashapimodellib.model.expense.ApiExpenseGetResponse;
import com.jakubspiewak.ashmailschedulerservice.scheduler.context.Context;
import com.jakubspiewak.ashmailschedulerservice.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Consumer;

@Order(5)
@Component
@RequiredArgsConstructor
public class AttachmentsFilterStep implements Consumer<Context> {

    private final ExpenseService expenseService;

    @Override
    public void accept(Context context) {
        expenseService.readAll().stream()
                        .filter(this::hasMailConfig);

        context.getAttachmentsPatterns().put()
        context.getMails();
    }

    private boolean hasMailConfig(ApiExpenseGetResponse expense) {
        return Objects.nonNull(expense.getMailConfig());
    }
}
