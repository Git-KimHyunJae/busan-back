package com.busansafe.safe.Service;

import com.busansafe.safe.Dao.GetLocationDao;
import com.busansafe.safe.Dto.GetLocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLocationService {

    private final GetLocationDao getLocationDao;

    public List<GetLocationDto> GetLocation(GetLocationDto locationDto){
        return getLocationDao.GetLocation(locationDto);
    }


}
