package com.work.practice.mianshi.designmodel;

/**
 * Created by wkhuahuo on 2017/3/5.
 */
public class SingleResourceTest {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            //SingleResource singleResource = new SingleResource();
            SingleResource singleResource = SingleResource.getInstance();
            System.out.println("enum "+i+": "+singleResource.hashCode());
        }
    }
}
