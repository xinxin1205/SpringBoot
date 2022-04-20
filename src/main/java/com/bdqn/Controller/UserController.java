package com.bdqn.Controller;

import com.bdqn.dao.ItripHotelMapper;
import com.bdqn.pojo.ItripHotel;
import com.bdqn.pojo.Page;
import com.bdqn.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("*")
public class UserController {
    @Resource
    ItripHotelMapper dao;

    @RequestMapping("/list")
    @ResponseBody
    public Object getlistpage(int index, String sea, HttpServletResponse response) throws Exception {
        //跨域问题解决代码
//        response.addHeader("Access-Control-Allow-Origin", "*");
        Object[] d = dao.listPage(index, "'%" + sea + "%'");
        List<ItripHotel> list = (List<ItripHotel>) d[0];
        int count = ((ArrayList<Integer>) d[1]).get(0);

        Page<ItripHotel> page = new Page<>();
        page.setCurPage(index);
        page.setPageCount(count % 5 == 0 ? count / 5 : count / 5 + 1);
        page.setRows(list);
        return page;
    }

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/Login")
    @ResponseBody

    public Object login(String sea, HttpServletResponse response) {

        if (sea.equals("User")) {
            redisUtil.SetValue("User01", "类");
            return "User01";
        } else {
            return null;
        }
    }

  /*  @RequestMapping("/html")
    @ResponseBody
    public List<ItripHotel> getlist() throws Exception {
        return dao.getItripHotelById(new Long(1));
    }


*/
    @RequestMapping("/del/{id}")
    @ResponseBody
    public int del(@PathVariable int id, HttpServletResponse response) throws Exception {

        return dao.deleteItripHotelById((long) id);
    }

}
