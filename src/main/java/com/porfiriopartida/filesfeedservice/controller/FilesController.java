package com.porfiriopartida.filesfeedservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/files")
public class FilesController {
    static FilesFeed current;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void setProjectFiles(@RequestBody(required = true) FilesFeed feed, HttpServletRequest request,
                                HttpServletResponse response){
        if(current == null){
            current = new FilesFeed();
        }
        current.setFiles( feed.getFiles() );
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public FilesFeed getProjectFiles(HttpServletRequest request,
                                     HttpServletResponse response){
        if(current == null){
            current = new FilesFeed();
        }
        return current;
    }
}
