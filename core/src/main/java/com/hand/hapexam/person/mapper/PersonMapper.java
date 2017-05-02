package com.hand.hapexam.person.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hapexam.person.dto.Person;

public interface PersonMapper extends Mapper<Person>{
    int myUpdate(Person person);
}