package com.cl.dao;

import com.cl.entity.CaiwujingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaiwujingliView;


/**
 * 财务经理
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface CaiwujingliDao extends BaseMapper<CaiwujingliEntity> {
	
	List<CaiwujingliView> selectListView(@Param("ew") Wrapper<CaiwujingliEntity> wrapper);

	List<CaiwujingliView> selectListView(Pagination page,@Param("ew") Wrapper<CaiwujingliEntity> wrapper);
	
	CaiwujingliView selectView(@Param("ew") Wrapper<CaiwujingliEntity> wrapper);
	

}
