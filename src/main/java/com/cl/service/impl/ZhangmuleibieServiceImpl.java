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


import com.cl.dao.ZhangmuleibieDao;
import com.cl.entity.ZhangmuleibieEntity;
import com.cl.service.ZhangmuleibieService;
import com.cl.entity.view.ZhangmuleibieView;

@Service("zhangmuleibieService")
public class ZhangmuleibieServiceImpl extends ServiceImpl<ZhangmuleibieDao, ZhangmuleibieEntity> implements ZhangmuleibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhangmuleibieEntity> page = this.selectPage(
                new Query<ZhangmuleibieEntity>(params).getPage(),
                new EntityWrapper<ZhangmuleibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhangmuleibieEntity> wrapper) {
		  Page<ZhangmuleibieView> page =new Query<ZhangmuleibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhangmuleibieView> selectListView(Wrapper<ZhangmuleibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhangmuleibieView selectView(Wrapper<ZhangmuleibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
