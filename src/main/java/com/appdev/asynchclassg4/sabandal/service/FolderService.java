package com.appdev.asynchclassg4.sabandal.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asynchclassg4.sabandal.entity.FolderEntity;
import com.appdev.asynchclassg4.sabandal.repository.FolderRepository;

@Service
public class FolderService {
    @Autowired
    FolderRepository folderrepo;

    public FolderService(){
       super();
    }

     public FolderEntity saveFolder(FolderEntity folder){
        return folderrepo.save(folder);
    }

    public List<FolderEntity> getAllFolder(){
        return folderrepo.findAll();
    }

    public FolderEntity updateFolder(int folder_id, FolderEntity newFolder){
        FolderEntity folder = new FolderEntity();

        try{
            folder = folderrepo.findById(folder_id).get();

        folder.setFolderName(newFolder.getFolderName());
        folder.setDateCreated(newFolder.getDateCreated());
        } catch(NoSuchElementException ex){
            throw new NoSuchElementException("Folder " + folder_id + " does not exist!");
        }
        return folderrepo.save(folder);
    }

    public String deleteFolder(int folder_id){
        String msg = "";

        if(folderrepo.findById(folder_id) != null){
            folderrepo.deleteById(folder_id);
            msg = "Folder " + folder_id + " is successfully deleted.";
        } else{
            msg = "Folder " + folder_id + " does not exist!";
        }
       return msg;
    }

}
