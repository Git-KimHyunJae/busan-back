package com.busansafe.safe.Service;

import com.busansafe.safe.Dao.FiremapDao;
import com.busansafe.safe.Dto.FiremapDto;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FiremapService {

    private final FiremapDao firemapDao;

    public void insertFiremapFromExcel() throws Exception {
        String path = "C:\\Users\\user\\Desktop\\소방서좌표.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<FiremapDto> list = new ArrayList<>();

        for (Row row : sheet) {
            // 1행(헤더) 건너뛰기
            if (row.getRowNum() == 0){
                continue;
            }

            FiremapDto dto = new FiremapDto();
            dto.setCity_hq(getCellValue(row.getCell(1)));    // 시도본부
            dto.setStation_nm(getCellValue(row.getCell(2))); // 소방서명
            dto.setCenter_nm(getCellValue(row.getCell(3)));  // 119안전센터명
            dto.setAddress(getCellValue(row.getCell(4)));    // 주소
            dto.setTel(getCellValue(row.getCell(5)));        // 전화번호
            // 6번 팩스번호 건너뜀
            dto.setLatitude(Double.parseDouble(getCellValue(row.getCell(7))));  // 위도
            dto.setLongitude(Double.parseDouble(getCellValue(row.getCell(8)))); // 경도

            list.add(dto);
        }

        workbook.close();
        fis.close();

        // DB insert
        for (FiremapDto dto : list) {
            firemapDao.insertFiremap(dto);
        }

        System.out.println("총 " + list.size() + "건 insert 완료");
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING  -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default      -> "";
        };
    }
}
