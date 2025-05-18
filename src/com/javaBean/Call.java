package com.javaBean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 维修实体类
 */
public class Call {

    private int id; //id主键
    private String responsible;//负责人工号
    private int car_id;//车辆ID
    private String date_time;//时间
    private String  is_return;//是否归还


    public String getIs_return() {
        return is_return;
    }

    public void setIs_return(String is_return) {
        this.is_return = is_return;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public Call() {
    }

    public Call(int id,String responsible,int car_id,String  date_time,String is_return
                  ) {
        this.id = id;
        this.date_time = date_time;
        this.responsible = responsible;
        this.is_return = is_return;
        this.car_id=car_id;

    }
    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", date_time='" + date_time + '\'' +
                ", responsible='" + responsible + '\'' +
                ", is_return='" + is_return + '\'' +
                ", car_id='" + car_id + '\'' +


                '}';
    }
}
