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

import com.cl.entity.YusuantianxieEntity;
import com.cl.entity.view.YusuantianxieView;

import com.cl.service.YusuantianxieService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预算填写
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/yusuantianxie")
public class YusuantianxieController {
    @Autowired
    private YusuantianxieService yusuantianxieService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YusuantianxieEntity yusuantianxie,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yusuanke")) {
			yusuantianxie.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YusuantianxieEntity> ew = new EntityWrapper<YusuantianxieEntity>();

		PageUtils page = yusuantianxieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yusuantianxie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YusuantianxieEntity yusuantianxie, 
		HttpServletRequest request){
        EntityWrapper<YusuantianxieEntity> ew = new EntityWrapper<YusuantianxieEntity>();

		PageUtils page = yusuantianxieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yusuantianxie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YusuantianxieEntity yusuantianxie){
       	EntityWrapper<YusuantianxieEntity> ew = new EntityWrapper<YusuantianxieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yusuantianxie, "yusuantianxie")); 
        return R.ok().put("data", yusuantianxieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YusuantianxieEntity yusuantianxie){
        EntityWrapper< YusuantianxieEntity> ew = new EntityWrapper< YusuantianxieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yusuantianxie, "yusuantianxie")); 
		YusuantianxieView yusuantianxieView =  yusuantianxieService.selectView(ew);
		return R.ok("查询预算填写成功").put("data", yusuantianxieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YusuantianxieEntity yusuantianxie = yusuantianxieService.selectById(id);
		yusuantianxie = yusuantianxieService.selectView(new EntityWrapper<YusuantianxieEntity>().eq("id", id));
        return R.ok().put("data", yusuantianxie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YusuantianxieEntity yusuantianxie = yusuantianxieService.selectById(id);
		yusuantianxie = yusuantianxieService.selectView(new EntityWrapper<YusuantianxieEntity>().eq("id", id));
        return R.ok().put("data", yusuantianxie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YusuantianxieEntity yusuantianxie, HttpServletRequest request){
    	yusuantianxie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yusuantianxie);
        yusuantianxieService.insert(yusuantianxie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YusuantianxieEntity yusuantianxie, HttpServletRequest request){
    	yusuantianxie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yusuantianxie);
        yusuantianxieService.insert(yusuantianxie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YusuantianxieEntity yusuantianxie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yusuantianxie);
        yusuantianxieService.updateById(yusuantianxie);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YusuantianxieEntity> list = new ArrayList<YusuantianxieEntity>();
        for(Long id : ids) {
            YusuantianxieEntity yusuantianxie = yusuantianxieService.selectById(id);
            yusuantianxie.setSfsh(sfsh);
            yusuantianxie.setShhf(shhf);
            list.add(yusuantianxie);
        }
        yusuantianxieService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yusuantianxieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
