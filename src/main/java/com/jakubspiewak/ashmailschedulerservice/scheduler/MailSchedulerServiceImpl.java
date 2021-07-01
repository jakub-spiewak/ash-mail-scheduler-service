package com.jakubspiewak.ashmailschedulerservice.scheduler;

import com.jakubspiewak.ashmailschedulerservice.scheduler.context.Context;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailSchedulerServiceImpl implements MailSchedulerService {

  private final List<Consumer<Context>> consumers;

  @Override
  public void updateDocuments() {
    final var context = new Context();
    log.info("Starting scheduled task...");
    consumers.forEach(context::update);
  }
}
