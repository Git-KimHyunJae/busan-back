package com.busansafe.safe.Dao;

import com.busansafe.safe.Dto.FiremapDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FiremapDao {
    void insertFiremap(FiremapDto firemapDto);
}
