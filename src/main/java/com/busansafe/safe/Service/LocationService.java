package com.busansafe.safe.Service;

import com.busansafe.safe.Dao.LocationDao;
import com.busansafe.safe.Dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationDao locationDao;

    public List<LocationDto> getLocation(){
        List<LocationDto> testDto = locationDao.getLocation();
        System.out.println("이건 실행 안되냐@@@@@@@@@@@@@@@@@ " + testDto);
        return locationDao.getLocation();
    }

    public void setLocation() throws Exception {
        String path = "C:\\Users\\user\\Desktop\\소방서좌표.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        List<String[]> list = new ArrayList<>();

        for (Row row : sheet) {
            String[] rowArr = new String[row.getLastCellNum()]; // 행의 셀 개수만큼 배열 생성
            for (Cell cell : row) {
                rowArr[cell.getColumnIndex()] = switch (cell.getCellType()) {
                    case STRING  -> cell.getStringCellValue();
                    case NUMERIC -> String.valueOf(cell.getNumericCellValue());
                    case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                    default      -> "";
                };
            }
            list.add(rowArr); // 행 배열을 List에 추가
        }

        workbook.close();
        fis.close();
        //return list;
    }
}
