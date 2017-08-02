package com.wk.batAlgorithm.string;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/13.
 */
public class ReverseTest {

    @Test
    public void reverseSentenceTest(){
        String sentence = "I love you";
        Reverse reverse = new Reverse();
        String reversedSentence = reverse.reverseSentence(sentence,sentence.length());
        System.out.println(reversedSentence);
    }
}
