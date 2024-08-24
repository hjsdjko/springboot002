package com.cl.entity.view;

import com.cl.entity.BaobiaotianxieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 报表填写
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("baobiaotianxie")
public class BaobiaotianxieView  extends BaobiaotianxieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaobiaotianxieView(){
	}
 
 	public BaobiaotianxieView(BaobiaotianxieEntity baobiaotianxieEntity){
 	try {
			BeanUtils.copyProperties(this, baobiaotianxieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
