package com.aliyun.cs.controller.system;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
        System.out.println(System.getProperty("user.dir").replaceAll("\\\\", "/"));
    }

    @ApiOperation("上传文件[公开读]")
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
        Random random = new Random();
        String fileName = random.nextInt(10000) + System.currentTimeMillis() + ".png";
        String all = System.getProperty("user.dir").replaceAll("\\\\", "/");
        String destFileName = all + "/src/main/resources/static/upload/" + fileName;

        File destFile = new File(destFileName);
        file.transferTo(destFile);
        System.out.println(destFile);
        return "http://localhost/upload/" + fileName;

    }

    @ApiOperation("支付宝测试")
    @GetMapping(value = "/pay")
    public Object pay() throws AlipayApiException {
        String appId = "2016092300581273";
        String rsaPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCu9U5qdtmZ2YIvKeALtfoqpiS/GF+H5d7bBSkftbhV15MemzUu19h5yNeXMfsYUKDXhVuGObbyxFp+xpxkwf0rbkRRJ5yPc3NRxZwWQS4MMdEAxGTt2FuqZA7kw7yLRuf8QLOPjkae5Vs63rQZpjkgSrbbw+/BLGDt//OqbxAQTvHF9is8kOfZHLYjfzAPxl8z1ufzy8JfEkKNdUZpyr/djz+7tmF7QzAwbB50MJSZM/UFhY7tqNsIRuUwCga/xfQEEEHFjOE7HO3s6Bo3jlmcTAp3mww9+p4MeCuq9oSbtPoofchFk8exnID/xi5ez0Rm2EyKCFivpaTFIxrxGG0xAgMBAAECggEACPj5oYog1LwL6iFKpS8a+k70+XvlglGuoSrdlgu6vWRF3j71dkaJio1bSRy+FNwls4faTsLs9/xL686BvMUaF70a8dKHO/AezOXGgHmtQ+DWKCTqTCxZXx6siNzk8XuccBpdWxJf2sxGZnl/YQVeTqKmSBT/WbfN7MbAl1AE0eE02Vr4E8nlCS5NjIsL64QUmf7gSOYNkZX1zUp52epjFRVeicOFAR2BZoXyvJZviWil6zrX7q2kFz5edzhwJ7LQbW8VZ/3K+ydrMx7H3l8/RY31L8g7x4lTW7GsYv+wDMw8/955ROYLbcsSXOv/3B0YNSKjbFoA9TFyF8d6aDTXQQKBgQDcaYa0a8E51Sq92IpttXKpdN3qko5nFo2WuRE3zWK88CkqUDdrL9MZVrbanWfKOPYzWpX1Jqb/ts4ONpiVk35wFWOD9scHmlKx1HopC3X+5sfCMxvkvI8spd4XoC3cg+eZ7pSLENEERvntXhVqzLK/SgptWyeAnCRrI6Zt/AqiCQKBgQDLNP6M7DvZ9V8QEaHt9EMYrqLmFvNJLs81wBvqU0RddHxt/jDU4oQVBSxfJHZeE8Eye0Xi71UgLsfZD+uCrmBWIvaPanHW0F1JsDu/k0svdfmtNbAp4l+Rnkczmb7ARwEb+MBnEe2e8ct3hrMQy9mew3iY9QjO/0oiTmutDrQb6QKBgQC22jCvQumVMdv4jUkiBLKwFEz6CkVrDlG+JaA8G/564f40pUGkgZNuZPrjWEw/fov5RIA9VaibYauGLRLem/L7xzK8yqCJFSTfdHc3z9M++XPlDwNn+moIzz31eaQyWZdso3nF+Nh95Of4XOIFrPXpLeKCoGmgD2lDHNs4SS0FCQKBgEeZoKefBWfDIX/T9q6Vhp7HyfYw2ABNUg2qZyuls00Kol1PV31rYwbVD9FmU57KbySOcw2HLwNr+FbvWRhuwNsY7q+R3hLG0FgKlMLn73IFq7fwVuYrMWlpz8TKw3+UhTuJ5qFqm8OJhxvShn3Aliluzqt2i2gEY+a6ow4TRDshAoGAI5Dpcfe1J5wQmM+EEsYwsgTPK/ZDczwhrpYlM5LOGo8lX/19GNv5CPquPj3VRHEWKY/mF3n3GOgIs9fcFa4HF0OXA60WVzvDKXrtJHXxYnN0ALyH4rUjA6gJgtzQV0qhcqRGYmKTmG8anPResiOKHEgCHveJG/MjnM7YMwbHdv8=";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArisF8z7QhjMhEFJrTJa34o3ZzKNa1RELUbraKhsBOhoB4fFcYwR6yGY5C/0C+sv480R6VBQWlyOo9kc2fg+RLu6a/1f/qWPKa5dMWAT8AR5fAhyRT5ep5kg0EAQGH3g/lXDyy2wNN19coE7e1M2NeMZRJ7lQu4JpRCvZ/fDxugFykaAGy13wKfqjU+gqn0SJsfu4IYrSDbIeTnQqvaza8Njkib4VWYsSWnOoR+/UlwZ99jgxoj5oSKXs0j0sdk/br0UsRthgI+H6UNLVOLV9VER829w/IKyKUG9VC4Yqm5iovh3ecjuJ2AP4ykE36xlInQtevJRb1VElMs5scD+CgQIDAQAB";
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", appId, rsaPrivateKey, "json", "UTF-8", alipayPublicKey, "RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);

        model.setOutTradeNo(System.currentTimeMillis() + "");
        model.setTotalAmount("88.88");
        model.setSubject("Iphone6 16G");
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.print(response.getBody());
        return response.getBody();
    }

}
