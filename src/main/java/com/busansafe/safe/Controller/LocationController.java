package com.busansafe.safe.Controller;

import com.busansafe.safe.Dto.LocationDto;
import com.busansafe.safe.Service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("test")
    public List<LocationDto> getLocation(){
        return locationService.getLocation();
    }

    @GetMapping("setLocation")
    public void setLocation() throws Exception{
        locationService.setLocation();
    }

}
