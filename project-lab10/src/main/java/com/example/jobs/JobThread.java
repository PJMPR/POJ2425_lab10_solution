package com.example.jobs;

public class JobThread extends Thread {
    private final Job job;

    public JobThread(Job job) {
        this.job = job;
    }

    public void run() {
        job.run();
    }
}
