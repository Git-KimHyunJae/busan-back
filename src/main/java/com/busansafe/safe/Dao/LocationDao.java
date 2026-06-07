package com.busansafe.safe.Dao;

import com.busansafe.safe.Dto.LocationDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LocationDao {
     List<LocationDto> getLocation();
}
