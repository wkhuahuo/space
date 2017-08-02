package work.wk.Java.JavaPOI;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.*;

/**
 * Created by wangkai43 on 2017/7/8.
 */
public class CreateExcel {
    public static void main(String[] args) {
        String path = "/Users/wangkai43/Desktop/test.xls";
        createfile(path);
    }

    public static void createfile(String path){

        InputStream in =null;
        OutputStream out = null;
     //   POIFSFileSystem fs =null; fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(path);

            wb = new HSSFWorkbook(in);
            HSSFSheet sheet = wb.createSheet();
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(16);
            cell.setCellValue("1234");
            CellStyle cs =  wb.createCellStyle();
            cs.setBorderBottom(BorderStyle.DOUBLE);
            cs.setFillPattern(FillPatternType.BRICKS);
            cs.setFillForegroundColor((short) 222);

            out = new FileOutputStream(path);
            wb.write(out);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(wb !=null){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
