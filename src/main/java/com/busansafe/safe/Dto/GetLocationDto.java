package com.busansafe.safe.Dto;

import lombok.Data;

@Data
public class GetLocationDto {
    double latitude;
    double longitude;
    String address;
}
