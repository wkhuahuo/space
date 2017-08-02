package com.algorithm.batAlgorithm.string;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/13.
 */
public class TranslationTest {
    @Test
    public void stringTranslationTest(){
        String str = "ABCDEFG";

        Translation translation = new Translation();
        String translatedStr = translation.stringTranslation(str,str.length(),3);
        System.out.println(translatedStr);
    }
}
