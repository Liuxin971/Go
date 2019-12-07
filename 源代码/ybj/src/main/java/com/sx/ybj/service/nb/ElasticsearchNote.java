package com.sx.ybj.service.nb;

import com.sx.ybj.pojo.Categorize;
import com.sx.ybj.pojo.Notebook;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ybj
 * @description: Elasticsearch
 * @author: lwx
 * @create: 2019-05-21 23:39
 */
public interface ElasticsearchNote extends ElasticsearchRepository<Notebook,Integer> {


    /**
     * 返回共享笔记查询结果
     * @param content
     * @param id
     * @return
     */
    List<Notebook> findByNotebookContentLikeAndNotebookSharingEqualsAndNotebookStateEquals(String content,int id,int state);


}