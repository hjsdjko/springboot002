package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhangmuleibieEntity;
import com.cl.entity.view.ZhangmuleibieView;

import com.cl.service.ZhangmuleibieService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 账目类别
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/zhangmuleibie")
public class ZhangmuleibieController {
    @Autowired
    private ZhangmuleibieService zhangmuleibieService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhangmuleibieEntity zhangmuleibie,
		HttpServletRequest request){
        EntityWrapper<ZhangmuleibieEntity> ew = new EntityWrapper<ZhangmuleibieEntity>();

		PageUtils page = zhangmuleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhangmuleibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhangmuleibieEntity zhangmuleibie, 
		HttpServletRequest request){
        EntityWrapper<ZhangmuleibieEntity> ew = new EntityWrapper<ZhangmuleibieEntity>();

		PageUtils page = zhangmuleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhangmuleibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhangmuleibieEntity zhangmuleibie){
       	EntityWrapper<ZhangmuleibieEntity> ew = new EntityWrapper<ZhangmuleibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhangmuleibie, "zhangmuleibie")); 
        return R.ok().put("data", zhangmuleibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhangmuleibieEntity zhangmuleibie){
        EntityWrapper< ZhangmuleibieEntity> ew = new EntityWrapper< ZhangmuleibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhangmuleibie, "zhangmuleibie")); 
		ZhangmuleibieView zhangmuleibieView =  zhangmuleibieService.selectView(ew);
		return R.ok("查询账目类别成功").put("data", zhangmuleibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhangmuleibieEntity zhangmuleibie = zhangmuleibieService.selectById(id);
		zhangmuleibie = zhangmuleibieService.selectView(new EntityWrapper<ZhangmuleibieEntity>().eq("id", id));
        return R.ok().put("data", zhangmuleibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhangmuleibieEntity zhangmuleibie = zhangmuleibieService.selectById(id);
		zhangmuleibie = zhangmuleibieService.selectView(new EntityWrapper<ZhangmuleibieEntity>().eq("id", id));
        return R.ok().put("data", zhangmuleibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhangmuleibieEntity zhangmuleibie, HttpServletRequest request){
    	zhangmuleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhangmuleibie);
        zhangmuleibieService.insert(zhangmuleibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhangmuleibieEntity zhangmuleibie, HttpServletRequest request){
    	zhangmuleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhangmuleibie);
        zhangmuleibieService.insert(zhangmuleibie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhangmuleibieEntity zhangmuleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhangmuleibie);
        zhangmuleibieService.updateById(zhangmuleibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhangmuleibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
