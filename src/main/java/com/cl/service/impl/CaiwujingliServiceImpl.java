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


import com.cl.dao.CaiwujingliDao;
import com.cl.entity.CaiwujingliEntity;
import com.cl.service.CaiwujingliService;
import com.cl.entity.view.CaiwujingliView;

@Service("caiwujingliService")
public class CaiwujingliServiceImpl extends ServiceImpl<CaiwujingliDao, CaiwujingliEntity> implements CaiwujingliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaiwujingliEntity> page = this.selectPage(
                new Query<CaiwujingliEntity>(params).getPage(),
                new EntityWrapper<CaiwujingliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaiwujingliEntity> wrapper) {
		  Page<CaiwujingliView> page =new Query<CaiwujingliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CaiwujingliView> selectListView(Wrapper<CaiwujingliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaiwujingliView selectView(Wrapper<CaiwujingliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
