package com.prasad.companies.amazon.lld.taskscheduler;

import java.time.LocalDateTime;

public abstract class Task {
    private LocalDateTime scheduledTime;
    abstract void execute();

    public Task (LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getScheduledTime() {
        return this.scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
