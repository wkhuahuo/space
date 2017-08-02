package com.algorithm.swordoffer.run;

public class RectangleOfN {
	
	public int RectCover(int target) {
		if(target<0){
            return 0;
        }
        if(target==0){
            return 0;
        }
		if(target==2){
			return 2;
		}
		if(target== 1){
			return 1;
		}
			
		return RectCover(target-1)+RectCover(target-2);
    }
}
