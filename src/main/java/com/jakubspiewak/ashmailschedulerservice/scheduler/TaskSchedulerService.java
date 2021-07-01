package com.jakubspiewak.ashmailschedulerservice.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@EnableScheduling
@RequiredArgsConstructor
public class TaskSchedulerService {

    private final MailSchedulerService mailSchedulerService;

//    @Scheduled(cron = "0 * * * * *")
//    public void update() {
//        mailSchedulerService.updateDocuments();
//    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent() {
        mailSchedulerService.updateDocuments();
    }
}
