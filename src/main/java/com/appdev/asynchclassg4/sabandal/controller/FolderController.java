package com.appdev.asynchclassg4.sabandal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.asynchclassg4.sabandal.entity.FolderEntity;
import com.appdev.asynchclassg4.sabandal.service.FolderService;

@RestController
@RequestMapping(method = RequestMethod.GET,path="/api/folders")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService){
        this.folderService = folderService;
    }

    @GetMapping
    public List<FolderEntity> getAllFolder(){
        return folderService.getAllFolder();
    }

    @PostMapping
    public FolderEntity addFolder(@RequestBody FolderEntity folder){
        return folderService.saveFolder(folder);
    }
}
