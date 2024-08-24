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


import com.cl.dao.PingzhengluruDao;
import com.cl.entity.PingzhengluruEntity;
import com.cl.service.PingzhengluruService;
import com.cl.entity.view.PingzhengluruView;

@Service("pingzhengluruService")
public class PingzhengluruServiceImpl extends ServiceImpl<PingzhengluruDao, PingzhengluruEntity> implements PingzhengluruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingzhengluruEntity> page = this.selectPage(
                new Query<PingzhengluruEntity>(params).getPage(),
                new EntityWrapper<PingzhengluruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingzhengluruEntity> wrapper) {
		  Page<PingzhengluruView> page =new Query<PingzhengluruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PingzhengluruView> selectListView(Wrapper<PingzhengluruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingzhengluruView selectView(Wrapper<PingzhengluruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
