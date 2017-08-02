package work.wk.Java.JavaPOI;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by wangkai43 on 2017/7/7.
 */
public class ExcelDemo {
    public static void main(String[] args) {

        ArrayList<String> shiLong = new ArrayList<>();
        ArrayList<String> anLe = new ArrayList<>();
        String filePath ="/Users/wangkai43/Desktop/2017年4月门诊人次.xls";
        File file = new File(filePath);
        int count =0;
        POIFSFileSystem fs =null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            fs = new POIFSFileSystem(in);
            HSSFWorkbook  wb = new HSSFWorkbook(fs);

            HSSFSheet sheet = wb.getSheetAt(0);
            for(int i=1;i<sheet.getLastRowNum();i++) {
                HSSFRow row = sheet.getRow(i);
                HSSFCell zhenShi = row.getCell(19);
                String zhenShiName = zhenShi.getStringCellValue();

                HSSFCell jiuzhenNum = row.getCell(22);
                String strNum = jiuzhenNum.getStringCellValue();

                if("石龙卫生室".equals(zhenShiName) ) {
                    shiLong.add(strNum);
                    System.out.println(zhenShiName);
                    System.out.println(strNum);
                    count++;
                }
                if("安乐卫生室".equals(zhenShiName)){
                    anLe.add(strNum);
                    System.out.println(zhenShiName);
                    System.out.println(strNum);
                    count++;
                }
            }
            System.out.println("count "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fs!=null) {
                    fs.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        String modifypath ="/Users/wangkai43/Desktop/test.xls";
        setColor(modifypath,shiLong, (short) 20);//石龙
     //   setColor(modifypath,anLe, (short) 80);//安乐

    }

    public static void setColor( String filepath ,ArrayList<String> list,short num){


        File modifyFile = new File(filepath);

        POIFSFileSystem mfs = null;
        FileInputStream in =null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(filepath);
            HSSFWorkbook wb = new HSSFWorkbook(in);
            wb.createSheet("sheettest");
            HSSFSheet sheet = wb.getSheet("sheettest");
            HSSFRow row =  sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("hello");

            HSSFCellStyle cellStyle =  wb.createCellStyle();
            cellStyle.setFillBackgroundColor((short)125);
            cellStyle.setBorderBottom(BorderStyle.DASH_DOT);
            cell.setCellStyle(cellStyle);

            out = new FileOutputStream(filepath);
            wb.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(in!=null) {
                        in.close();
                    }
                    if(out!=null){
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        /*HSSFWorkbook  outwb = null;
        try {
            outwb = new HSSFWorkbook(mfs);
            CellStyle cStyle = outwb.createCellStyle();
            HSSFSheet sheet = outwb.getSheetAt(0);
         //   for(int i=1;i<sheet.getLastRowNum();i++){
         //       HSSFRow row = sheet.getRow(2);
            HSSFRow row = sheet.createRow(2);
           //     HSSFCell cell = row.getCell(12);
            *//* if(list.contains(cell.getStringCellValue())) {
                 for (int j = 0; j < row.getLastCellNum(); j++) {

                     cStyle.setFillBackgroundColor(HSSFColor.LIME.index);
                     cStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
               //      cell.setCellStyle(cStyle);
                 }

             }*//*
                HSSFCell cdemo = row.createCell(13);
                cStyle.setFillBackgroundColor(HSSFColor.LIME.index);
                cStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cdemo.setCellStyle(cStyle);
                cdemo.setCellValue("wkwk");

     //       }
//            System.out.println(sheet.getRow(0).getCell(12).getStringCellValue());
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filepath);
                outwb.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outwb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outwb != null) {
                try {
                    outwb.close();
                    mfs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

}
