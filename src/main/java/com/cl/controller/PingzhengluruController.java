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

import com.cl.entity.PingzhengluruEntity;
import com.cl.entity.view.PingzhengluruView;

import com.cl.service.PingzhengluruService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 凭证录入
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@RestController
@RequestMapping("/pingzhengluru")
public class PingzhengluruController {
    @Autowired
    private PingzhengluruService pingzhengluruService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingzhengluruEntity pingzhengluru,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jizhangyuan")) {
			pingzhengluru.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingzhengluruEntity> ew = new EntityWrapper<PingzhengluruEntity>();

		PageUtils page = pingzhengluruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingzhengluru), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingzhengluruEntity pingzhengluru, 
		HttpServletRequest request){
        EntityWrapper<PingzhengluruEntity> ew = new EntityWrapper<PingzhengluruEntity>();

		PageUtils page = pingzhengluruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingzhengluru), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingzhengluruEntity pingzhengluru){
       	EntityWrapper<PingzhengluruEntity> ew = new EntityWrapper<PingzhengluruEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingzhengluru, "pingzhengluru")); 
        return R.ok().put("data", pingzhengluruService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingzhengluruEntity pingzhengluru){
        EntityWrapper< PingzhengluruEntity> ew = new EntityWrapper< PingzhengluruEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingzhengluru, "pingzhengluru")); 
		PingzhengluruView pingzhengluruView =  pingzhengluruService.selectView(ew);
		return R.ok("查询凭证录入成功").put("data", pingzhengluruView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingzhengluruEntity pingzhengluru = pingzhengluruService.selectById(id);
		pingzhengluru = pingzhengluruService.selectView(new EntityWrapper<PingzhengluruEntity>().eq("id", id));
        return R.ok().put("data", pingzhengluru);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingzhengluruEntity pingzhengluru = pingzhengluruService.selectById(id);
		pingzhengluru = pingzhengluruService.selectView(new EntityWrapper<PingzhengluruEntity>().eq("id", id));
        return R.ok().put("data", pingzhengluru);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingzhengluruEntity pingzhengluru, HttpServletRequest request){
    	pingzhengluru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingzhengluru);
        pingzhengluruService.insert(pingzhengluru);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingzhengluruEntity pingzhengluru, HttpServletRequest request){
    	pingzhengluru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingzhengluru);
        pingzhengluruService.insert(pingzhengluru);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingzhengluruEntity pingzhengluru, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingzhengluru);
        pingzhengluruService.updateById(pingzhengluru);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<PingzhengluruEntity> list = new ArrayList<PingzhengluruEntity>();
        for(Long id : ids) {
            PingzhengluruEntity pingzhengluru = pingzhengluruService.selectById(id);
            pingzhengluru.setSfsh(sfsh);
            pingzhengluru.setShhf(shhf);
            list.add(pingzhengluru);
        }
        pingzhengluruService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingzhengluruService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
