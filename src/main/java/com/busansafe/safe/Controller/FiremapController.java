package com.busansafe.safe.Controller;

import com.busansafe.safe.Service.FiremapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FiremapController {

    private final FiremapService firemapService;

    @GetMapping("firemap/insert")
    public String insertFiremap() {
        try {
            firemapService.insertFiremapFromExcel();
            return "insert 완료";
        } catch (Exception e) {
            e.printStackTrace();
            return "insert 실패: " + e.getMessage();
        }
    }
}
