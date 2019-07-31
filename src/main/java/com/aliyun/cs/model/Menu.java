package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "菜单")
public class Menu  implements Serializable {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("父id")
    private Integer pId;
    @ApiModelProperty("菜单名")
    private String name;
    @ApiModelProperty("地址")
    private String url;
    @ApiModelProperty(value = "子菜单", hidden = true)
    private List<Menu> childs;

}
