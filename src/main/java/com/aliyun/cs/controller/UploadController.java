package com.aliyun.cs.controller;

import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author zengzhangni
 * @date 2019/6/21
 */
@Api(tags = "文件上传")
@RestController
@RequestMapping("upload")
public class UploadController {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir").replaceAll("\\\\","/"));
    }

    @ApiOperation("上传文件[公开读]")
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseMessage<String> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
        Random random = new Random();
        String fileName = random.nextInt(10000) + System.currentTimeMillis() + ".png";
        String destFileName = "D:/GitHub/mywork/src/main/resources/static/upload/" + fileName;

        File destFile = new File(destFileName);
        file.transferTo(destFile);
        System.out.println(destFile);
        return new ResponseMessage<>("/upload/"+fileName);

    }


}
