package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BaobiaotianxieEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaobiaotianxieView;


/**
 * 报表填写
 *
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
public interface BaobiaotianxieService extends IService<BaobiaotianxieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaobiaotianxieView> selectListView(Wrapper<BaobiaotianxieEntity> wrapper);
   	
   	BaobiaotianxieView selectView(@Param("ew") Wrapper<BaobiaotianxieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaobiaotianxieEntity> wrapper);
   	

}

