package com.busansafe.safe.Dao;

import com.busansafe.safe.Dto.GetLocationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetLocationDao {
    List<GetLocationDto> GetLocation(GetLocationDto locationDto);
}
