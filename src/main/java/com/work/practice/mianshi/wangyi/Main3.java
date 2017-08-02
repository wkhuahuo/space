package work.wk.mianshi.wangyi;
import java.util.Scanner;
/**
 * Created by wkhuahuo on 2017/3/25.
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String carsString = sc.nextLine();
        String[] eachcarXStr = sc.nextLine().split(" ");//carx
        String[] eachcarYStr = sc.nextLine().split(" ");//cary
        String[] workplace = sc.nextLine().split(" ");//工作地点
        String[] times = sc.nextLine().split(" "); //走路时间

        int carsNum = Integer.parseInt(carsString);//
        int wpx = Integer.parseInt(workplace[0]);
        int wpy = Integer.parseInt(workplace[1]);

        int walkTime = Integer.parseInt(times[0]);
        int taxiTime = Integer.parseInt(times[1]);

        int[] taxiX = new int[carsNum];//出租X
        int[] taxiY = new int[carsNum];//出租Y

        for(int i=0;i<carsNum;i++){
            taxiX[i] = Integer.parseInt( eachcarXStr[i] );
            taxiY[i] = Integer.parseInt( eachcarYStr[i] );
        }


        int minTime = (Math.abs(wpx)+Math.abs(wpy))*walkTime;

        for(int i=0;i<carsNum;i++){

            int walkT = (Math.abs(taxiX[i])+Math.abs(taxiY[i]))*walkTime;

            int taixT = (Math.abs(wpx-taxiX[i])+Math.abs(wpy-taxiY[i]))*taxiTime;
            if(walkT+taixT<minTime) {
                minTime = walkT + taixT;
            }
        }
        System.out.println(minTime);
    }
}
