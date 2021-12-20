package persisitent.session;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import persisitent.session.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        File fileRef = new File("/Users/priyanka/student_marks.xlsx"); // define our file path here
        FileInputStream fileInputStream = new FileInputStream(fileRef); // created ref to read the data
        Workbook workbook = new XSSFWorkbook(fileInputStream); // if we want read .xlsx file we instantiate XSSWorkbook, for 1997-2003 excel file use  HSSFWorkBook
        Sheet datatypeSheet = workbook.getSheetAt(0); // sheet index numberstart from 0 to read first sheet in workbook
        Iterator<Row> iterator = datatypeSheet.iterator(); // iterator provides us funtionality to read data row by row
       // List<Student> studentList = new ArrayList<>();
        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
//            Cell rollNo = currentRow.getCell(0);
//            Cell name = currentRow.getCell(1);
//            Cell marks = currentRow.getCell(2);
//            Student student = new Student((int)rollNo.getNumericCellValue(),name.getStringCellValue(),marks.getNumericCellValue());
//            studentList.add(student);
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    System.out.print(currentCell.getStringCellValue() + "--");
                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    System.out.print(currentCell.getNumericCellValue() + "--");
                }

            }
            System.out.println();

        }

    }
}
