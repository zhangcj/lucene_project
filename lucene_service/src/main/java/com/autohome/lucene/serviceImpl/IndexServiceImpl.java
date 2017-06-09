package com.autohome.lucene.serviceImpl;

import com.autohome.lucene.service.IndexService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/11.
 */
@Service
public class IndexServiceImpl implements IndexService {
    /*
    创建索引
     */
    public void createIndex(HashMap hashMap,String path) throws IOException {
        Analyzer a = new StandardAnalyzer(Version.LUCENE_40);
        Directory dir = FSDirectory.open(new File(path));
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40,a);
        IndexWriter iw = new IndexWriter(dir, iwc);

        Iterator iters = hashMap.entrySet().iterator();
        while (iters.hasNext()) {
            Map.Entry entry = (Map.Entry) iters.next();
            Object key = entry.getKey();
            Object val = entry.getValue();

            Document doc = new Document();
            doc.add(new TextField(key.toString(), val.toString(), Field.Store.YES));
            iw.addDocument(doc);
        }
        iw.close();
        dir.close();
    }
}
