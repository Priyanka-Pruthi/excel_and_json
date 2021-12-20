package persisitent.session;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import persisitent.session.model.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class WritingDataInExcel {
    public static void main(String[] args) {

        //1. initialised blank excel sheet reference
        XSSFWorkbook workbook = new XSSFWorkbook();

        //2. create blank sheet inside workbook
        XSSFSheet sheet = workbook.createSheet("student");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Roll_Number");
        header.createCell(1).setCellValue("Student_Name");
        header.createCell(2).setCellValue("Marks");

        //3 write student data referred as students map in sheet
        Map<Integer,Object[]> students = getStudentMap(loadStaticData());
        Set<Integer> keys = students.keySet();
        int rowNo = 1;
        for (Integer key : keys) {
            //4 create a new row to write data in sheet
            Row row = sheet.createRow(rowNo++);
            Object[] objData = students.get(key);
            //5. create cells for row
            int cellNo = 0;
            for (Object obj : objData) {
                Cell cell = row.createCell(cellNo++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }

        }

        try
        {
            File fileRef = new File("/Users/priyanka/student_marks.xlsx");
            if(!fileRef.exists())
                fileRef.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(fileRef);
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Excel file with data generated successfully");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static Set<Student> loadStaticData()
    {
        Set<Student> students = new HashSet<>();
        students.add(new Student(1,"Sreenith",90));
        students.add(new Student(2,"Sreejith",89));
        students.add(new Student(3,"Sreenath",80));
        students.add(new Student(4,"Sree",90));
        return  students;
    }

    public static Map<Integer,Object[]> getStudentMap(Set<Student> data)
    {
        Map<Integer,Object[]> studentMap = new HashMap<>();
        if(Objects.nonNull(data))
        {
            data.forEach(obj->{
                studentMap.put(obj.getRollNo(),new Object[]{obj.getRollNo(),obj.getName(),obj.getMarks()});
            });
        }

        return studentMap;
    }
}
