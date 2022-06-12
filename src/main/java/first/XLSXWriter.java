package first;

import lombok.SneakyThrows;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class XLSXWriter {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet spreadsheet
            = workbook.createSheet("Public's");
    XSSFRow row;


    @SneakyThrows
    public void writeXLSX(List<Table> list) {
        CreationHelper helper
                = workbook.getCreationHelper();
        XSSFCellStyle linkStyle
                = workbook.createCellStyle();
        XSSFFont linkFont = workbook.createFont();
        linkFont.setUnderline(XSSFFont.U_SINGLE);
        linkFont.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        linkStyle.setFont(linkFont);
        int id = 0;
        row = spreadsheet.createRow(id++);
        Cell cell = row.createCell(0);
        cell.setCellValue("№");
        cell = row.createCell(1);
        cell.setCellValue("name");
        cell = row.createCell(2);
        cell.setCellValue("category");
        cell = row.createCell(3);
        cell.setCellValue("numberOfSubscribers");
        cell = row.createCell(4);
        cell.setCellValue("description");
        cell = row.createCell(5);
        cell.setCellValue("hiddenFromTheNews");

        for (Table table : list) {
            row = spreadsheet.createRow(id++);
            cell = row.createCell(0);
            cell.setCellValue(list.indexOf(table));
            cell = row.createCell(1);
            cell.setCellValue(table.getName());
            XSSFHyperlink link
                    = (XSSFHyperlink) helper.createHyperlink(
                    HyperlinkType.URL);

            link.setAddress(table.getLink());
            cell.setHyperlink(link);
            cell.setCellStyle(linkStyle);

            cell = row.createCell(2);
            cell.setCellValue(table.getCategory());
            cell = row.createCell(3);
            cell.setCellValue(table.getNumberOfSubscribers());
            cell = row.createCell(4);
            cell.setCellValue(table.getDescription());
            cell = row.createCell(5);
            cell.setCellValue(table.getHiddenFromTheNews());
        }

        FileOutputStream out = new FileOutputStream(
                new File("src/main/resources/result.xlsx"));

        workbook.write(out);
        out.close();
    }
}

