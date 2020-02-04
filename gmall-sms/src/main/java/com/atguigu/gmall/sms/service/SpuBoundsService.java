package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SpuBoundsEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品spu积分设置
 *
 * @author chenGJ
 * @email 3546766954@qq.com
 * @date 2020-02-04 15:07:00
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageVo queryPage(QueryCondition params);
}

