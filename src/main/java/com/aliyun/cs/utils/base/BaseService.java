package com.aliyun.cs.utils.base;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {
    int addObj(T t);

    int deleteObjById(int id);

    int modifyObj(T t);

    T queryObjById(int id);

    PageInfo<T> findByPageForFront(Integer pageNo, Integer pageSize, T t);
}
