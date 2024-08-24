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
 * 账目类别
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("zhangmuleibie")
public class ZhangmuleibieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhangmuleibieEntity() {
		
	}
	
	public ZhangmuleibieEntity(T t) {
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
	 * 财务科目
	 */
					
	private String caiwukemu;
	
	/**
	 * 摘要
	 */
					
	private String zhaiyao;
	
	/**
	 * 报表项目
	 */
					
	private String baobiaoxiangmu;
	
	
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
	 * 设置：财务科目
	 */
	public void setCaiwukemu(String caiwukemu) {
		this.caiwukemu = caiwukemu;
	}
	/**
	 * 获取：财务科目
	 */
	public String getCaiwukemu() {
		return caiwukemu;
	}
	/**
	 * 设置：摘要
	 */
	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}
	/**
	 * 获取：摘要
	 */
	public String getZhaiyao() {
		return zhaiyao;
	}
	/**
	 * 设置：报表项目
	 */
	public void setBaobiaoxiangmu(String baobiaoxiangmu) {
		this.baobiaoxiangmu = baobiaoxiangmu;
	}
	/**
	 * 获取：报表项目
	 */
	public String getBaobiaoxiangmu() {
		return baobiaoxiangmu;
	}

}
