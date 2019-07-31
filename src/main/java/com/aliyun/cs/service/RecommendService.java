package com.aliyun.cs.service;


import com.aliyun.cs.model.Recommend;
import com.aliyun.cs.utils.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */

public interface RecommendService extends BaseService<Recommend> {

    List getRecommend(String memberUuid);

}