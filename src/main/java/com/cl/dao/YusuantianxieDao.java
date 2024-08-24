package com.cl.dao;

import com.cl.entity.YusuantianxieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YusuantianxieView;


/**
 * 预算填写
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface YusuantianxieDao extends BaseMapper<YusuantianxieEntity> {
	
	List<YusuantianxieView> selectListView(@Param("ew") Wrapper<YusuantianxieEntity> wrapper);

	List<YusuantianxieView> selectListView(Pagination page,@Param("ew") Wrapper<YusuantianxieEntity> wrapper);
	
	YusuantianxieView selectView(@Param("ew") Wrapper<YusuantianxieEntity> wrapper);
	

}
