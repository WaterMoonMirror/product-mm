package com.example.product.productserver.Controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: tkn
 * @Date: 2018/7/8 22:02
 * @Description:
 */
@RestController
public class SendMessageController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     *
     * 发送消息
     */
    @GetMapping("/sendMessage")
    public void sendMessage(){
           // amqpTemplate.convertAndSend("MyQueue","now "+new Date());
    	// 发送电器
    	amqpTemplate.convertAndSend("myOrder","computer","now "+new Date());
    	// 发送水果
    	amqpTemplate.convertAndSend("myOrder","fruit","now "+new Date());
    }
}
