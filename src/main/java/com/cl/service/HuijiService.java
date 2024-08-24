package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuijiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuijiView;


/**
 * 会计
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface HuijiService extends IService<HuijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuijiView> selectListView(Wrapper<HuijiEntity> wrapper);
   	
   	HuijiView selectView(@Param("ew") Wrapper<HuijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuijiEntity> wrapper);
   	

}

