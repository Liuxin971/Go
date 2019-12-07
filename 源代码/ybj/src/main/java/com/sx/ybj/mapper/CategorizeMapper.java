package com.sx.ybj.mapper;

import com.sx.ybj.pojo.Categorize;
import com.sx.ybj.pojo.CategorizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategorizeMapper {
    int countByExample(CategorizeExample example);

    int deleteByExample(CategorizeExample example);

    int deleteByPrimaryKey(Integer categorizeId);

    int insert(Categorize record);

    int insertSelective(Categorize record);

    List<Categorize> selectByExample(CategorizeExample example);

    Categorize selectByPrimaryKey(Integer categorizeId);

    int updateByExampleSelective(@Param("record") Categorize record, @Param("example") CategorizeExample example);

    int updateByExample(@Param("record") Categorize record, @Param("example") CategorizeExample example);

    int updateByPrimaryKeySelective(Categorize record);

    int updateByPrimaryKey(Categorize record);
}