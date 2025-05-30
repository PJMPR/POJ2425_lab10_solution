package com.example.jobs.schedulers;

import com.example.TimeEvent;
import com.example.jobs.Job;
import com.example.jobs.JobThread;

import java.time.LocalDateTime;

public class SimpleJobScheduler implements JobScheduler {

    private Job job;
    private LocalDateTime startTime = LocalDateTime.now();
    private int interval = 1;
    private int count = -1;
    private int counter;

    @Override
    public JobScheduler forJob(Job job) {
        this.job = job;
        return this;
    }

    @Override
    public JobScheduler startsAt(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public JobScheduler everySeconds(int seconds) {
        this.interval = seconds;
        return this;
    }

    @Override
    public JobScheduler repeatTimes(int maxCount) {
        this.count = maxCount;
        return this;
    }

    @Override
    public void listenTo(TimeEvent event) {
        if(job == null) return;
        if(startTime.isAfter(event.getTime())) return;
        if(count != -1 && counter>count) return;
        counter++;
        startTime = startTime.plusSeconds(interval);
        new JobThread(job).start();
    }
}
