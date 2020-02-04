package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * spu信息
 *
 * @author chenGJ
 * @email 3546766954@qq.com
 * @date 2020-02-04 13:55:30
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

