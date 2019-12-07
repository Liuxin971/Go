package com.sx.ybj.service.note.note;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface FeedbackImpl extends ElasticsearchRepository<com.sx.ybj.pojo.Feedback,Integer> {

    /**
     *   查询反馈
     * @param Content
     * @return
     */
    List<com.sx.ybj.pojo.Feedback> findByFeedbackContentLikeAndFeedbackAdminEquals(String Content,Integer admin);



}
