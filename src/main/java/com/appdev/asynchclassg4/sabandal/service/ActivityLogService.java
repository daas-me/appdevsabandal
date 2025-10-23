package com.appdev.asynchclassg4.sabandal.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asynchclassg4.sabandal.entity.ActivityLogEntity;
import com.appdev.asynchclassg4.sabandal.repository.ActivityLogRepository;

@Service
public class ActivityLogService {
    @Autowired
    ActivityLogRepository actlogrepo;

    public ActivityLogService(){
        super();
    }

     public ActivityLogEntity saveActivityLog(ActivityLogEntity activityLog){
        return actlogrepo.save(activityLog);
    }

    public List<ActivityLogEntity> getAllActivityLog(){
        return actlogrepo.findAll();
    }

    public ActivityLogEntity updateActivityLog(int log_id, ActivityLogEntity newActivityLog){
        ActivityLogEntity activityLog = new ActivityLogEntity();
        try{
            activityLog = actlogrepo.findById(log_id).get();

            activityLog.setActivityType(newActivityLog.getActivityType());
            activityLog.setTimestamp(newActivityLog.getTimestamp());
        }catch(NoSuchElementException ex){
            throw new NoSuchElementException("Activity Log " + log_id + " does not exist!");
        }
            return actlogrepo.save(activityLog);
        }

    public String deleteActivityLog(int log_id){
        String msg = "";

        if(actlogrepo.findById(log_id) != null){
            actlogrepo.deleteById(log_id);
            msg = "Activity Log " + log_id + " is successfully deleted!";
        } else {
            msg = "Activity Log " + log_id + " does not exist!";
        }
        return msg;
    }
}


