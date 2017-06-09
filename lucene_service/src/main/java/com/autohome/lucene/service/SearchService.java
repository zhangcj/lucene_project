package com.autohome.lucene.service;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/11.
 */
public interface SearchService {
    public void query(String[] fileds,String value) throws IOException, ParseException;
}
