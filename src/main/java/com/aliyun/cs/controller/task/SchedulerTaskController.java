package com.aliyun.cs.controller.task;

import com.aliyun.cs.model.ScheduleJob;
import com.aliyun.cs.service.TaskService;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zengzhangni
 * @date 2019/7/29
 */
@Api(tags = "定时任务")
@RestController
@RequestMapping("task")
public class SchedulerTaskController {


    @Autowired
    private TaskService taskService;

    /**
     * 列表查询
     * @return
     */
    @ApiOperation("列表查询")
    @GetMapping("/findByPage")
    public ResponseMessage<PageInfo<ScheduleJob>> findByPage(@ApiParam(value = "pageNo",defaultValue = "0") @RequestParam(value = "pageNo",defaultValue = "0") Integer pageNo,
                                                             @ApiParam(value = "pageSize",defaultValue = "10") @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        PageInfo<ScheduleJob> pageInfo =  taskService.findByPage(pageNo,pageSize);
        return new ResponseMessage<>(pageInfo);
    }


    /**
     * 保存
     * @param entity
     * @return
     */
    @ApiOperation("保存-----暂时不做")
    @PostMapping("/save")
    public ResponseMessage save(@ApiParam("任务") @RequestBody ScheduleJob entity){
        int i = taskService.saveJob(entity);
        return new ResponseMessage(i);
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    @ApiOperation("修改")
    @PutMapping("/modify")
    public ResponseMessage modify(@RequestBody ScheduleJob entity){
        int i = taskService.update(entity);
        return new ResponseMessage(i);
    }


    /**
     * 删除
     * @param jobClass
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("/delete/{jobClass:.+}")
    public ResponseMessage delete(@ApiParam("jobClass") @PathVariable("jobClass") String jobClass){
        int i = taskService.delete(jobClass);
        return new ResponseMessage(i);
    }


    /**
     * 暂停
     * @param jobClass
     * @return
     */
    @ApiOperation("暂停")
    @PutMapping("/pause/{jobClass:.+}")
    public ResponseMessage pause(@PathVariable("jobClass") String jobClass){
        int i = taskService.pause(jobClass);
        return new ResponseMessage(i);
    }

    /**
     * 恢复
     * @param jobClass
     * @return
     */
    @ApiOperation("恢复")
    @PutMapping("/resume/{jobClass:.+}")
    public ResponseMessage resume(@PathVariable("jobClass") String jobClass){
        int i = taskService.resume(jobClass);
        return new ResponseMessage(i);
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @ApiOperation("详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<ScheduleJob> detail(@PathVariable("id") Integer id){
        ScheduleJob scheduleJob = taskService.detail(id);
        return new ResponseMessage<>(scheduleJob);
    }


}
