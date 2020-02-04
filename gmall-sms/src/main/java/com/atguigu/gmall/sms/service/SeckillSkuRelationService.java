package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SeckillSkuRelationEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 秒杀活动商品关联
 *
 * @author chenGJ
 * @email 3546766954@qq.com
 * @date 2020-02-04 15:07:00
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageVo queryPage(QueryCondition params);
}

