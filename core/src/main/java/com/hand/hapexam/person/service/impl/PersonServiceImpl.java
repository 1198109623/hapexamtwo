package com.hand.hapexam.person.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.hapexam.person.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.hapexam.person.dto.Person;
import com.hand.hapexam.person.service.IPersonService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person> implements IPersonService{
    @Autowired
    private PersonMapper personMapper;

    @Override
    public int updateList(List<Person> personList){
        personList.forEach(fruit -> checkOvn(personMapper.myUpdate(fruit),fruit));
        return  personList.size();
    }
}