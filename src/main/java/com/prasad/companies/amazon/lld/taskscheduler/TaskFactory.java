package com.prasad.companies.amazon.lld.taskscheduler;

import java.time.LocalDateTime;

public class TaskFactory {

    public static EmailTask createEmailTask(String emailBody, String recipient, String subject, LocalDateTime scheduledTime) {
        return new EmailTask(emailBody, recipient, subject, scheduledTime);
    }

}
