package com.aliyun.cs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * BaseService 实现
 *
 * @author zengzhangni
 * @date 2019/4/28
 */
@Transactional(rollbackFor = Exception.class)
public class BaseServiceImpl<T> implements SpringCloudBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    /**
     * 新增
     *
     * @param t 新增数据
     * @return 是否新增成功
     */
    @Override
    public int addObj(T t) {
        return this.baseMapper.insertSelective(t);
    }

    /**
     * 通过id删除
     *
     * @param id 主键
     * @return 是否删除成功
     */
    @Override
    public int deleteObjById(int id) {
        return this.baseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     *
     * @param t 修改数据
     * @return 是否修改成功
     */
    @Override
    public int modifyObj(T t) {
        return this.baseMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 通过id查询
     *
     * @param id 主键
     * @return 查询数据
     */
    @Override
    public T queryObjById(int id) {
        return this.baseMapper.selectByPrimaryKey(id);
    }


}
