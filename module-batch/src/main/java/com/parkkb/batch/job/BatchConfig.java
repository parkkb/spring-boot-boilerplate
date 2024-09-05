package com.parkkb.batch.job;

import com.parkkb.batch.step.tasklet.LastTasklet;
import com.parkkb.batch.step.tasklet.NextTasklet;
import com.parkkb.batch.step.tasklet.StartTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final JobRepository jobRepository;
    private final StartTasklet startTasklet;
    private final NextTasklet nextTasklet;
    private final LastTasklet lastTasklet;
    private final PlatformTransactionManager platformTransactionManager;


    @Bean
    public Job testJob(){
        return new JobBuilder("testJob", jobRepository)
                .start(startStep())
                .build();
    }

    @Bean
    public Step startStep(){
        return new StepBuilder("startStep", jobRepository)
                .tasklet(startTasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Step nextStep(){
        return new StepBuilder("nextStep", jobRepository)
                .tasklet(nextTasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Step lastStep(){
        return new StepBuilder("lastStep", jobRepository)
                .tasklet(lastTasklet, platformTransactionManager)
                .build();
    }
}
