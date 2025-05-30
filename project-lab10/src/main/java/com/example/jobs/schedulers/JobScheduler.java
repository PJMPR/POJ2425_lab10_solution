package com.example.jobs.schedulers;

import com.example.TimeEvent;
import com.example.jobs.Job;

import java.time.LocalDateTime;

public interface JobScheduler {
    JobScheduler forJob(Job job);

    JobScheduler startsAt(LocalDateTime startTime);

    JobScheduler everySeconds(int seconds);

    JobScheduler repeatTimes(int maxCount);

    void listenTo(TimeEvent event);
}
