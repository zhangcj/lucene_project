package com.autohome.lucene.service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/11.
 */
public interface IndexService {
    public void createIndex(HashMap hashMap,String path) throws IOException;
}
