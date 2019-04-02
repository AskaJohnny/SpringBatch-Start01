package com.johnny.springboot.springbatch.listener;

import com.johnny.springboot.springbatch.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author johnny
 * @create 2019-04-02 上午9:41
 **/
@Component
@Slf4j
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("job执行之后 ...");


            jdbcTemplate.query("select first_name , last_name from people",
                    (rs, row) -> new Person(
                            rs.getString(1),
                            rs.getString(2)))
                    .forEach(person -> log.info(" Found < " + person + " > in the database"));
        }

    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("job 执行之前  。。。");
    }
}