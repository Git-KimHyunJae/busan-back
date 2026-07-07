package com.busansafe.safe.Controller;

import com.busansafe.safe.Dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class GetLocationController {
    @GetMapping("getLocation")
    //좌표를 받아서 반경 50m 내에 있는 좌표를 반환
    public String getLocation(LocationDto locationDto){
        System.out.println("controller >>>>>>>>>>>>>>>>>" + locationDto);
        return "api suesss>>>>>>>>>>>";
    }
}
