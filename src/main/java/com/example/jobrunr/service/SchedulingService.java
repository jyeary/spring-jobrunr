package com.example.jobrunr.service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 */
@Service
@Slf4j
public class SchedulingService {

    @Autowired
//    @Qualifier("custom-sql-scheduler")
//    @Qualifier("custom-in-memory-scheduler")
    private JobScheduler jobScheduler;

    public void schedule() {
        log.info("Schedule Fired. Setting up jobs");
        jobScheduler.schedule(Instant.now(), () -> this.execute());
        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.every5minutes(), () -> this.execute(Instant.now().toString()));
        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.weekly(DayOfWeek.MONDAY, 8), () -> this.execute(Instant.now().toString()));
        jobScheduler.enqueue(() -> this.execute("Enqueued Job"));
    }

    @Job(name = "Hello World Job")
    public void execute() {
        execute("Hello World!");
    }

    @Job(name = "Parametrized Job")
    public void execute(String input) {
        log.info("Parameterized job with input {}", input);
        try {
            log.info("{}", input);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error while executing job", e);
        } finally {
            log.info("Parameterized job with input {} has finished...", input);
        }
    }

}
