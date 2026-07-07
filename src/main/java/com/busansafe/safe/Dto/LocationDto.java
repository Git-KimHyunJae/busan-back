package com.busansafe.safe.Dto;


import lombok.Data;

@Data
public class LocationDto {
    String address; //주소
    double latitude;//위도
    double longitude;//경도
}
