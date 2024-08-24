package com.cl.dao;

import com.cl.entity.YusuankeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YusuankeView;


/**
 * 预算科
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface YusuankeDao extends BaseMapper<YusuankeEntity> {
	
	List<YusuankeView> selectListView(@Param("ew") Wrapper<YusuankeEntity> wrapper);

	List<YusuankeView> selectListView(Pagination page,@Param("ew") Wrapper<YusuankeEntity> wrapper);
	
	YusuankeView selectView(@Param("ew") Wrapper<YusuankeEntity> wrapper);
	

}
