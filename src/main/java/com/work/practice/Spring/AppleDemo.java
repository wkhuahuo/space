package work.wk.Spring;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class AppleDemo {
    private String name;
    private String price;
    AppleDemo(){
        name = "default";
        price = "0";
    }
    AppleDemo(String name,String price){
        this.name = name;
        this.price = price;
    }
    public void speak(){
        System.out.println("My name is "+name+" value of "+price);
    }
    private void eat(String str){
        System.out.println(str+" eat me!");
    }
}
