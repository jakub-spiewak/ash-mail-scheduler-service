package com.jakubspiewak.ashmailschedulerservice.scheduler.context.consumer;

import com.jakubspiewak.ashapimodellib.model.mail.ApiFetchMailRequest;
import com.jakubspiewak.ashapimodellib.model.mail.ApiFetchMailResponse;
import com.jakubspiewak.ashapimodellib.model.mail.MailQueryParams;
import com.jakubspiewak.ashapimodellib.model.util.DateRange;
import com.jakubspiewak.ashmailschedulerservice.scheduler.context.Context;
import com.jakubspiewak.ashmailschedulerservice.services.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Consumer;

@Slf4j
@Order(4)
@Component
@RequiredArgsConstructor
public class MailsFetchStep implements Consumer<Context> {

  private final MailService mailService;

  @Override
  public void accept(Context context) {
    final var request = createRequest(context);

    mailService.fetchMails(request).stream()
        .filter(this::hasAttachments)
        .forEach(context.getMails()::add);
  }

  private ApiFetchMailRequest createRequest(Context context) {
    return ApiFetchMailRequest.builder()
        .configuration(context.getMailConfiguration())
        .query(
            MailQueryParams.builder()
                .date(DateRange.builder().min(context.getDate()).max(LocalDate.now()).build())
                .from(context.getMailsAddresses())
                .build())
        .build();
  }

  private boolean hasAttachments(ApiFetchMailResponse apiFetchMailResponse) {
    return !apiFetchMailResponse.getAttachments().isEmpty();
  }
}
