package com.autohome.lucene.console.search;

import com.autohome.lucene.service.SearchService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SearchApp {
    public static void main(String[] args) throws IOException, ParseException {
        //通过ApplicationContext接口的实现类实例化Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        System.out.println("----server start----");
        SearchService searchService = (SearchService) context.getBean("searchService");
        String value = "我的";
        String[] fileds = {"content", "name"};
        searchService.query(fileds, value);

        System.out.println("----server end----");
    }
}
