package com.javaBean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 维修实体类
 */
public class Accident {

    private int id; //id主键
    private String date_time;//时间
    private String location;//事故发生地点
    private String accident_type;//事故类型
    private String accident_level;//严重等级
    private String responsible;//负责人工号
    private int car_id;//车辆ID

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccident_type() {
        return accident_type;
    }

    public void setAccident_type(String accident_type) {
        this.accident_type = accident_type;
    }

    public String getAccident_level() {
        return accident_level;
    }

    public void setAccident_level(String accident_level) {
        this.accident_level = accident_level;
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

    public Accident() {
    }

    public Accident(int id,String date_time,String location, String accident_type,String accident_level,String responsible,
                  int car_id) {
        this.id = id;
        this.date_time = date_time;
        this.location = location;
        this.accident_type = accident_type;
        this.accident_level=accident_level;
        this.responsible=responsible;
        this.car_id=car_id;

    }
    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", date_time='" + date_time + '\'' +
                ", location='" + location + '\'' +
                ", accident_type='" + accident_type + '\'' +
                ", accident_level='" + accident_level + '\'' +
                ", car_id='" + car_id + '\'' +
                ", responsible='" + responsible + '\'' +
                '}';
    }
}
