package com.cl.dao;

import com.cl.entity.PutongyuangongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PutongyuangongView;


/**
 * 普通员工
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface PutongyuangongDao extends BaseMapper<PutongyuangongEntity> {
	
	List<PutongyuangongView> selectListView(@Param("ew") Wrapper<PutongyuangongEntity> wrapper);

	List<PutongyuangongView> selectListView(Pagination page,@Param("ew") Wrapper<PutongyuangongEntity> wrapper);
	
	PutongyuangongView selectView(@Param("ew") Wrapper<PutongyuangongEntity> wrapper);
	

}
