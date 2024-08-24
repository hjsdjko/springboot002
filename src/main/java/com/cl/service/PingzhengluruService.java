package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PingzhengluruEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingzhengluruView;


/**
 * 凭证录入
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface PingzhengluruService extends IService<PingzhengluruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingzhengluruView> selectListView(Wrapper<PingzhengluruEntity> wrapper);
   	
   	PingzhengluruView selectView(@Param("ew") Wrapper<PingzhengluruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingzhengluruEntity> wrapper);
   	

}

