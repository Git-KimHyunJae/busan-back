package com.busansafe.safe.Controller;

import com.busansafe.safe.Dto.GetLocationDto;
import com.busansafe.safe.Dto.LocationDto;
import com.busansafe.safe.Service.GetLocationService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class GetLocationController {
    private final GetLocationService getLocationService;


    @GetMapping("getLocation")
    //좌표를 받아서 반경 50m 내에 있는 좌표를 반환
    public ResponseEntity<List<GetLocationDto>> getLocation(GetLocationDto locationDto){
        List<GetLocationDto> result = getLocationService.GetLocation(locationDto);
        System.out.println("controller >>>> resultresult" + result);
        return ResponseEntity.ok(result);
    }
}
