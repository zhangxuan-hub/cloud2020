package com.zx.springcloud.entities;


import java.io.Serializable;

/**
 * @ClassName Payment
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/5 20:11
 * @Version 1.0
 */

public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
