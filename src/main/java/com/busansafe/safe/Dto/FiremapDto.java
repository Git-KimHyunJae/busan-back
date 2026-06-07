package com.busansafe.safe.Dto;

import lombok.Data;

@Data
public class FiremapDto {
    private String city_hq;    // 시도본부
    private String station_nm; // 소방서명
    private String center_nm;  // 119안전센터명
    private String address;    // 주소
    private String tel;        // 전화번호
    private double latitude;   // 위도
    private double longitude;  // 경도
}
