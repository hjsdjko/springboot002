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
 * 凭证录入
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("pingzhengluru")
public class PingzhengluruEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PingzhengluruEntity() {
		
	}
	
	public PingzhengluruEntity(T t) {
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
	 * 金额
	 */
					
	private Double jine;
	
	/**
	 * 附件
	 */
					
	private String fujian;
	
	/**
	 * 记账时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jizhangshijian;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 记账员
	 */
					
	private String jizhangyuan;
	
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
	 * 设置：金额
	 */
	public void setJine(Double jine) {
		this.jine = jine;
	}
	/**
	 * 获取：金额
	 */
	public Double getJine() {
		return jine;
	}
	/**
	 * 设置：附件
	 */
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}
	/**
	 * 获取：附件
	 */
	public String getFujian() {
		return fujian;
	}
	/**
	 * 设置：记账时间
	 */
	public void setJizhangshijian(Date jizhangshijian) {
		this.jizhangshijian = jizhangshijian;
	}
	/**
	 * 获取：记账时间
	 */
	public Date getJizhangshijian() {
		return jizhangshijian;
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
	 * 设置：记账员
	 */
	public void setJizhangyuan(String jizhangyuan) {
		this.jizhangyuan = jizhangyuan;
	}
	/**
	 * 获取：记账员
	 */
	public String getJizhangyuan() {
		return jizhangyuan;
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
