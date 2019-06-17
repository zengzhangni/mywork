package com.aliyun.cs.utils.base;

public interface SpringCloudBaseService<T> {
    int addObj(T t);

    int deleteObjById(int id);

    int modifyObj(T t);

    T queryObjById(int id);

//    ResponseMessage<PageInfo<T>> findByPageForFront(Integer pageNo, Integer pageSize, T t);
}
