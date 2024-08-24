package com.cl.entity.view;

import com.cl.entity.HuijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 会计
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-25 09:31:06
 */
@TableName("huiji")
public class HuijiView  extends HuijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuijiView(){
	}
 
 	public HuijiView(HuijiEntity huijiEntity){
 	try {
			BeanUtils.copyProperties(this, huijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
