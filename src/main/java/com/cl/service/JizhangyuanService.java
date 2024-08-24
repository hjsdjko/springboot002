package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JizhangyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JizhangyuanView;


/**
 * 记账员
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface JizhangyuanService extends IService<JizhangyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JizhangyuanView> selectListView(Wrapper<JizhangyuanEntity> wrapper);
   	
   	JizhangyuanView selectView(@Param("ew") Wrapper<JizhangyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JizhangyuanEntity> wrapper);
   	

}

