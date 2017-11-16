package com.bwie.sort.model;

import java.util.Map;

/**
 * Created by whl on 2017/11/14.
 */

public interface ISortModel {
    void getUrl(String url);
    void getRightUrl(String url, Map<String, String> mmap);
}
