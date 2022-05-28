package com.softwarefoundtion.helloworld.batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimeHelloWorldJob() {
        log.info("imprimeHelloWorldJob");
        return jobBuilderFactory
                .get("imprimeHelloWorldJob")
                .start(imprimeHelloWorldStep())
                .build();

    }

    private Step imprimeHelloWorldStep() {
        log.info("imprimeHelloWorldStep");
        return stepBuilderFactory
                .get("imprimeHelloWorldStep")
                .tasklet(imprimeHelloWorldTasklet())
                .build();
    }

    private Tasklet imprimeHelloWorldTasklet(){
        log.info("imprimeHelloWorldTasklet");
     return (contribution, chunkContext) -> {
         System.out.println("Hello World!!!");
         return RepeatStatus.FINISHED;
     };
    }

}
