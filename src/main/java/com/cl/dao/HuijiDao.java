package com.cl.dao;

import com.cl.entity.HuijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuijiView;


/**
 * 会计
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface HuijiDao extends BaseMapper<HuijiEntity> {
	
	List<HuijiView> selectListView(@Param("ew") Wrapper<HuijiEntity> wrapper);

	List<HuijiView> selectListView(Pagination page,@Param("ew") Wrapper<HuijiEntity> wrapper);
	
	HuijiView selectView(@Param("ew") Wrapper<HuijiEntity> wrapper);
	

}
