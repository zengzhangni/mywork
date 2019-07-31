package com.aliyun.cs.mapper;


import com.aliyun.cs.model.Product;
import com.aliyun.cs.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> queryByProductIdList(@Param("idList") Set<Integer> idList);

    List<String> queryTagByProductIdList(List<Integer> list);

    Set<Integer> getIdList(@Param("oList") List<Integer> oList, @Param("tagList") List<String> tagList2);

}