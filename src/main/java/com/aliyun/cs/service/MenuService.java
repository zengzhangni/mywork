package com.aliyun.cs.service;


import com.aliyun.cs.model.Menu;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.aliyun.cs.utils.base.BaseService;

import java.util.List;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
public interface MenuService extends BaseService<Menu> {

    List<Menu> getTree();


}