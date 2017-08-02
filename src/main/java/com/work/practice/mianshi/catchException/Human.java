package com.work.practice.mianshi.catchException;

/**
 * Created by wkhuahuo on 19/02/17.
 */
public class Human {
    public static void main(String[] args) throws Exception{
        try{
            try{
                throw new Sneeze();
            }catch (Annoyance a){
                System.out.println("Caught Annoyance");
            }
        //    throw new Sneeze();
        //}catch (Sneeze s) {
        }catch (Exception e){
            System.out.println("Caught Sneeze");
            return;
        }finally {
            System.out.println("Hello world");
        }
    }
}
