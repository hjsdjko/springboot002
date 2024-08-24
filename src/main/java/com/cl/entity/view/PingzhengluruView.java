package com.cl.entity.view;

import com.cl.entity.PingzhengluruEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 凭证录入
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("pingzhengluru")
public class PingzhengluruView  extends PingzhengluruEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingzhengluruView(){
	}
 
 	public PingzhengluruView(PingzhengluruEntity pingzhengluruEntity){
 	try {
			BeanUtils.copyProperties(this, pingzhengluruEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
