package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YusuantianxieDao;
import com.cl.entity.YusuantianxieEntity;
import com.cl.service.YusuantianxieService;
import com.cl.entity.view.YusuantianxieView;

@Service("yusuantianxieService")
public class YusuantianxieServiceImpl extends ServiceImpl<YusuantianxieDao, YusuantianxieEntity> implements YusuantianxieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YusuantianxieEntity> page = this.selectPage(
                new Query<YusuantianxieEntity>(params).getPage(),
                new EntityWrapper<YusuantianxieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YusuantianxieEntity> wrapper) {
		  Page<YusuantianxieView> page =new Query<YusuantianxieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YusuantianxieView> selectListView(Wrapper<YusuantianxieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YusuantianxieView selectView(Wrapper<YusuantianxieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
