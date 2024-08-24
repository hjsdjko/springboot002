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


import com.cl.dao.YusuankeDao;
import com.cl.entity.YusuankeEntity;
import com.cl.service.YusuankeService;
import com.cl.entity.view.YusuankeView;

@Service("yusuankeService")
public class YusuankeServiceImpl extends ServiceImpl<YusuankeDao, YusuankeEntity> implements YusuankeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YusuankeEntity> page = this.selectPage(
                new Query<YusuankeEntity>(params).getPage(),
                new EntityWrapper<YusuankeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YusuankeEntity> wrapper) {
		  Page<YusuankeView> page =new Query<YusuankeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YusuankeView> selectListView(Wrapper<YusuankeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YusuankeView selectView(Wrapper<YusuankeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
