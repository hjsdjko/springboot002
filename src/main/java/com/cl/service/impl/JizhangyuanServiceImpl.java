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


import com.cl.dao.JizhangyuanDao;
import com.cl.entity.JizhangyuanEntity;
import com.cl.service.JizhangyuanService;
import com.cl.entity.view.JizhangyuanView;

@Service("jizhangyuanService")
public class JizhangyuanServiceImpl extends ServiceImpl<JizhangyuanDao, JizhangyuanEntity> implements JizhangyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JizhangyuanEntity> page = this.selectPage(
                new Query<JizhangyuanEntity>(params).getPage(),
                new EntityWrapper<JizhangyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JizhangyuanEntity> wrapper) {
		  Page<JizhangyuanView> page =new Query<JizhangyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JizhangyuanView> selectListView(Wrapper<JizhangyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JizhangyuanView selectView(Wrapper<JizhangyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
