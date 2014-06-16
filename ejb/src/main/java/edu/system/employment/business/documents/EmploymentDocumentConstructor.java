package edu.system.employment.business.documents;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.Address;
import edu.system.employment.model.Employment;
import edu.system.employment.model.Student;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NamedQuery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Named

public class EmploymentDocumentConstructor implements DocumentStringConstants {
    private Workbook wb;
    private Sheet sheet;
    private PrintSetup printSetup;
    private Map<String, CellStyle> styles;

    @Inject
    BaseDaoBean baseDaoBean;

    public void generateReport() {

        FileOutputStream out = null;
        try {
            getPageSetup();
            createHead();
            createTableHeader();
            int currentRowNum = 8;
            //CreateContent
            List<Student> students = baseDaoBean.findWithNamedQuery("Student.getAll");
            currentRowNum = putData(students, currentRowNum);
            createFooter(currentRowNum);


            File file = new File(System.getProperty("user.dir") + File.separator + "report.xls");
            out = new FileOutputStream(file);
            wb.write(out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int putData(List<Student> students, int currentRowNum) {
        Row currentRow;
        Cell currentCell;
        int studNumber = 0;
        for (Student student : students) {
            currentRow = sheet.createRow(currentRowNum++);


            currentCell = currentRow.createCell(0);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            currentCell.setCellValue(++studNumber);

            currentCell = currentRow.createCell(1);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            currentCell.setCellValue("" + student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName());

            currentCell = currentRow.createCell(2);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(student.getBirthDate() == null ? new Date() : student.getBirthDate());
            currentCell.setCellValue(calendar.get(Calendar.YEAR) + 1900);

            currentCell = currentRow.createCell(3);
            currentCell.setCellStyle(styles.get("tableHorizontal"));

            Address address;
            if (student.getAddresses() != null && !student.getAddresses().isEmpty())
                address = student.getAddresses().get(0);
            else
                address = new Address();
            currentCell = currentRow.createCell(4);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            currentCell.setCellValue(address.toString());

            currentCell = currentRow.createCell(5);
            currentCell.setCellStyle(styles.get("tableHorizontal"));

            currentCell = currentRow.createCell(6);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            boolean employed = student.getEmployments().toArray().length > 0;
            currentCell.setCellValue(employed ? ((Employment) student.getEmployments().toArray()[0]).getCompany() : "");

            currentCell = currentRow.createCell(7);
            currentCell.setCellStyle(styles.get("tableHorizontal"));
            currentCell.setCellValue(employed ? ((Employment) student.getEmployments().toArray()[0]).getPosition() : "");

            for (int i = 8; i < 12; i++) {
                currentCell = currentRow.createCell(i);
                currentCell.setCellStyle(styles.get("tableHorizontal"));
            }
        }


        return currentRowNum;

    }

    private void createFooter(int currentRow) {
        Row footerRow = sheet.createRow(currentRow + 1);
        Cell footerCell = footerRow.createCell(1);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(deanString);

        footerCell = footerRow.createCell(3);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(bracesString);

        footerCell = footerRow.createCell(6);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(deptBossString);

        footerCell = footerRow.createCell(8);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(bracesString);

        footerRow = sheet.createRow(currentRow + 2);

        footerCell = footerRow.createCell(3);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(signatureString);

        footerCell = footerRow.createCell(8);
        footerCell.setCellStyle(styles.get("regular"));
        footerCell.setCellValue(signatureString);
    }

    private void createTableHeader() {
        Row tableRow = sheet.createRow(6);
        tableRow.setHeight((short) (7 * 256));
        Cell tableCell = tableRow.createCell(0);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(numberString);

        tableCell = tableRow.createCell(1);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(pibString);


        tableCell = tableRow.createCell(2);
        tableCell.setCellStyle(styles.get("tableVertical"));
        tableCell.setCellValue(birthYearString);

        tableCell = tableRow.createCell(3);
        tableCell.setCellStyle(styles.get("tableVertical"));
        tableCell.setCellValue(mariageString);

        tableCell = tableRow.createCell(4);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(addressString);

        tableCell = tableRow.createCell(5);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(proposeString);

        tableCell = tableRow.createCell(6);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(titleString);

        tableCell = tableRow.createCell(7);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(postString);

        tableCell = tableRow.createCell(8);
        tableCell.setCellStyle(styles.get("tableVertical"));
        tableCell.setCellValue(appartmentTypeString);

        tableCell = tableRow.createCell(9);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(agreedString);

        tableCell = tableRow.createCell(10);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(npravlennyaString);

        tableCell = tableRow.createCell(11);
        tableCell.setCellStyle(styles.get("tableHorizontal"));
        tableCell.setCellValue(arrivalString);

        tableRow = sheet.createRow(7);
        for (int i = 0; i < 12; i++) {
            Cell numberCell = tableRow.createCell(i);
            numberCell.setCellStyle(styles.get("tableHorizontal"));
            numberCell.setCellValue(i + 1);
        }
    }

    private void createHead() {
        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(25);
        Cell titleCell = titleRow.createCell(0);

        titleCell.setCellValue(mon);
        titleCell.setCellStyle(styles.get("title"));

        Row subtitleRow = sheet.createRow(1);
        Cell vidomist = subtitleRow.createCell(1);
        vidomist.setCellStyle(styles.get("title"));
        vidomist.setCellValue(vidomistString);

        vidomist = subtitleRow.createCell(9);
        vidomist.setCellStyle(styles.get("title"));
        vidomist.setCellValue(facultyString);


        Row oblikRow = sheet.createRow(2);
        Cell oblikCell = oblikRow.createCell(1);
        oblikCell.setCellStyle(styles.get("regular"));
        oblikCell.setCellValue(oblikString);

        oblikCell = oblikRow.createCell(6);
        oblikCell.setCellStyle(styles.get("regular"));
        oblikCell.setCellValue(univerUkrString);

        Row qualificationRow = sheet.createRow(3);
        Cell qualificationCell = qualificationRow.createCell(1);
        qualificationCell.setCellStyle(styles.get("regular"));
        qualificationCell.setCellValue(quallificationString);

        qualificationCell = qualificationRow.createCell(6);
        qualificationCell.setCellStyle(styles.get("regular"));
        qualificationCell.setCellValue(specialityCodeString);

        Row specialityRow = sheet.createRow(4);
        Cell specialityCell = specialityRow.createCell(1);
        specialityCell.setCellStyle(styles.get("regular"));
        specialityCell.setCellValue(specialityString);

        specialityCell = specialityRow.createCell(2);
        specialityCell.setCellStyle(styles.get("regular"));
        specialityCell.setCellValue(agreementString);
    }

    private void getPageSetup() throws IOException {
        wb = new HSSFWorkbook();
        styles = createStyles(wb);

        sheet = wb.createSheet("Відомість");
        printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$M$1"));
        for (int i = 2; i < 5; i++)
            sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + i + ":$F$" + i));
        sheet.setColumnWidth(1, 20 * 256);
        sheet.setColumnWidth(5, 15 * 256);
        sheet.setColumnWidth(6, 17 * 256);
        sheet.setColumnWidth(4, 40 * 256);
        sheet.setDefaultColumnWidth(13);

    }

    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontName("Times New Roman");
        titleFont.setFontHeightInPoints((short) 16);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font regularFont = wb.createFont();
        regularFont.setFontName("Times New Roman");
        regularFont.setFontHeightInPoints((short) 14);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(regularFont);
        styles.put("regular", style);

        Font tableFont = wb.createFont();
        tableFont.setFontName("Times New Roman");
        tableFont.setFontHeightInPoints((short) 12);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(tableFont);
        style.setBorderBottom((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);
        style.setWrapText(true);
        styles.put("tableHorizontal", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(tableFont);
        style.setBorderBottom((short) 1);
        style.setBorderTop((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);
        style.setRotation((short) 90);
        style.setWrapText(true);
        styles.put("tableVertical", style);

        return styles;
    }
}
