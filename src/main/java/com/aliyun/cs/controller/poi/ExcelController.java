package com.aliyun.cs.controller.poi;

import com.aliyun.cs.model.Member;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.utils.poi.ExportExcelUtil;
import com.aliyun.cs.utils.poi.ExportExcelWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/4/12
 */
@Api(tags = "表格测试")
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Resource
    private MemberService memberService;

    @ApiOperation(value = "获取表格")
    @GetMapping("/getMemberList")
    public void getExcel(HttpServletResponse response) {
        List<Member> list = memberService.findByConditions();
        List<String> columnNames = Arrays.asList("ID", "会员昵称", "会员uuid", "注册账号", "密码", "注册手机号", "性别", "会员头像", "个人签名", "出生年月");
        String fileName = "会员列表";
        ExportExcelWrapper<Member> util = new ExportExcelWrapper<>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEL_FILE_2003);
    }


//    @ApiOperation(value = "获取表格")
//    @GetMapping("/getExcel")
//    public void getExcel2(HttpServletResponse response) {
//        List<User> list = getData();
//        List<String> columnNames = new ArrayList<>();
//        Field[] fields = list.get(0).getClass().getDeclaredFields();
//        for (Field field : fields) {
//            ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
//            columnNames.add(annotation.value());
//        }
//        ApiModel apiModel = list.get(0).getClass().getAnnotation(ApiModel.class);
//        String fileName = apiModel.value();
//        ExportExcelWrapper<User> util = new ExportExcelWrapper<>();
//        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEL_FILE_2003);
//    }


}
