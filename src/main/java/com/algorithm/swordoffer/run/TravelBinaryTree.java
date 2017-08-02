package com.algorithm.swordoffer.run;

public class TravelBinaryTree {
	public boolean VerifySquenceOfBST2(int [] sequence) {
		if(sequence == null||sequence.length==0){
			return false;
		}
		int leftSequence = 0;
		int rightSequence = sequence.length-1;
		return VerifySequenceOfBSTCore(sequence,leftSequence,rightSequence);
	}
	
	
	private boolean VerifySequenceOfBSTCore(int[] sequence,int leftSequence,int rightSequence){
		int tmpindex =0;
		boolean lefthand = true;
		boolean righthand = true;
		
		tmpindex = findLeft(sequence,leftSequence,rightSequence);
		int iCount=leftSequence;
		while(iCount<=rightSequence){
			if(iCount<=tmpindex){
				if(sequence[iCount]>sequence[rightSequence]){
					return  false;
				}
				
			}else{
				if(sequence[iCount]<sequence[rightSequence]){
					return  false;
				}
				
			}
			iCount++;
		}
		
/*		if(tmpindex == -1){
			return false;
		}
*/		if(tmpindex == -2){
			return true;
		}
		if(tmpindex>leftSequence){
			lefthand = VerifySequenceOfBSTCore(sequence,leftSequence,tmpindex);
		}
		if(tmpindex+1<rightSequence){
			righthand = VerifySequenceOfBSTCore(sequence,tmpindex+1,rightSequence);
		}
		
		return lefthand&&righthand;
	}
	
	private int findLeft(int[] sequence,int leftSequence,int rightSequence){
		int state = 0;
		for(int i=rightSequence;i>=leftSequence;i--){
			state =i;
			if(sequence[i]<sequence[rightSequence]){
				return state;
			}
		}
		if(state==leftSequence){
			return -2;
		}
		if(state == rightSequence-1){
			return state;
		}
		
		return -1;
	}
	
//======================================================================================	
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
        	return false;
        }
        return judge(sequence, 0, sequence.length - 1);
		    
	}
	private boolean judge(int [] sequence, int left, int right){
	    if(left >= right) return true;
	    int i = right;
	    while(i > left && sequence[i - 1] > sequence[right]){
	    	--i;
	    }
	    for(int j = i - 1; j >= left; --j){
	    	if(sequence[j] > sequence[right]){
	    		return false;
	    	}
	    }
	    return judge(sequence, left, i - 1) && (judge(sequence, i, right - 1));
	}

}
