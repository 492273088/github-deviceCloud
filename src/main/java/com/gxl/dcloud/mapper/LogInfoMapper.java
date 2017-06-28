package com.gxl.dcloud.mapper;

import com.gxl.dcloud.pojo.LogEnty;

public interface LogInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(LogEnty record);

    int insertSelective(LogEnty record);

    LogEnty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogEnty record);

    int updateByPrimaryKey(LogEnty record);
}