package com.hand.hapexam.person.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.hapexam.person.mapper.PersonMapper;

import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.hapexam.person.dto.Person;
import com.hand.hapexam.person.service.IPersonService;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
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

    @Override
    public List<Person> getAllByExcel(String file) {
        List<Person> list=new ArrayList<Person>();
        try {
            Workbook rwb= Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    // String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String phone=rs.getCell(j++, i).getContents();
                    String email=rs.getCell(j++, i).getContents();
                    String address=rs.getCell(j++, i).getContents();
                    String gender=rs.getCell(j++, i).getContents();

                    System.out.println(" name:"+name+" phone:"+phone+" email:"+email+"address:"+address+"gender:"+gender);
                    list.add(new Person(name, phone, email, address, gender));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
}