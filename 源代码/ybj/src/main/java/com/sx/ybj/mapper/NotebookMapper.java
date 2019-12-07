package com.sx.ybj.mapper;

import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.NotebookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotebookMapper {
    int countByExample(NotebookExample example);

    int deleteByExample(NotebookExample example);

    int deleteByPrimaryKey(Integer notebookId);

    int insert(Notebook record);

    int insertSelective(Notebook record);

    List<Notebook> selectByExample(NotebookExample example);

    Notebook selectByPrimaryKey(Integer notebookId);

    int updateByExampleSelective(@Param("record") Notebook record, @Param("example") NotebookExample example);

    int updateByExample(@Param("record") Notebook record, @Param("example") NotebookExample example);

    int updateByPrimaryKeySelective(Notebook record);

    int updateByPrimaryKey(Notebook record);
}