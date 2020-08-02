package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.entity.*;
import com.kuang.entity.requestMsg.ById;
import com.kuang.entity.requestMsg.MsgBody;
import com.kuang.entity.requestMsg.roomoperator;
import com.kuang.service.roomaoImp;
import com.kuang.tools.jwtUtils.JwtUtil;
import com.kuang.tools.statuscode;
import com.mysql.cj.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class roomController {
    @Autowired
    private com.kuang.service.roomImp roomImp;

    @Autowired
    private com.kuang.service.roomaoImp roomaoImp;

    /*查询所有的类别*/
    @RequestMapping("/room/seleteClass")
    @ResponseBody
    public String seleteClass() {
        List<Room> strings = roomImp.seleteClass();
        if (strings != null){
            return JSON.toJSONString(new roomoperator(20000,100,strings));
        } else{
            return JSON.toJSONString(new statuscode(false,400,"没有分类"));
        }
    }

    @RequestMapping("/room/seleteByclass")
    @ResponseBody
    /*分类查询*/
    public String seleteByclass(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        if (room.getRoomindent() == null) {
            return JSON.toJSONString(new statuscode(false, 400, "参数为空"));
        } else {
            List<Room> seleteByclass = roomImp.seleteByclass(room.getRoomindent());
            return JSON.toJSONString(new roomoperator(20000, null, seleteByclass));
        }
    }

    @RequestMapping("/room/batchDelete")
    @ResponseBody
    /*批量删除*/
    public String batchDelete(@RequestBody String msg) {
        System.out.println();
        List list = JSON.parseObject(msg, ArrayList.class);
        int counts = 0;
        if (list.size() >= 0) {
            for (Object deleteMsg : list) {
                int i = roomImp.deleteRoom((String) deleteMsg);
                counts+=i;
            }if (counts == list.size()) {
                return JSON.toJSONString(new statuscode(true,20000,"全部删除"));
            }else {
                return JSON.toJSONString(new statuscode(false,20000,"可能未删除完全"));
            }

        } else{
            return JSON.toJSONString(new statuscode(false,400,"请求失败"));
        }
    }

    /*修改表的indent*/
    @RequestMapping("/roomOperator/updateIndent")
    @ResponseBody
    public String updateIndent(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        try {
            roomImp.updateIndent(room);
            return JSON.toJSONString(new statuscode(true, 20000, "修改成功"));
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "修改失败"));
        }
    }

    /*删除两个表的属性*/
    @RequestMapping("/roomOperator/detelerop")
    @ResponseBody
    public String detelerop(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        if (room != null) {

            int i = roomImp.deleteRoom(room.getRoomid());
            int i1 = roomaoImp.deleteRoomao(room.getRoomid());
            if (i == 0 || i1 == 0) {
                return JSON.toJSONString(new statuscode(false, 400, "删除元素失败"));
            } else {
                return JSON.toJSONString(new statuscode(true, 20000, "删除成功"));
            }

        } else {
            return JSON.toJSONString(new statuscode(false, 400, "删除元素失败"));
        }
    }

    /*连表查询*/
    @RequestMapping("/roomOperator/pageselect")
    @ResponseBody
    public String roomoperatorpageselect(@RequestBody String msg) {
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
        List<roomandOperator> all = roomImp.getroomOperator();
        int total = (int) page.getTotal();
        PageInfo<roomandOperator> pageInfo = new PageInfo<roomandOperator>(all);
        pageInfo.setPageNum(pageNum.getPageNum());
        List<roomandOperator> list = pageInfo.getList();
        MsgBody msgBody = new roomoperator(20000,total,list);
        return JSON.toJSONString(msgBody);
    }

    /*自动添加功能*/
    @RequestMapping("/roomOperator/insert")
    @ResponseBody
    public String roomoperatorinsert(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        roomandOperator roomandOperator = JSON.parseObject(msg, roomandOperator.class);
        /* 获取这个对象后 对两个表进行分别添加*/
        if (StringUtils.isNullOrEmpty(roomandOperator.getRoomId())) {
            /*增加*/
            /*需要自动获取操作人 需要token*/
            String token = WebUtils.toHttp(request).getHeader("Authorization");
            String username = JwtUtil.parseVer(token);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            String roomid = UUID.randomUUID().toString().substring(0, 8);
            if (roomandOperator == null) {
                return JSON.toJSONString(new roomoperator(400, 0, null));
            }
            try {
                roomImp.addRoom(new Room(roomid, roomandOperator.getRoomIndent(), null, null));
                Date date = simpleDateFormat.parse(format);
                roomaoImp.addRoomao(new operator(roomid, username, format));
                return JSON.toJSONString(new statuscode(true, 20000, "插入成功"));
            } catch (Exception e) {
                return JSON.toJSONString(new roomoperator(400, 0, null));
            }
        } else {
            /*修改*/
            try {
                roomImp.updateIndent(new Room(roomandOperator.getRoomId(), roomandOperator.getRoomIndent(), null, null));
                return JSON.toJSONString(new statuscode(true, 20000, "修改成功"));
            } catch (Exception e) {
                return JSON.toJSONString(new statuscode(false, 400, "修改成功"));
            }
        }


    }

    @RequestMapping("/room/pageselect")
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
        List<Room> all = roomImp.getAll();
        int total = (int) page.getTotal();
        PageInfo<Room> pageInfo = new PageInfo<Room>(all);
        pageInfo.setPageNum(pageNum.getPageNum());
        List<Room> list = pageInfo.getList();
        dataMsg dataMsg = new dataMsg(list, 20000, total);
        return JSON.toJSONString(dataMsg);
    }

    @RequestMapping("/room/select")
    @ResponseBody
    public String select() {
        List<Room> all = roomImp.getAll();
        return JSON.toJSONString(all);
    }

    @RequestMapping("/room/ById")
    @ResponseBody
    public String selectById(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        Room byId = roomImp.selectRoomById(room.getRoomid());
        List<Room> rooms = new ArrayList<>();
        rooms.add(byId);
        return JSON.toJSONString(new roomoperator(20000,rooms));
    }

    @RequestMapping("/room/insert")
    @ResponseBody
    public String addRoom(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        try {
            roomImp.addRoom(room);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错 或者重复添加相同字段"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "插入成功"));
    }

    @RequestMapping("/room/update")
    @ResponseBody
    public String updateRoom(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        try {
            roomImp.updateRoom(room);
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "封装数据可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "更新数据成功"));
    }

    @RequestMapping("/room/detele")
    @ResponseBody
    public String deteleRoom(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        try {
            roomImp.deleteRoom(room.getRoomid());
        } catch (Exception e) {
            return JSON.toJSONString(new statuscode(false, 400, "Roomid 可能出错"));
        }
        return JSON.toJSONString(new statuscode(true, 20000, "更新数据成功"));
    }

    /*添加表的后面两项*/
    @RequestMapping("/room/insertao")
    @ResponseBody
    public String insertRoomao(@RequestBody String msg) {
        Room room = JSON.parseObject(msg, Room.class);
        if (room != null) {
            roomImp.updateRoomao(room);
            return JSON.toJSONString(new statuscode(true, 20000, "修改成功"));
        } else {
            return JSON.toJSONString(new statuscode(false, 400, "参数为空"));
        }

    }

}
