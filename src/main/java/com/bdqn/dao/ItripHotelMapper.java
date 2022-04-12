package com.bdqn.dao;
import com.bdqn.dao.ItripHotelMapper;
import com.bdqn.pojo.ItripHotel;
import com.bdqn.pojo.ItripUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripHotelMapper {

	public int del(@Param("id")int id) throws Exception;

	public Object[] listPage(@Param(value = "index") int index,@Param(value = "sea") String sea) throws Exception;

	public List<ItripHotel> getItripHotelById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotel>	list()throws Exception;

	public Integer getItripHotelCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripHotel(ItripHotel itripHotel)throws Exception;

	public Integer updateItripHotel(ItripHotel itripHotel)throws Exception;

	public Integer deleteItripHotelById(@Param(value = "id") Long id)throws Exception;

}
