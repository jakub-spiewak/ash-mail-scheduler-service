package com.jakubspiewak.ashmailschedulerservice.scheduler.context;

import com.jakubspiewak.ashapimodellib.model.mail.ApiFetchMailResponse;
import com.jakubspiewak.ashapimodellib.model.mail.MailConfiguration;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

@Data
public class Context {

  private LocalDate date;
  private MailConfiguration mailConfiguration;

  @Setter(AccessLevel.PRIVATE)
  private List<String> mailsAddresses = emptyList();

  @Setter(AccessLevel.PRIVATE)
  private List<ApiFetchMailResponse> mails = emptyList();

  /**
   * Map contains attachments patterns.
   *
   * <br/> <br/>
   *
   * <i>key: </i> mail address <br/>
   * <i>value: </i> corresponding attachment pattern
   */
  @Setter(AccessLevel.PRIVATE)
  private Map<String, String> attachmentsPatterns = emptyMap();

  public void update(Consumer<Context> consumer) {
    consumer.accept(this);
  }
}
