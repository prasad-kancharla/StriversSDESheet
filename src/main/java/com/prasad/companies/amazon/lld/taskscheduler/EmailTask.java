package com.prasad.companies.amazon.lld.taskscheduler;

import java.time.LocalDateTime;

public class EmailTask extends Task {

    private String emailBody;
    private String recipient;
    private String subject;

    public EmailTask(String emailBody, String recipient, String subject, LocalDateTime scheduledTime) {
        super(scheduledTime);
        this.emailBody = emailBody;
        this.recipient = recipient;
        this.subject = subject;
    }

    @Override
    void execute() {
        System.out.println("Sending email with email body: " + emailBody + "to emailId " + recipient);
    }

    public String getEmailBody() {
        return emailBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

}
