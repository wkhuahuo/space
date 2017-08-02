package work.wk.mianshi.designmodel;

/**
 * Created by wkhuahuo on 2017/3/4.
 */
public class Singleton_enmTest {
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            Singleton_enm enm = Singleton_enm.INDTANCE;
            Singleton_enm enm2 = Singleton_enm.INDTANCE2;
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            MyResource instance_enm =enm.getInstance();
            MyResource2 instance2_enm =enm.getInstance2();
            System.out.println("instance_enm hasCode: "+instance_enm.hashCode());
            System.out.println("instance_enm2 hasCode: "+instance2_enm.hashCode());
            System.out.println("--------------------------------------------------------");

            MyResource enm2_ins = enm2.getInstance();
            MyResource2 enm2_ins2 = enm2.getInstance2();
            System.out.println("enm2_ins hasCode: "+enm2_ins.hashCode());
            System.out.println("enm2_ins2 hasCode: "+enm2_ins2.hashCode());
            System.out.println("=====================================================");
        }
    }
}
