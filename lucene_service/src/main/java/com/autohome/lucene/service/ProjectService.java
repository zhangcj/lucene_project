package com.autohome.lucene.service;

import com.autohome.lucene.entity.Project;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface ProjectService {
    public List<Project> queryAllProject();
    public boolean addProject(Project project);
}
