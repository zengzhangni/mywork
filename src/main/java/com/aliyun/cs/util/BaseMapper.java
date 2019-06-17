package com.aliyun.cs.util;

import java.util.List;

/**
 * Created by GaoWei on 2017/9/19.
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(T t);

    int insertListSelective(List<T> list);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    List<T> selectListByConditions(T t);
}
