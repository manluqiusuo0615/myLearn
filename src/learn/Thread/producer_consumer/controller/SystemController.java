package learn.Thread.producer_consumer.controller;

import learn.Thread.producer_consumer.consumer.Consumer;
import learn.Thread.producer_consumer.pojos.Basket;
import learn.Thread.producer_consumer.producer.Producer;

import java.lang.reflect.Constructor;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-10 14:55
 */
public class SystemController {
    public static void main(String[] args) {
        Basket basket = new Basket(1);

        Producer producer = new Producer("生产者A",basket);
        Producer producerB = new Producer("生产者B",basket);
        Consumer consumer = new Consumer("消费者MM",basket);

        producer.start();
        producerB.start();
        consumer.start();

    }
}
