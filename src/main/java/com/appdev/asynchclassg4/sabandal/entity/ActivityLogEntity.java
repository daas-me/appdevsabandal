package com.appdev.asynchclassg4.sabandal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblActivityLog")
public class ActivityLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="log_id")
    private int log_id;

    @Column(name="activity_type")
    private String activityType;

    @Column(name="timestamp")
    private LocalDateTime timestamp;

    public ActivityLogEntity(){
        super();
    }

    public ActivityLogEntity(int log_id, String activityType, LocalDateTime timestamp){
        super();
        this.log_id = log_id;
        this.activityType = activityType;
        this.timestamp = timestamp;
    }
    public int getLogId(){
        return log_id;
    }

    public void setLogId(int log_id){
        this.log_id = log_id;
    }
    public String getActivityType(){
        return activityType;
    }

    public void setActivityType(String activityType){
        this.activityType = activityType;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
}
