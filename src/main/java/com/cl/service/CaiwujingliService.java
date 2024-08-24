package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CaiwujingliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaiwujingliView;


/**
 * 财务经理
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface CaiwujingliService extends IService<CaiwujingliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwujingliView> selectListView(Wrapper<CaiwujingliEntity> wrapper);
   	
   	CaiwujingliView selectView(@Param("ew") Wrapper<CaiwujingliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwujingliEntity> wrapper);
   	

}

