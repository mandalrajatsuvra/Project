package com.calc;

import java.util.Scanner;

public class StringReverseAlgo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.next();
		char [] charArray = str.toCharArray(); 
		int fixedLength = charArray.length;
		int lastIndx = charArray.length-1;
		for(int x= 0 ; x<=lastIndx ;x++){
			char temp=charArray[x];
			charArray[x]=charArray[lastIndx];
			charArray[lastIndx]=temp;
			
			if(fixedLength%2 !=0){
				if(x==lastIndx){
					break;
				}
			}else if(fixedLength%2==0 && (x==lastIndx-1 ||lastIndx ==x-1)){
				break; 
			}
			lastIndx--;
		}
		String output = new String(charArray);
		System.out.println(output);
		
	}

}