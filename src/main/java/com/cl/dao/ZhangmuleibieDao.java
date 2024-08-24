package com.cl.dao;

import com.cl.entity.ZhangmuleibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhangmuleibieView;


/**
 * 账目类别
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface ZhangmuleibieDao extends BaseMapper<ZhangmuleibieEntity> {
	
	List<ZhangmuleibieView> selectListView(@Param("ew") Wrapper<ZhangmuleibieEntity> wrapper);

	List<ZhangmuleibieView> selectListView(Pagination page,@Param("ew") Wrapper<ZhangmuleibieEntity> wrapper);
	
	ZhangmuleibieView selectView(@Param("ew") Wrapper<ZhangmuleibieEntity> wrapper);
	

}
