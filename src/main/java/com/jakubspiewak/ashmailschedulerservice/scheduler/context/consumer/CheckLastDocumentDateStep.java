package com.jakubspiewak.ashmailschedulerservice.scheduler.context.consumer;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentGetResponse;
import com.jakubspiewak.ashmailschedulerservice.scheduler.context.Context;
import com.jakubspiewak.ashmailschedulerservice.services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Consumer;

@Slf4j
@Order(2)
@Component
@RequiredArgsConstructor
public class CheckLastDocumentDateStep implements Consumer<Context> {

  private final DocumentService documentService;

  @Override
  public void accept(Context context) {
    final var date =
        documentService.get(0, 1).stream()
            .findFirst()
            .map(ApiDocumentGetResponse::getDate)
            .orElse(LocalDate.now().withDayOfMonth(1));

    context.setDate(date);

    log.info(String.valueOf(context));
  }
}
