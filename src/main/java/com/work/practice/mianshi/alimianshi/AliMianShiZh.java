package com.work.practice.mianshi.alimianshi;

/**
 * Created by wkhuahuo on 2017/3/3.
 */
public class AliMianShiZh {
    public static void main(String[] args){

     //   int[] arr = {2,5,1,1,1,1,4,1,7,3,7};
        int[] arr = {1,1,2,1,1,4,1,1,4,1,1};
        int left =0;
        int right =arr.length-1;

        Couple[] couples = test(arr,left,right);
        boolean bol =judge ( couples,arr);
        System.out.println("==_==: "+ bol);

    }
    public static boolean  judge (Couple[] couples,int[]arr){
        for(Couple couple:couples){

            if(couple!=null && couple.sum!=-1) {
                findMid(couple, arr);
            }
        }
        for(Couple couple: couples){
            if(couple.bool){
                return true;
            }
        }
        return false;
    }

    public static void findMid(Couple couple,int[] arr){
        int left = couple.left+1;
        int right = couple.right-1;
        //int mid= left;
        int leftsum=arr[left];
        int rightsum =arr[right];

        left++;
        right--;
        while(left<=right){
            if(leftsum ==rightsum && left ==right){
                couple.bool = true;
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


    public static Couple[] test(int[] arr, int left, int right){
        Couple[] couples =new Couple[arr.length];

        System.out.println("=============="+couples.length);
        int leftsum = arr[left];
        int rightsum =arr[right];
        left++;
        right--;
        int index = 0;
        while(left<=right && index<couples.length){
            if(leftsum == rightsum){

                AliMianShiZh ali = new AliMianShiZh();
                Couple tmpc = ali.new Couple();
                tmpc.left = left;
                tmpc.right = right;
                tmpc.sum = leftsum;
                System.out.println("class: "+tmpc.hashCode());
                couples[index++] = tmpc;

                left++;
                right--;
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

    class Couple{

        public  int left=-1;
        public  int right=-1;
        public  int mid =-1;
        public  int sum =-1;
        public  boolean bool =false;

    }



}
