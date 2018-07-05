package com.work.practice.hiveDataAnalise;

import java.io.*;
import java.util.*;

/**
 * @author wangkai43
 * @create 2018-01-19-21:30
 * @email wangkai43@meituan.com
 */
public class SplitFile {

    public ArrayList<ErrorLine> analysiseErrorFromFile(File file){
        FileReader fileReader = null;
        BufferedReader bfReader = null;
        try {

            fileReader = new FileReader(file);
            bfReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(bfReader == null){
            return null;
        }
        Map<String,Integer> result = new HashMap<>();
        ArrayList<ErrorLine> errorLines= new ArrayList<>();
        String tmpLine =null;
        try {
            int count=0;
            while((tmpLine = bfReader.readLine())!= null) {
                String[] pam = tmpLine.split("\\|");
                ErrorLine errl = new ErrorLine();
                errl.setErrorMsg(pam[0].trim());
                errl.setBankName(pam[1].trim());
                errl.setCardNo(pam[2].trim());
                errl.setNums(Integer.valueOf(pam[3].trim()));
                errl.setType(pam[4].trim());
                errorLines.add(errl);
                count++;
               /* if("中国银行".equals(line.getBankName())){
                    System.out.println(pam[0]+" "+pam[1]+" "+pam[2]+" "+pam[3]);
                    System.out.println(count +" "+line.getBankName()+" "+line.getType());
                }*/

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return errorLines;
    }





    public ArrayList<Line> analysiseRevokeFromFile(File file){

        FileReader fileReader = null;
        BufferedReader bfReader = null;
        try {

             fileReader = new FileReader(file);
             bfReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(bfReader == null){
            return null;
        }
        Map<String,Integer> result = new HashMap<>();
        ArrayList<Line> linearr= new ArrayList<>();
        String tmpLine =null;
        try {
            int count=0;
            while((tmpLine = bfReader.readLine())!= null) {
                String[] pam = tmpLine.split("\\|");
                Line line = new Line();
                line.setBankName(pam[0].trim());
                line.setCardNo(pam[1].trim());
                line.setNums(Integer.valueOf(pam[2].trim()));
                line.setType(pam[3].trim());
                linearr.add(line);
                count++;
               /* if("中国银行".equals(line.getBankName())){
                    System.out.println(pam[0]+" "+pam[1]+" "+pam[2]+" "+pam[3]);
                    System.out.println(count +" "+line.getBankName()+" "+line.getType());
                }*/

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linearr;
    }


    public Map<String,Integer> countNum(ArrayList<Line> linearr){
        Map<String,Integer> result = new HashMap<>();

        for(Line line: linearr){
            String key = line.getBankName()+"|"+line.getType();

          //  System.out.println(count+++" " + key);

            Integer value = line.getNums();
            if(result.containsKey(key)){
                value = result.get(key)+value;
            }

            result.put(key,value);
        }
        return result;
    }
    public Map<String,Integer> countEorrSum(ArrayList<ErrorLine> linearr){

        Map<String,Integer> result = new HashMap<>();

        for(ErrorLine line: linearr){
            String key = line.getBankName()+"|"+line.getType()+"|"+line.getErrorMsg();

            Integer value = line.getNums();
            if(result.containsKey(key)){
                value = result.get(key)+value;
            }

            result.put(key,value);
        }
        return result;
    }

    public void outPutFile(String filePath, Map<String,Integer> data){
        File file =new File(filePath);
        if(file.isDirectory()){
            System.out.println("是个文件夹");
        }
        if(file.isFile() && file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw =null;
        BufferedWriter bfw =null;

        try {
            fw = new FileWriter(file);
            bfw = new BufferedWriter(fw);
            Set<String> setstr = data.keySet();
            Iterator<String> iterator = setstr.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
           //     System.out.println(key);

                Integer value = data.get(key);
                bfw.write(key+"|"+value+"\n");
            }

          /*  for(String tmpstr : setstr){
                Integer sum = data.get(tmpstr);
                bfw.write(tmpstr+"|"+sum+"\n");
             //   System.out.println(tmpstr+" "+sum);
            }*/
            bfw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
            if(fw != null){
                    fw.close();
                }
                if(bfw != null){
                    bfw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
