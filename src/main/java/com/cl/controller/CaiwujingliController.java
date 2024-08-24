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

import com.cl.entity.CaiwujingliEntity;
import com.cl.entity.view.CaiwujingliView;

import com.cl.service.CaiwujingliService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 财务经理
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/caiwujingli")
public class CaiwujingliController {
    @Autowired
    private CaiwujingliService caiwujingliService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		CaiwujingliEntity u = caiwujingliService.selectOne(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"caiwujingli",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody CaiwujingliEntity caiwujingli){
    	//ValidatorUtils.validateEntity(caiwujingli);
    	CaiwujingliEntity u = caiwujingliService.selectOne(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", caiwujingli.getGonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		caiwujingli.setId(uId);
        caiwujingliService.insert(caiwujingli);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        CaiwujingliEntity u = caiwujingliService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	CaiwujingliEntity u = caiwujingliService.selectOne(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        caiwujingliService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaiwujingliEntity caiwujingli,
		HttpServletRequest request){
        EntityWrapper<CaiwujingliEntity> ew = new EntityWrapper<CaiwujingliEntity>();

		PageUtils page = caiwujingliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwujingli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaiwujingliEntity caiwujingli, 
		HttpServletRequest request){
        EntityWrapper<CaiwujingliEntity> ew = new EntityWrapper<CaiwujingliEntity>();

		PageUtils page = caiwujingliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwujingli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaiwujingliEntity caiwujingli){
       	EntityWrapper<CaiwujingliEntity> ew = new EntityWrapper<CaiwujingliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caiwujingli, "caiwujingli")); 
        return R.ok().put("data", caiwujingliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaiwujingliEntity caiwujingli){
        EntityWrapper< CaiwujingliEntity> ew = new EntityWrapper< CaiwujingliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caiwujingli, "caiwujingli")); 
		CaiwujingliView caiwujingliView =  caiwujingliService.selectView(ew);
		return R.ok("查询财务经理成功").put("data", caiwujingliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaiwujingliEntity caiwujingli = caiwujingliService.selectById(id);
		caiwujingli = caiwujingliService.selectView(new EntityWrapper<CaiwujingliEntity>().eq("id", id));
        return R.ok().put("data", caiwujingli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaiwujingliEntity caiwujingli = caiwujingliService.selectById(id);
		caiwujingli = caiwujingliService.selectView(new EntityWrapper<CaiwujingliEntity>().eq("id", id));
        return R.ok().put("data", caiwujingli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwujingliEntity caiwujingli, HttpServletRequest request){
        if(caiwujingliService.selectCount(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", caiwujingli.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	caiwujingli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwujingli);
    	CaiwujingliEntity u = caiwujingliService.selectOne(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", caiwujingli.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		caiwujingli.setId(new Date().getTime());
        caiwujingliService.insert(caiwujingli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaiwujingliEntity caiwujingli, HttpServletRequest request){
        if(caiwujingliService.selectCount(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", caiwujingli.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	caiwujingli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwujingli);
    	CaiwujingliEntity u = caiwujingliService.selectOne(new EntityWrapper<CaiwujingliEntity>().eq("gonghao", caiwujingli.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		caiwujingli.setId(new Date().getTime());
        caiwujingliService.insert(caiwujingli);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaiwujingliEntity caiwujingli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caiwujingli);
        caiwujingliService.updateById(caiwujingli);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caiwujingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
