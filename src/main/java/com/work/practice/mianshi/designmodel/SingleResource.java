package work.wk.mianshi.designmodel;

/**
 * Created by wkhuahuo on 2017/3/5.
 */
public class SingleResource {
     private enum EnumSingleton{
        ICECREAME;
        private SingleResource singleResource;
        private  EnumSingleton(){
            System.out.println("enum EnumSingleton ");
            singleResource = new SingleResource();
        }
        //private和public都行
        private SingleResource getInstance(){
            return singleResource;
        }
     }
     private SingleResource(){

     }
     public static SingleResource getInstance(){
         return EnumSingleton.ICECREAME.getInstance();
     }

}
