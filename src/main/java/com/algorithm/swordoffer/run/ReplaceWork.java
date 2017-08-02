package com.algorithm.swordoffer.run;

public class ReplaceWork {
	public String replaceSpace2(StringBuffer strB){
		char [] charstr = strB.toString().toCharArray();
		int countSpace = 0;
		for(int i=0;i<strB.length();i++){
			if(charstr[i]==' '){
				countSpace++;
			}
		}
		int iIndex = strB.length()-1;
		
		char [] result = new char[strB.length()+countSpace*2];
		int jIndex = result.length-1;
		while(iIndex>=0&&jIndex>=0){
			if(charstr[iIndex]!=' '){
				result[jIndex]=charstr[iIndex];
				jIndex--;
				iIndex--;
			}else{
				iIndex--;
				result[jIndex]='0';
				result[jIndex-1]='2';
				result[jIndex-2]='%';
				jIndex-=3;
			}
		}
		String str = new String(result);
		return str;
	}
	
	
	public String replaceSpace(StringBuffer strB){
		
		int countSpace = 0;
		char [] charstr = "%20".toCharArray();
		for(int i=0;i<strB.length();i++){
			if(strB.charAt(i)==' '){
				strB.deleteCharAt(i);
				strB.append(charstr, i, charstr.length-1);
			}
			
		}
//		StringBuffer tmpB = new StringBuffer();
//		for(int i=0;i<)
//		tmpB.append(str);
		
		return strB.toString();
	}
	
	
	
}
