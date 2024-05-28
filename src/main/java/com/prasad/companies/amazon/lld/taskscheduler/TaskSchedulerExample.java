package com.prasad.companies.amazon.lld.taskscheduler;

import java.time.LocalDateTime;

public class TaskSchedulerExample {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = TaskScheduler.getInstance();
        Task emailTask = TaskFactory.createEmailTask("Test body", "abc", "Test mail", LocalDateTime.now().plusMinutes(1));
        taskScheduler.scheduleTask(emailTask);
        taskScheduler.run();
    }

}
