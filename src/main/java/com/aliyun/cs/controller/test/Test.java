package com.aliyun.cs.controller.test;

import com.aliyun.cs.model.Activity;
import com.aliyun.cs.model.Member;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengzhangni
 * @date 2019/7/29
 */
public class Test {
    public static void main(String[] args) {
        a();
        b();
        c();
    }

    private static void a() {
        new Thread(() -> {
            System.out.println("吃饭");
            try {
                Thread.sleep(5000);
                System.out.println("吃完饭");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    private static void b() {
        new Thread(() -> {
            System.out.println("喝酒");
            try {
                Thread.sleep(5000);
                System.out.println("喝完酒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static void c() {
        new Thread(() -> {
            System.out.println("唱歌");
            try {
                Thread.sleep(5000);
                System.out.println("唱完歌");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


    @ApiOperation(value = "添加活动表")
    @PostMapping("/save")
    public Integer save(@RequestBody Activity activity) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //假如前台就传了这3个字段 时间应该是Date类型 这里为了好看
        String activityName = "活动";
        String beginTime = "2019-08-01 12:00:00";
        String endTime = "2019-08-05 12:00:00";

        //现在这个对象就是前台传过来 赋值了3个字段
        activity.setActivityName(activityName);
        activity.setBeginTime(format.parse(beginTime));
        activity.setEndTime(format.parse(endTime));

        //自己生成活动编号
        String activityNo = "147258";
        //设置编号
        activity.setActivityNo(activityNo);
        //设置默认为终止
        activity.setIsTermination(1);

        //保存活动
//        activityMapper.save(activity);
        return 1;
    }


    @ApiOperation(value = "添加活动表")
    @PostMapping("/详情")
    public Map 详情(@RequestParam String activityNo) {
        //这个时候 用户前台就能看到这个活动
        //然后点击进来  就会调用这个详情接口
        //然后前台传一个活动编码过来
        Map<String, Object> map = new HashMap<>(3);

        //应该通过编码查询出这个活动
//        Activity activity = activityMapper.queryByactivityNo(activityNo);
        //我假如查出来了
        Activity activity = new Activity();

        //获取当前时间
        long currentTime = System.currentTimeMillis();
        //获取活动开始时间
        long beginTime = activity.getBeginTime().getTime();
        //获取结束时间
        long endTime = activity.getEndTime().getTime();
        //获取是否终止
        Integer isTermination = activity.getIsTermination();

        //如果当前时间 小于开始时间 说明未开始
        if (currentTime < beginTime) {
            map.put("code", 140500);
            map.put("message", "未开始");
        } else if (currentTime > endTime || isTermination == 0) {
            //如果当前时间 大于结束时间 说明以结束
            //说明以终止  管理员后台提前终止  改变这个活动状态 用户在查询时就会告知提前终止
            map.put("code", 140501);
            map.put("message", "结束");
        } else {
            //如果都通过
            map.put("code", 200);
            map.put("message", "进行中");
        }
        //最后不管状态返回什么 都把查询的活动对象返回
        map.put("data", activity);
        return map;
        /**
         * 这样新增一个活动后 用户界面就能看到  但是用户来请求是发现时间没到 就会提示未开始
         *  快到点了 用户就一直刷新一直请求 时间到点自然就返回进行中 前台就可以点击
         *  或者时间到了 用户在请求 就告知结束 就不能点击
         *  或者后台点击终止按钮提前终止活动   也不能点击
         * 还有什么其他都差不多这个逻辑 可以加一些 也可以少一些
         * */
    }

}
