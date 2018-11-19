package com.corn.commondemo.entity;

import java.io.Serializable;

/**
 * @Auther: suyiming
 * @Date: 18-11-19 22:58
 * @Description:
 */
public class Order implements Serializable {
    public String id;
    public String name;
    public String messageId;

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
