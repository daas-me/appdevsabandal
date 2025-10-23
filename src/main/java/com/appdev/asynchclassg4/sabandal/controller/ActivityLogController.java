package com.appdev.asynchclassg4.sabandal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/updateActivityLog")
    public ActivityLogEntity updateActivityLog(@RequestParam int log_id,@RequestBody ActivityLogEntity newActivityLog){
        return actlogserv.updateActivityLog(log_id, newActivityLog);
    }

    @DeleteMapping("/deleteActivityLog")    
    public String deleteActivityLog(@PathVariable int log_id){
        return actlogserv.deleteActivityLog(log_id);
    }
}
