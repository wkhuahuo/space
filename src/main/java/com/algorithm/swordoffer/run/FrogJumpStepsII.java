package com.algorithm.swordoffer.run;

public class FrogJumpStepsII {
	public int JumpFloorII(int target) {
		
		return sumOfJumpFloor(target)+1;
		
    }
	private int sumOfJumpFloor(int target){
		
		if(target ==1){
			return 1;
		}
		
		return sumOfJumpFloor(target-1)+jumpFloor(target-1);
	}
	private int jumpFloor(int target) {
		// TODO Auto-generated method stub
		if(target ==1){
			return 1;
		}
		if(target ==2){
			return 2;
		}
		return jumpFloor(target-1)+jumpFloor(target-2);
		
	}
}
