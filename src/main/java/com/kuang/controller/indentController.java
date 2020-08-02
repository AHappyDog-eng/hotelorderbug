package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.entity.Indent;
import com.kuang.entity.PageNum;
import com.kuang.entity.requestMsg.ByIdBody;
import com.kuang.entity.requestMsg.MsgBody;
import com.kuang.entity.requestMsg.roomoperator;
import com.kuang.service.indentImp;
import com.kuang.tools.statuscode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class indentController {

    @Autowired
    private indentImp indentImp;

    /*返回四个数据*/
    @RequestMapping("/indent/selectFour")
    @ResponseBody
    public String selectFour() {

        Map<String, String> hashMap = new HashMap<>();
        return "error";
    }

    @RequestMapping("/indent/selectselectIndentSumDay")
    @ResponseBody
    public String selectselectIndentSumDay(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        Integer day = indentImp.selectIndentSumDay((String) map.get("day"));
        Map map1 = new HashMap<>();
        map1.put("day", day);
        return JSON.toJSONString(map1);
    }

    @RequestMapping("/indent/selectIndentSumMouse")
    @ResponseBody
    public String selectIndentSumMouse(@RequestBody String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        System.out.println(map);
        Integer sumMouse = indentImp.selectIndentSumMouse((String) map.get("pointDate"), (String) map.get("endDate"));
        Map map1 = new HashMap<>();
        map1.put("sumMouse", sumMouse);
        return JSON.toJSONString(map1);
    }

    @RequestMapping("/indent/selectIndentSum")
    @ResponseBody
    public String selectIndentSum() {
        Integer integer = indentImp.selectIndentSum();
        Object o = new Object();
        o = integer;
        return JSON.toJSONString(o);
    }

    @RequestMapping("/indent/pageselect")
    @ResponseBody
    public String pageselect(@RequestBody String msg) {
        PageNum pageNum = null;
        pageNum = JSON.parseObject(msg, PageNum.class);
        System.out.println(pageNum);
        if (pageNum == null) {
            return "值为空";
        }
        if (pageNum.getPageNum() == 0 || pageNum.getPageNum() == null) {
            pageNum.setPageNum(1);
        }
        if (pageNum.getLimitNum() == 0 || pageNum.getLimitNum() == null) {
            pageNum.setLimitNum(10);
        }
        Page<Object> page = PageHelper.startPage(pageNum.getPageNum(), pageNum.getLimitNum());
        List<Indent> all = indentImp.getAll();
        int total = (int) page.getTotal();
        PageInfo<Indent> pageInfo = new PageInfo<Indent>(all);
        pageInfo.setPageNum(pageNum.getPageNum());
        List<Indent> list = pageInfo.getList();
        MsgBody msgBody = new roomoperator(20000, total, list);
        return JSON.toJSONString(msgBody);
    }

    @RequestMapping("/indent/ById")
    @ResponseBody
    /* *
     * @Author: WN
     * @Description:
     *
     * @Date: 18:07 2020/4/24
     * @param: msg
     * @return: java.lang.String
     * @Version: 1.0
     */
    public String selectById(@RequestBody String msg) {
        Indent indent = JSON.parseObject(msg, Indent.class);
        Indent byId = indentImp.selectIndentById(indent.getIndentid());
        ArrayList<Indent> indents = new ArrayList<>();
        indents.add(byId);
        return JSON.toJSONString(new roomoperator(20000, indents));
    }

    @RequestMapping("/indent/insert")
    @ResponseBody
    public String addRoom(@RequestBody String msg) {
        Indent indent = JSON.parseObject(msg, Indent.class);
        try {
            indentImp.addIndent(indent);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错 或者重复添加相同字段"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "插入成功"));
    }

    @RequestMapping("/indent/update")
    @ResponseBody
    public String updateRoom(@RequestBody String msg) {
        Indent indent = JSON.parseObject(msg, Indent.class);
        System.out.println(indent);
        try {
            indentImp.updateIndent(indent);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "更新数据成功"));
    }

    @RequestMapping("/indent/detele")
    @ResponseBody
    public String deteleRoom(@RequestBody String msg) {
        Indent indent = JSON.parseObject(msg, Indent.class);
        try {
            indentImp.deleteIndent(indent.getIndentid());
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "Roomid 可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "更新数据成功"));
    }

}
