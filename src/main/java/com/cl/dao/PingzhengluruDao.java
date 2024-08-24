package com.cl.dao;

import com.cl.entity.PingzhengluruEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingzhengluruView;


/**
 * 凭证录入
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface PingzhengluruDao extends BaseMapper<PingzhengluruEntity> {
	
	List<PingzhengluruView> selectListView(@Param("ew") Wrapper<PingzhengluruEntity> wrapper);

	List<PingzhengluruView> selectListView(Pagination page,@Param("ew") Wrapper<PingzhengluruEntity> wrapper);
	
	PingzhengluruView selectView(@Param("ew") Wrapper<PingzhengluruEntity> wrapper);
	

}
