package com.aliyun.cs.controller.rabbit;

import com.aliyun.cs.model.Member;
import com.aliyun.cs.model.Product;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.rabbitmq.client.Channel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zengzhangni
 * @date 2019/7/31
 */
@Api(tags = "Mq测试")
@RestController
@RequestMapping("rabbit")
public class RabbitController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @ApiOperation(value = "添加项目(商品)基本信息")
    @PostMapping("/insert")
    public ResponseMessage insert() {
        Member member = new Member();
        member.setMemberNickname("zzn147");
        member.setMemberUuid("No.369852147");
        member.setRegisterPhone("147258369");
        System.out.println(rabbitTemplate);
        rabbitTemplate.convertAndSend("zzn", "zzn.add", member);
        return new ResponseMessage<>();
    }


    @RabbitListener(queues = "zzntest")
    public void listener(Member member, Channel channel, Message message,@Header(name = "amqp_deliveryTag") long deliveryTag,@Header(name = "body") Object o) throws IOException {
        System.out.println(channel);
        System.out.println(member);
        System.out.println(message);
        System.out.println(deliveryTag);
        System.out.println(o);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


}
