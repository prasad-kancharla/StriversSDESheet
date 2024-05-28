package com.prasad.companies.amazon.lld.taskscheduler;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class TaskScheduler {

    private static TaskScheduler taskScheduler;

    PriorityQueue<Task> taskQueue;

    private TaskScheduler() {
        taskQueue = new PriorityQueue<>((task1, task2) -> task1.getScheduledTime().compareTo(task2.getScheduledTime()));
    }

    public static TaskScheduler getInstance() {
        if (taskScheduler == null) {
            synchronized (TaskScheduler.class) {
                if (taskScheduler == null) {
                    taskScheduler = new TaskScheduler();
                }
            }
        }
        return taskScheduler;
    }

    public void scheduleTask(Task task) {
        taskQueue.offer(task);
    }

    public void run() {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.peek();
            if (LocalDateTime.now().isAfter(task.getScheduledTime())) {
                taskQueue.poll();
                task.execute();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    System.out.println("Scheduler is interrupted");
                }
            }
        }
    }

}
