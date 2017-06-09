package com.autohome.lucene.console.index;

import com.autohome.lucene.conf.LuceneConf;
import com.autohome.lucene.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/13.
 */
public class IndexApp {
    public static void main( String[] args ) throws IOException {
        //通过ApplicationContext接口的实现类实例化Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("----server start----");

        IndexService indexService = (IndexService) context.getBean("indexService");
        HashMap map = new HashMap();
        map.put("name", "zhangchunju");
        map.put("info", "this is my first project");
        map.put("content", "这个是我的第一个Lucene程序");
        map.put("message", "hello world");
        indexService.createIndex(map, LuceneConf.INDEXPATH);
        System.out.println("--Index creat succeed!--");

        System.out.println("----server end----");
    }
}
