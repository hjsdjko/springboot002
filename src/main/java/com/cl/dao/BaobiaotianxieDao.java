package com.cl.dao;

import com.cl.entity.BaobiaotianxieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaobiaotianxieView;


/**
 * 报表填写
 * 
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface BaobiaotianxieDao extends BaseMapper<BaobiaotianxieEntity> {
	
	List<BaobiaotianxieView> selectListView(@Param("ew") Wrapper<BaobiaotianxieEntity> wrapper);

	List<BaobiaotianxieView> selectListView(Pagination page,@Param("ew") Wrapper<BaobiaotianxieEntity> wrapper);
	
	BaobiaotianxieView selectView(@Param("ew") Wrapper<BaobiaotianxieEntity> wrapper);
	

}
