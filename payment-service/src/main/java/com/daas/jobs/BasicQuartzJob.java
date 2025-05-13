package com.daas.jobs;

import com.daas.entity.QuartzJob;
import io.quarkus.scheduler.Scheduled;
import jakarta.transaction.Transactional;

public class BasicQuartzJob {
    @Transactional
    @Scheduled(every = "10s", identity = "basic-quartz-job")
    void schedule() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.persist();
    }
}