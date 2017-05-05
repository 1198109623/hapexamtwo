package com.hand.hapexam.person.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.hapexam.person.dto.Person;

import java.util.List;

public interface IPersonService extends IBaseService<Person>, ProxySelf<IPersonService>{
    int updateList(List<Person> jobList);
<<<<<<< HEAD
    List<Person> getAllByExcel(String file);
=======
>>>>>>> 99a32cf3dbe2862262b795f13c8c21c22660794c
}