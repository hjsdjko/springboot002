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

import com.cl.entity.BaobiaotianxieEntity;
import com.cl.entity.view.BaobiaotianxieView;

import com.cl.service.BaobiaotianxieService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 报表填写
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/baobiaotianxie")
public class BaobiaotianxieController {
    @Autowired
    private BaobiaotianxieService baobiaotianxieService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaobiaotianxieEntity baobiaotianxie,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiji")) {
			baobiaotianxie.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaobiaotianxieEntity> ew = new EntityWrapper<BaobiaotianxieEntity>();

		PageUtils page = baobiaotianxieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baobiaotianxie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaobiaotianxieEntity baobiaotianxie, 
		HttpServletRequest request){
        EntityWrapper<BaobiaotianxieEntity> ew = new EntityWrapper<BaobiaotianxieEntity>();

		PageUtils page = baobiaotianxieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baobiaotianxie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaobiaotianxieEntity baobiaotianxie){
       	EntityWrapper<BaobiaotianxieEntity> ew = new EntityWrapper<BaobiaotianxieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baobiaotianxie, "baobiaotianxie")); 
        return R.ok().put("data", baobiaotianxieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaobiaotianxieEntity baobiaotianxie){
        EntityWrapper< BaobiaotianxieEntity> ew = new EntityWrapper< BaobiaotianxieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baobiaotianxie, "baobiaotianxie")); 
		BaobiaotianxieView baobiaotianxieView =  baobiaotianxieService.selectView(ew);
		return R.ok("查询报表填写成功").put("data", baobiaotianxieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaobiaotianxieEntity baobiaotianxie = baobiaotianxieService.selectById(id);
		baobiaotianxie = baobiaotianxieService.selectView(new EntityWrapper<BaobiaotianxieEntity>().eq("id", id));
        return R.ok().put("data", baobiaotianxie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaobiaotianxieEntity baobiaotianxie = baobiaotianxieService.selectById(id);
		baobiaotianxie = baobiaotianxieService.selectView(new EntityWrapper<BaobiaotianxieEntity>().eq("id", id));
        return R.ok().put("data", baobiaotianxie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaobiaotianxieEntity baobiaotianxie, HttpServletRequest request){
    	baobiaotianxie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baobiaotianxie);
        baobiaotianxieService.insert(baobiaotianxie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaobiaotianxieEntity baobiaotianxie, HttpServletRequest request){
    	baobiaotianxie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baobiaotianxie);
        baobiaotianxieService.insert(baobiaotianxie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaobiaotianxieEntity baobiaotianxie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baobiaotianxie);
        baobiaotianxieService.updateById(baobiaotianxie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baobiaotianxieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
