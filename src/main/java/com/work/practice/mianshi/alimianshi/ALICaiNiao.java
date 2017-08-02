package work.wk.mianshi.alimianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Created by wangkai43 on 2017/7/9.
 */


public class ALICaiNiao {
        public static void main(String[] args) {

            ArrayList<Integer> _ids = new ArrayList<Integer>();
            ArrayList<Integer> _parents = new ArrayList<Integer>();
            ArrayList<Integer> _costs = new ArrayList<Integer>();

            Scanner in = new Scanner(System.in);
            String line = in.nextLine();

            while(line != null && !line.isEmpty()) {
                if(line.trim().equals("0")) break;
                String []values = line.trim().split(" ");
                if(values.length != 3) {
                    break;
                }
                _ids.add(Integer.parseInt(values[0]));
                _parents.add(Integer.parseInt(values[1]));
                _costs.add(Integer.parseInt(values[2]));
                line = in.nextLine();
            }
            int res = resolve(_ids, _parents, _costs);

            System.out.println(String.valueOf(res));
        }

        // write your code here
        public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
            ArrayList<Integer> childs = new ArrayList<>();
            for(Integer id : ids ){
                if(!parents.contains(id)){
                    childs.add(id);
                }
            }
            HashMap<Integer,Integer> childM = new HashMap<>();
            int max=0;
            for(Integer id : childs){
                int tmpid = id;
                while(tmpid != 0){
                    if(childM.containsKey(id)){
                        childM.put(id,childM.get(id)+costs.get(id-1));
                        if(childM.get(id)>max){
                            max = childM.get(id);
                        }
                    }else{
                        childM.put(id,costs.get(id-1));
                        if(childM.get(id)>max){
                            max = childM.get(id);
                        }
                    }
                    tmpid = parents.get(tmpid-1);
                }
            }
            return max;
        }
    }

