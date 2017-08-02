package com.algorithm.batAlgorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/14.
 */
public class DistinctSubstringTest {
    @Test
    public void longestSubstringTest(){
        String str = "kojypxtmcheuvhpkqapldlkxkdbbouclkqwpnivxquwimbexyuqlipqpnlaklsqjnhcqspegqswpwinmvaokwbzylyrctfiscjuweakmmiaqsuanrfxhaffeuaauafqkeksjxgdpspkzzzsawuyvrdbgdqhrnkspldkkqfmlsofadojwfdikwpzsafacxoktpxkzmzzihljiqlsnbygkstydeflbgjrzrtxryfcntduaadqyzxmsrrxqbgldcvmtmqwyqgjtda";
        DistinctSubstring dis = new DistinctSubstring();
        int num = dis.longestSubstring(str, str.length());
        Assert.assertEquals(13,num);
    }
}
