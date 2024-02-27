package com.joaquin.config;

import com.joaquin.entities.Person;
import com.joaquin.steps.PersonItemProcessor;
import com.joaquin.steps.PersonItemReader;
import com.joaquin.steps.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public PersonItemReader itemReader(){
        return new PersonItemReader();
    }

    @Bean
    public PersonItemWriter itemWriter(){
        return new PersonItemWriter();
    }

    @Bean
    public PersonItemProcessor itemProcessor(){
        return new PersonItemProcessor();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setQueueCapacity(1000);
        return taskExecutor;
    }

    @Bean
    public Step readFile(){
        return stepBuilderFactory.get("readFile")
                .<Person, Person>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job job(){
        return jobBuilderFactory.get("readFileWithChunk")
                .start(readFile())
                .build();
    }

}
