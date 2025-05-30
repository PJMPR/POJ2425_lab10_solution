package com.example.jobs;

public class DescribedJob implements Job {
    private final String description;

    public DescribedJob(String description) {
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println(description);
    }
}
