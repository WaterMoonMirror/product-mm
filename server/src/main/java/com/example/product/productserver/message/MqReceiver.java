package com.example.product.productserver.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: tkn
 * @Date: 2018/7/8 21:59
 * @Description:
 */
@Component
@Slf4j
public class MqReceiver {
    /**
     * 第一种创建方式：需要自己添加队列
     *  接受消息
     * @param message
     */
//    @RabbitListener(queues="MyQueue")
//    public void process(String message){
//        log.info("MqReceiver:{}",message);
//
//    }

    /**
     * 第二种创建方式：自动添加队列
     * @param message
     */
//    @RabbitListener(queuesToDeclare=@Queue("MyQueue"))
//    public void process(String message){
//        log.info("MqReceiver:{}",message);
//
//    }

    /**
     * 第三种创建方式：自动添加队列,并且队列和Exchange绑定
     * @param message
     */
//    @RabbitListener(bindings =@QueueBinding(
//            value = @Queue("MyQueue"),
//            exchange = @Exchange("MyExchange")
//    ))
//    public void process(String message){
//        log.info("MqReceiver:{}",message);
//
//    }
    /**
     *  绑定Exchange创建队列
     *  水果
     * @param message
     */
    @RabbitListener(bindings =@QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key="computer"
            
    ))
    public void computerProcess(String message){
        log.info("MqReceiver:{}",message);

    }
    
    /**
     *  绑定Exchange创建队列
     *  电器
     * @param message
     */
    @RabbitListener(bindings =@QueueBinding(
            value = @Queue("fruitOrder"),
            exchange = @Exchange("myOrder"),
            key="fruit"
    ))
    public void fruitProcess(String message){
        log.info("MqReceiver:{}",message);

    }

}
