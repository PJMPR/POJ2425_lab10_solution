package com.example.jobs;

import java.time.LocalDateTime;

public class ShowTimeJob implements Job {
    private LocalDateTime time;

    public ShowTimeJob(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setJobTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(time);
    }
}
