package com.johnny.springboot.springbatch.processor;

import com.johnny.springboot.springbatch.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author johnny
 * @create 2019-04-01 下午5:00
 *
 *
 * 转换处理器  输入 转换 输出
 **/
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person,Person> {


    /**
     * 就是这个转换 不一定要相同的类型
     * There is no requirement that the input and output types be the same
     */

    @Override
    public Person process(Person person) throws Exception {

        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName,lastName);

        log.info("Converting: {}" , transformedPerson);

        return transformedPerson;
    }



}