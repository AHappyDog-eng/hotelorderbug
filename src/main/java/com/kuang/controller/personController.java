package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.entity.PageNum;
import com.kuang.entity.Person;
import com.kuang.entity.Room;
import com.kuang.entity.requestMsg.ById;
import com.kuang.entity.requestMsg.MsgBody;
import com.kuang.entity.requestMsg.roomoperator;
import com.kuang.entity.roomandOperator;
import com.kuang.service.personImp;
import com.kuang.service.room;
import com.kuang.tools.statuscode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class personController {

    @Autowired
    private com.kuang.service.personImp personImp;


    /*查询所有的类别*/
    @RequestMapping("/person/seleteClass")
    @ResponseBody
    public String seleteClass() {
        List<Person> strings = personImp.seleteClass();
        if (strings != null) {
            return JSON.toJSONString(new roomoperator(20000, 100, strings));
        } else {
            return JSON.toJSONString(new statuscode(false, 400, "没有分类"));
        }
    }

    @RequestMapping("/person/seleteByclass")
    @ResponseBody
    /*分类查询*/
    public String seleteByclass(@RequestBody String msg) {
        Person person = JSON.parseObject(msg, Person.class);
        if (person == null) {
            return JSON.toJSONString(new statuscode(false, 400, "参数为空"));
        } else {
            List<Person> personList = personImp.seleteByclass(person.getPersonjob());
            return JSON.toJSONString(new roomoperator(20000, null, personList));
        }
    }


    @RequestMapping("/person/pageselect")
    @ResponseBody
    public String pageselect(@RequestBody String msg) {
        PageNum pageNum = null;
        pageNum = JSON.parseObject(msg, PageNum.class);
        System.out.println(pageNum);
        if (pageNum.getPageNum() == 0 || pageNum.getPageNum() == null) {
            pageNum.setPageNum(1);
        }
        if (pageNum.getLimitNum() == 0 || pageNum.getLimitNum() == null) {
            pageNum.setLimitNum(10);
        }
        Page<Object> page = PageHelper.startPage(pageNum.getPageNum(), pageNum.getLimitNum());
        List<Person> all = personImp.getAll();
        int total = (int) page.getTotal();
        PageInfo<Person> personPageInfo = new PageInfo<Person>(all);
        personPageInfo.setPageNum(pageNum.getPageNum());
        List<Person> list = personPageInfo.getList();
        MsgBody msgBody = new roomoperator(20000, total, list);
        return JSON.toJSONString(msgBody);
    }


    @RequestMapping("/person/select")
    @ResponseBody
    public String select() {
        List<Person> all = personImp.getAll();
        return JSON.toJSONString(all);
    }


    @RequestMapping("/person/ById")
    @ResponseBody
    public String selectById(@RequestBody String msg) {
        Person person = JSON.parseObject(msg, Person.class);
        Person byId = personImp.selectPersonById(person.getPersonid());
        ArrayList<Person> people = new ArrayList<>();
        people.add(byId);
        return JSON.toJSONString(new roomoperator(20000, people));
    }

    @RequestMapping("/person/insert")
    @ResponseBody
    public String addRoom(@RequestBody String msg) {
        Person person = JSON.parseObject(msg, Person.class);
        System.out.println(person.toString());
        try {
            personImp.addPerson(person);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错 或者重复添加相同字段"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "插入成功"));
    }

    @RequestMapping("/person/update")
    @ResponseBody
    public String updateRoom(@RequestBody String msg) {
        Person person = JSON.parseObject(msg, Person.class);
        try {
            personImp.updatePerson(person);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "更新数据成功"));
    }

    @RequestMapping("/person/detele")
    @ResponseBody
    public String deteleRoom(@RequestBody String msg) {
        Person person = JSON.parseObject(msg, Person.class);
        try {
            personImp.deletePerson(person.getPersonid());
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "Roomid 可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 200, "更新数据成功"));
    }

    @RequestMapping("/person/batchDelete")
    @ResponseBody
    /*批量删除*/
    public String batchDelete(@RequestBody String msg) {
        System.out.println();
        List list = JSON.parseObject(msg, ArrayList.class);
        int counts = 0;
        if (list.size() >= 0) {
            for (Object deleteMsg : list) {
                int i = personImp.deletePerson((String) deleteMsg);
                counts += i;
            }
            if (counts == list.size()) {
                return JSON.toJSONString(new statuscode(true, 20000, "全部删除"));
            } else {
                return JSON.toJSONString(new statuscode(false, 20000, "可能未删除完全"));
            }

        } else {
            return JSON.toJSONString(new statuscode(false, 400, "请求失败"));
        }
    }

}
