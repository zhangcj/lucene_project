package com.autohome.lucene.dao;

import com.autohome.lucene.entity.Project;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface ProjectDao {
    public List<Project> queryAllProject();
    public boolean addProject(Project project);
}
