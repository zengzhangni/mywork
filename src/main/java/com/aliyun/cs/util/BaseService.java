package com.aliyun.cs.util;


/**
 * Created by GaoWei on 2017/9/7.
 */
public interface BaseService<T> {
     ResponseMessage<T> addObj(T t);

     ResponseMessage<T> deleteObjById(int id);

     ResponseMessage<T> modifyObj(T t);

     ResponseMessage<T> queryObjById(int id);

}
