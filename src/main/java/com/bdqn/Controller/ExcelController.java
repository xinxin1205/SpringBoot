package com.bdqn.Controller;

import com.bdqn.dao.ItripHotelMapper;
import com.bdqn.pojo.ItripHotel;
import com.bdqn.util.ExportPOIUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ExcelController {

    @Resource
    ItripHotelMapper dao;


    @RequestMapping("/ExcelContoller")
    @ResponseBody
    public void getlist(HttpServletResponse response) throws Exception {



        // 列名
        String columnNames[] = {"ID", "酒店名字"};
        // map中的key
        String keys[] = {"id","hotelName","address"};
        List<ItripHotel> list=dao.list();
        ExportPOIUtils.start_download(response, "酒店名称", list, columnNames, keys);
    }
}
