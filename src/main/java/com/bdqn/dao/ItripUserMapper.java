package com.bdqn.dao;

import com.bdqn.pojo.ItripUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;
public interface ItripUserMapper {
    public List<ItripUser> list(@Param("id")Long id,@Param("userPassword")String userPassword);
    /*public List<AppCategory> list(@Param("pid")String a);*/
}
