package by.shestopalov.project.excel;

import by.shestopalov.project.classes.Part;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelApatch {
    private static final String XSLXFile="genFiles/parts.xlsx";

    public static void fillExcelTable(ArrayList<Part> parts) throws IOException {

        short rowIndex=0;
        FileOutputStream out=new FileOutputStream(new File(XSLXFile));
        XSSFWorkbook workBook=new XSSFWorkbook();
        XSSFSheet sheet=workBook.createSheet("parts");

        Font headerFont=workBook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short)14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle=workBook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        XSSFRow row=sheet.createRow(rowIndex);
        row.createCell(0).setCellStyle(headerCellStyle);
        row.getCell(0).setCellValue("Part id");
        row.createCell(1).setCellValue("Car id");
        row.createCell(2).setCellValue("Color");
        row.createCell(3).setCellValue("Category");
        row.createCell(4).setCellValue("Detail");
        row.createCell(5).setCellValue("Price");

        for(Part s:parts) {
            row = sheet.createRow(++rowIndex);
            row.createCell(0).setCellValue(s.getPartId());
            row.createCell(1).setCellValue(s.getCarId());
            row.createCell(2).setCellValue(s.getColor());
            row.createCell(3).setCellValue(s.getCategory());
            row.createCell(4).setCellValue(s.getDetail());
            row.createCell(5).setCellValue(s.getPrice());
        }
        workBook.write(out);
        out.close();
    }
}
