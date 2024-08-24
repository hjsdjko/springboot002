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


import com.cl.dao.HuijiDao;
import com.cl.entity.HuijiEntity;
import com.cl.service.HuijiService;
import com.cl.entity.view.HuijiView;

@Service("huijiService")
public class HuijiServiceImpl extends ServiceImpl<HuijiDao, HuijiEntity> implements HuijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuijiEntity> page = this.selectPage(
                new Query<HuijiEntity>(params).getPage(),
                new EntityWrapper<HuijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuijiEntity> wrapper) {
		  Page<HuijiView> page =new Query<HuijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuijiView> selectListView(Wrapper<HuijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuijiView selectView(Wrapper<HuijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
