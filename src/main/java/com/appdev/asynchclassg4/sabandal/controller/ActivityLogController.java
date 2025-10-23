package com.appdev.asynchclassg4.sabandal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.asynchclassg4.sabandal.entity.ActivityLogEntity;
import com.appdev.asynchclassg4.sabandal.service.ActivityLogService;

@RestController
@RequestMapping(method = RequestMethod.GET,path="/api/activity")
public class ActivityLogController {
    @Autowired
    ActivityLogService actlogserv;

    @PostMapping("/postActivityLog")
    public ActivityLogEntity postActivityLog(@RequestBody ActivityLogEntity activityLog){
        return actlogserv.saveActivityLog(activityLog);
    }

     @GetMapping("/getAllActivityLog")
    public List<ActivityLogEntity> getAllActivityLog(){
        return actlogserv.getAllActivityLog();
    }

}
