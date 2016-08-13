package com.calc;

import java.util.Scanner;

public class RemoveAGivenChar {
	
	public static void main(String[] args) {
		//how to return height occured number
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr= s.toLowerCase().toCharArray();
		int indx[] = new int[26];
		int asciiOffset = 97;
		for(int x=0;x<arr.length ;x++){
			indx[arr[x]-asciiOffset] = indx[arr[x]-asciiOffset]+1;
		}
		int max =indx[0];
		int indexOfMax = 0;
		for(int i=1; i<indx.length; i++){
			if(indx[i]>max){
				max = indx[i];
				indexOfMax=i;
			}	
		}
		char ch = (char)(asciiOffset+indexOfMax);
		System.out.println("Max occurance of the character is ="+ch);
	}
}
