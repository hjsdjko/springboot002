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

import com.cl.entity.PutongyuangongEntity;
import com.cl.entity.view.PutongyuangongView;

import com.cl.service.PutongyuangongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 普通员工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/putongyuangong")
public class PutongyuangongController {
    @Autowired
    private PutongyuangongService putongyuangongService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PutongyuangongEntity u = putongyuangongService.selectOne(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"putongyuangong",  "普通员工" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PutongyuangongEntity putongyuangong){
    	//ValidatorUtils.validateEntity(putongyuangong);
    	PutongyuangongEntity u = putongyuangongService.selectOne(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", putongyuangong.getGonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		putongyuangong.setId(uId);
        putongyuangongService.insert(putongyuangong);
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
        PutongyuangongEntity u = putongyuangongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PutongyuangongEntity u = putongyuangongService.selectOne(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        putongyuangongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PutongyuangongEntity putongyuangong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("putongyuangong")) {
			putongyuangong.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PutongyuangongEntity> ew = new EntityWrapper<PutongyuangongEntity>();

		PageUtils page = putongyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, putongyuangong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PutongyuangongEntity putongyuangong, 
		HttpServletRequest request){
        EntityWrapper<PutongyuangongEntity> ew = new EntityWrapper<PutongyuangongEntity>();

		PageUtils page = putongyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, putongyuangong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PutongyuangongEntity putongyuangong){
       	EntityWrapper<PutongyuangongEntity> ew = new EntityWrapper<PutongyuangongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( putongyuangong, "putongyuangong")); 
        return R.ok().put("data", putongyuangongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PutongyuangongEntity putongyuangong){
        EntityWrapper< PutongyuangongEntity> ew = new EntityWrapper< PutongyuangongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( putongyuangong, "putongyuangong")); 
		PutongyuangongView putongyuangongView =  putongyuangongService.selectView(ew);
		return R.ok("查询普通员工成功").put("data", putongyuangongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PutongyuangongEntity putongyuangong = putongyuangongService.selectById(id);
		putongyuangong = putongyuangongService.selectView(new EntityWrapper<PutongyuangongEntity>().eq("id", id));
        return R.ok().put("data", putongyuangong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PutongyuangongEntity putongyuangong = putongyuangongService.selectById(id);
		putongyuangong = putongyuangongService.selectView(new EntityWrapper<PutongyuangongEntity>().eq("id", id));
        return R.ok().put("data", putongyuangong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PutongyuangongEntity putongyuangong, HttpServletRequest request){
        if(putongyuangongService.selectCount(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", putongyuangong.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	putongyuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(putongyuangong);
    	PutongyuangongEntity u = putongyuangongService.selectOne(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", putongyuangong.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		putongyuangong.setId(new Date().getTime());
        putongyuangongService.insert(putongyuangong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PutongyuangongEntity putongyuangong, HttpServletRequest request){
        if(putongyuangongService.selectCount(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", putongyuangong.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	putongyuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(putongyuangong);
    	PutongyuangongEntity u = putongyuangongService.selectOne(new EntityWrapper<PutongyuangongEntity>().eq("gonghao", putongyuangong.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		putongyuangong.setId(new Date().getTime());
        putongyuangongService.insert(putongyuangong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PutongyuangongEntity putongyuangong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(putongyuangong);
        putongyuangongService.updateById(putongyuangong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        putongyuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
