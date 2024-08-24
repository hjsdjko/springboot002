package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 报表填写
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("baobiaotianxie")
public class BaobiaotianxieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BaobiaotianxieEntity() {
		
	}
	
	public BaobiaotianxieEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 会计
	 */
					
	private String huiji;
	
	/**
	 * 时间
	 */
					
	private String shijian;
	
	/**
	 * 报表类型
	 */
					
	private String baobiaoleixing;
	
	/**
	 * 1
	 */
					
	private Double yi;
	
	/**
	 * 2
	 */
					
	private Double er;
	
	/**
	 * 3
	 */
					
	private Double san;
	
	/**
	 * 4
	 */
					
	private Double si;
	
	/**
	 * 5
	 */
					
	private Double wu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：会计
	 */
	public void setHuiji(String huiji) {
		this.huiji = huiji;
	}
	/**
	 * 获取：会计
	 */
	public String getHuiji() {
		return huiji;
	}
	/**
	 * 设置：时间
	 */
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	/**
	 * 获取：时间
	 */
	public String getShijian() {
		return shijian;
	}
	/**
	 * 设置：报表类型
	 */
	public void setBaobiaoleixing(String baobiaoleixing) {
		this.baobiaoleixing = baobiaoleixing;
	}
	/**
	 * 获取：报表类型
	 */
	public String getBaobiaoleixing() {
		return baobiaoleixing;
	}
	/**
	 * 设置：1
	 */
	public void setYi(Double yi) {
		this.yi = yi;
	}
	/**
	 * 获取：1
	 */
	public Double getYi() {
		return yi;
	}
	/**
	 * 设置：2
	 */
	public void setEr(Double er) {
		this.er = er;
	}
	/**
	 * 获取：2
	 */
	public Double getEr() {
		return er;
	}
	/**
	 * 设置：3
	 */
	public void setSan(Double san) {
		this.san = san;
	}
	/**
	 * 获取：3
	 */
	public Double getSan() {
		return san;
	}
	/**
	 * 设置：4
	 */
	public void setSi(Double si) {
		this.si = si;
	}
	/**
	 * 获取：4
	 */
	public Double getSi() {
		return si;
	}
	/**
	 * 设置：5
	 */
	public void setWu(Double wu) {
		this.wu = wu;
	}
	/**
	 * 获取：5
	 */
	public Double getWu() {
		return wu;
	}

}
