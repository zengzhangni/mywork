package com.aliyun.cs.mapper;


import com.aliyun.cs.model.Menu;
import com.aliyun.cs.utils.base.BaseMapper;

import java.util.List;


public interface MenuMapper extends BaseMapper<Menu> {


    List<Menu> getAll();

}