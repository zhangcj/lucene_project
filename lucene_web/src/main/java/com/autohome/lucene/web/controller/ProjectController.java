package com.autohome.lucene.web.controller;

import com.autohome.lucene.entity.Project;
import com.autohome.lucene.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired(required = false)
    ProjectService projectService;

    @RequestMapping(value = "/all/",method = RequestMethod.GET)
    public String all(ModelMap modelMap){
        List<Project> projects = projectService.queryAllProject();
        modelMap.addAttribute("Models",projects);
        return "/project/all.htm";
    }
}
