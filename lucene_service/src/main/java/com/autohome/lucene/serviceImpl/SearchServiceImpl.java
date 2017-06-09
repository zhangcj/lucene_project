package com.autohome.lucene.serviceImpl;

import com.autohome.lucene.conf.LuceneConf;
import com.autohome.lucene.service.SearchService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/11.
 */
@Service
public class SearchServiceImpl implements SearchService {
    /*
    查询
     */
    public void query(String[] fileds, String value) throws IOException, ParseException {
        Analyzer a = new StandardAnalyzer(Version.LUCENE_40);
        Directory dir = FSDirectory.open(new File(LuceneConf.INDEXPATH));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(reader);

        BooleanQuery booleanQuery = new BooleanQuery();
        for (int i = 0; i < fileds.length; i++) {
            QueryParser parser = new QueryParser(Version.LUCENE_40, fileds[i], a);
            Query query = parser.parse(value);
            /*
                Occur.SHOULD，或的意思
                Occur.MUST_NOT，非的意思
                Occur.MUST， 与的意思
             */
            booleanQuery.add(query, BooleanClause.Occur.SHOULD);
        }

        TopDocs topDocs = is.search(booleanQuery, LuceneConf.TOPDOCCOUNT);
        System.out.println("总共匹配多少个：" + topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;

        // 应该与topDocs.totalHits相同
        System.out.println("多少条数据：" + hits.length);
        for (ScoreDoc scoreDoc : hits) {
            System.out.println("匹配得分：" + scoreDoc.score);
            System.out.println("文档索引ID：" + scoreDoc.doc);
            Document document = is.doc(scoreDoc.doc);
            System.out.println("name:"+document.get("name"));
            System.out.println("age:"+document.get("age"));
            System.out.println("content:"+document.get("content"));
            System.out.println("info:"+document.get("info"));
        }

        reader.close();
        dir.close();
    }
}
