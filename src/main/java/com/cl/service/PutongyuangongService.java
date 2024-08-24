package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PutongyuangongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PutongyuangongView;


/**
 * 普通员工
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface PutongyuangongService extends IService<PutongyuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PutongyuangongView> selectListView(Wrapper<PutongyuangongEntity> wrapper);
   	
   	PutongyuangongView selectView(@Param("ew") Wrapper<PutongyuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PutongyuangongEntity> wrapper);
   	

}

