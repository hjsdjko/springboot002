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
 * 预算填写
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("yusuantianxie")
public class YusuantianxieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YusuantianxieEntity() {
		
	}
	
	public YusuantianxieEntity(T t) {
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
	 * 预算员
	 */
					
	private String yusuanyuan;
	
	/**
	 * 时间
	 */
					
	private String shijian;
	
	/**
	 * 投资预算
	 */
					
	private Double touziyusuan;
	
	/**
	 * 筹资预算
	 */
					
	private Double chouziyusuan;
	
	/**
	 * 经营预算
	 */
					
	private Double jingyingyusuan;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
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
	 * 设置：预算员
	 */
	public void setYusuanyuan(String yusuanyuan) {
		this.yusuanyuan = yusuanyuan;
	}
	/**
	 * 获取：预算员
	 */
	public String getYusuanyuan() {
		return yusuanyuan;
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
	 * 设置：投资预算
	 */
	public void setTouziyusuan(Double touziyusuan) {
		this.touziyusuan = touziyusuan;
	}
	/**
	 * 获取：投资预算
	 */
	public Double getTouziyusuan() {
		return touziyusuan;
	}
	/**
	 * 设置：筹资预算
	 */
	public void setChouziyusuan(Double chouziyusuan) {
		this.chouziyusuan = chouziyusuan;
	}
	/**
	 * 获取：筹资预算
	 */
	public Double getChouziyusuan() {
		return chouziyusuan;
	}
	/**
	 * 设置：经营预算
	 */
	public void setJingyingyusuan(Double jingyingyusuan) {
		this.jingyingyusuan = jingyingyusuan;
	}
	/**
	 * 获取：经营预算
	 */
	public Double getJingyingyusuan() {
		return jingyingyusuan;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
