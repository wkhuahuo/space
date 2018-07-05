package com.work.practice.hiveDataAnalise;

import java.io.File;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2018-01-19-21:58
 * @email wangkai43@meituan.com
 */
public class Main {
    public static void main(String[] args) {
        SplitFile splitFile = new SplitFile();
        String inputfile = "/Users/wangkai43/Desktop/zjdata/cz_new_cardtype.txt";
        String outputfile = "/Users/wangkai43/Desktop/zjdata/out.txt";


//        File file = new File(inputfile);
//        Map<String,Integer> datas = splitFile.countNum(splitFile.analysiseRevokeFromFile(file));
//        splitFile.outPutFile(outputfile,datas);

        String errfilepath = "/Users/wangkai43/Desktop/zjdata/other_error.txt";
        String erroutfile = "/Users/wangkai43/Desktop/zjdata/out_error.txt";

        File errfile = new File(errfilepath);
        Map<String,Integer> errdatas = splitFile.countEorrSum(splitFile.analysiseErrorFromFile(errfile));
        splitFile.outPutFile(erroutfile,errdatas);

    }
}
