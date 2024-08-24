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


import com.cl.dao.BaobiaotianxieDao;
import com.cl.entity.BaobiaotianxieEntity;
import com.cl.service.BaobiaotianxieService;
import com.cl.entity.view.BaobiaotianxieView;

@Service("baobiaotianxieService")
public class BaobiaotianxieServiceImpl extends ServiceImpl<BaobiaotianxieDao, BaobiaotianxieEntity> implements BaobiaotianxieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaobiaotianxieEntity> page = this.selectPage(
                new Query<BaobiaotianxieEntity>(params).getPage(),
                new EntityWrapper<BaobiaotianxieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaobiaotianxieEntity> wrapper) {
		  Page<BaobiaotianxieView> page =new Query<BaobiaotianxieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BaobiaotianxieView> selectListView(Wrapper<BaobiaotianxieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaobiaotianxieView selectView(Wrapper<BaobiaotianxieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
