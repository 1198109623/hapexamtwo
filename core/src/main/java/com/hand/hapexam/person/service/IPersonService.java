package com.hand.hapexam.person.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.hapexam.person.dto.Person;

import java.util.List;

public interface IPersonService extends IBaseService<Person>, ProxySelf<IPersonService>{
    int updateList(List<Person> jobList);
}