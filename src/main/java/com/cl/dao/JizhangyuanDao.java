package com.cl.dao;

import com.cl.entity.JizhangyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JizhangyuanView;


/**
 * 记账员
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface JizhangyuanDao extends BaseMapper<JizhangyuanEntity> {
	
	List<JizhangyuanView> selectListView(@Param("ew") Wrapper<JizhangyuanEntity> wrapper);

	List<JizhangyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JizhangyuanEntity> wrapper);
	
	JizhangyuanView selectView(@Param("ew") Wrapper<JizhangyuanEntity> wrapper);
	

}
