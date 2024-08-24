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

import com.cl.entity.JizhangyuanEntity;
import com.cl.entity.view.JizhangyuanView;

import com.cl.service.JizhangyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 记账员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/jizhangyuan")
public class JizhangyuanController {
    @Autowired
    private JizhangyuanService jizhangyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JizhangyuanEntity u = jizhangyuanService.selectOne(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"jizhangyuan",  "记账员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JizhangyuanEntity jizhangyuan){
    	//ValidatorUtils.validateEntity(jizhangyuan);
    	JizhangyuanEntity u = jizhangyuanService.selectOne(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", jizhangyuan.getGonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jizhangyuan.setId(uId);
        jizhangyuanService.insert(jizhangyuan);
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
        JizhangyuanEntity u = jizhangyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JizhangyuanEntity u = jizhangyuanService.selectOne(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        jizhangyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JizhangyuanEntity jizhangyuan,
		HttpServletRequest request){
        EntityWrapper<JizhangyuanEntity> ew = new EntityWrapper<JizhangyuanEntity>();

		PageUtils page = jizhangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jizhangyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JizhangyuanEntity jizhangyuan, 
		HttpServletRequest request){
        EntityWrapper<JizhangyuanEntity> ew = new EntityWrapper<JizhangyuanEntity>();

		PageUtils page = jizhangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jizhangyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JizhangyuanEntity jizhangyuan){
       	EntityWrapper<JizhangyuanEntity> ew = new EntityWrapper<JizhangyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jizhangyuan, "jizhangyuan")); 
        return R.ok().put("data", jizhangyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JizhangyuanEntity jizhangyuan){
        EntityWrapper< JizhangyuanEntity> ew = new EntityWrapper< JizhangyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jizhangyuan, "jizhangyuan")); 
		JizhangyuanView jizhangyuanView =  jizhangyuanService.selectView(ew);
		return R.ok("查询记账员成功").put("data", jizhangyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JizhangyuanEntity jizhangyuan = jizhangyuanService.selectById(id);
		jizhangyuan = jizhangyuanService.selectView(new EntityWrapper<JizhangyuanEntity>().eq("id", id));
        return R.ok().put("data", jizhangyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JizhangyuanEntity jizhangyuan = jizhangyuanService.selectById(id);
		jizhangyuan = jizhangyuanService.selectView(new EntityWrapper<JizhangyuanEntity>().eq("id", id));
        return R.ok().put("data", jizhangyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JizhangyuanEntity jizhangyuan, HttpServletRequest request){
        if(jizhangyuanService.selectCount(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", jizhangyuan.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	jizhangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jizhangyuan);
    	JizhangyuanEntity u = jizhangyuanService.selectOne(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", jizhangyuan.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jizhangyuan.setId(new Date().getTime());
        jizhangyuanService.insert(jizhangyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JizhangyuanEntity jizhangyuan, HttpServletRequest request){
        if(jizhangyuanService.selectCount(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", jizhangyuan.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	jizhangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jizhangyuan);
    	JizhangyuanEntity u = jizhangyuanService.selectOne(new EntityWrapper<JizhangyuanEntity>().eq("gonghao", jizhangyuan.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jizhangyuan.setId(new Date().getTime());
        jizhangyuanService.insert(jizhangyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JizhangyuanEntity jizhangyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jizhangyuan);
        jizhangyuanService.updateById(jizhangyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jizhangyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
