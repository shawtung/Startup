/*
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.*;

public class ExcelTest{
    public static void main(String[] args){
        File file = new File("D:/a.xls");
        try {
            WritableWorkbook wwb = Workbook.createWorkbook(file);
            WritableSheet sheet = wwb.createSheet("爱投不投", 0);
            Label label = new Label(0,0,"呵呵");
            sheet.addCell(label);
            wwb.write();
            wwb.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}*/
