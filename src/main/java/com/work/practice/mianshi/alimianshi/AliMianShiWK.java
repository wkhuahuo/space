package com.work.practice.mianshi.alimianshi;

/**
 * Created by wkhuahuo on 2017/3/3.
 */
public class AliMianShiWK {
    public static void main(String[] args){

           //int[] arr = {2,5,1,1,1,1,4,1,7,3,7};
           int[] arr = {1,1,2,1,1,4,1,1,4,1,1};
     //   int[] arr = {1,1,1};
        int left =0;
        int right =arr.length-1;


        int[][] couples = test(arr,left,right);
        boolean bol =judge ( couples,arr);
        System.out.println("==_==: "+ bol);

    }



    public static boolean  judge (int[][] couples,int[]arr){
        for(int i=0;i<couples.length;i++){

            if(couples[i][3]!=-1) {
                findMid(couples[i], arr);
            }
        }
        for(int i=0;i<couples.length;i++){
            if(couples[i][4] == 1){
                return true;
            }
        }
        return false;
    }

    public static void findMid(int[] couple,int[] arr){
        int left = couple[0]+1;
        int right = couple[1]-1;
        //int mid= left;
        int leftsum=arr[left];
        int rightsum =arr[right];

        left++;
        right--;
        while(left<=right){
            if(leftsum ==rightsum && left ==right){
                couple[4] = 1;
                break;
            }else if(leftsum<rightsum){
                left+=1;
                leftsum += arr[left-1];
            }else if(leftsum>rightsum){
                right-=1;
                rightsum += arr[right+1];
            }else if(leftsum == rightsum && left !=right){
                left++;
                right--;
                leftsum +=arr[left-1];
                rightsum +=arr[right+1];
            }
        }
    }

    public static int[][] test(int[] arr, int left, int right){
        int[][] couples =new int[arr.length][5];
        for(int i=0;i<couples.length;i++){
            for(int j=0;j<couples[0].length;j++){
                couples[i][j] = -1;
            }
        }

        System.out.println("====couples.length= "+couples.length);
        int leftsum = arr[left];
        int rightsum =arr[right];
        left++;
        right--;
        int index = 0;
        while(left<=right && index<couples.length){
            if(leftsum == rightsum){

                couples[index][0] = left;
                couples[index][1] = right;
                couples[index][3] = leftsum;

                left++;
                right--;
                index++;
                leftsum +=arr[left-1];
                rightsum +=arr[right+1];
            }else if(leftsum<rightsum){
                ++left;
                leftsum +=arr[left-1];

            }else if(leftsum>rightsum){
                --right;
                rightsum +=arr[right+1];
            }

        }
        return couples;
    }

}
