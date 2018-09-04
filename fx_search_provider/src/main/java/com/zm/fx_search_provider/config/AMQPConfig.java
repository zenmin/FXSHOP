package com.zm.fx_search_provider.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Describle This Class Is 初始化消息队列
 * @Author ZengMin
 * @Date 2018/9/2 20:22
 */
@Service
public class AMQPConfig {

    @Autowired
    AmqpAdmin admin;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @PostConstruct
    public void createQueues(){
        try {
            //新建交换器                                  //名称                //是否持久化         //是否自动删除
            admin.declareExchange(new DirectExchange("fxshop.exchange",true,false));
            //新建队列
            String s = admin.declareQueue(new Queue("fxshop.index"));
            //绑定队列到交换器上
            admin.declareBinding(new Binding("fxshop.index", Binding.DestinationType.QUEUE, "fxshop.exchange", "fxshop.refreshIndex", null));
            System.out.println("AMQP消息服务器连接成功：host:" + rabbitTemplate.getConnectionFactory().getHost() + " port:" +  rabbitTemplate.getConnectionFactory().getPort());
        }catch (Exception e){
            System.out.println("AMQP服务器连接失败，请检查服务器连接！");
            e.printStackTrace();
        }
    }
}
