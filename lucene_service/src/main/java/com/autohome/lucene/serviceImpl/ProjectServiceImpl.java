package com.autohome.lucene.serviceImpl;

import com.autohome.lucene.dao.ProjectDao;
import com.autohome.lucene.entity.Project;
import com.autohome.lucene.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectDao projectDao;

    /*
    获取所有符合条件的项目
     */
    public List<Project> queryAllProject() {
        return projectDao.queryAllProject();
    }

    /*
    新增活动
     */
    public boolean addProject(Project project) {
        return projectDao.addProject(project);
    }
}
