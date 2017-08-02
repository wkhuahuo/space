package work.wk.mianshi.designmodel;

import java.io.ObjectStreamException;

/**
 * Created by wkhuahuo on 2017/3/4.
 */
public class MySingleton {

 private MySingleton(){}

     private static final MySingleton INSTANCE = new MySingleton();
     public static MySingleton getInstance() {
         return INSTANCE;
     }
     private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,   
        // return the class variable INSTANCE  
        return INSTANCE;
    }

}
