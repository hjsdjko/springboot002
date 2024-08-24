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


import com.cl.dao.PutongyuangongDao;
import com.cl.entity.PutongyuangongEntity;
import com.cl.service.PutongyuangongService;
import com.cl.entity.view.PutongyuangongView;

@Service("putongyuangongService")
public class PutongyuangongServiceImpl extends ServiceImpl<PutongyuangongDao, PutongyuangongEntity> implements PutongyuangongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PutongyuangongEntity> page = this.selectPage(
                new Query<PutongyuangongEntity>(params).getPage(),
                new EntityWrapper<PutongyuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PutongyuangongEntity> wrapper) {
		  Page<PutongyuangongView> page =new Query<PutongyuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PutongyuangongView> selectListView(Wrapper<PutongyuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PutongyuangongView selectView(Wrapper<PutongyuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
