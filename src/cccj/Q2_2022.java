package cccj;

import java.util.Scanner;

public class Q2_2022 {
	public void solve(){
		Scanner scr = new Scanner(System.in);
		int numOfPlayers = scr.nextInt();
		int[] players = new int [numOfPlayers]; 
		int won = 0;
		boolean gold = false;
		for(int i=0; i<numOfPlayers; i++) {
			int point=scr.nextInt();
			int foul=scr.nextInt();
			int stars=point*5-foul*3;
			if(stars>40) {
				won++;
			}
			if(won==numOfPlayers) {
				gold = true;
			}
		}
		if(gold==true) {
			System.out.println(won+"+");
			return;
		}
		System.out.println(won);
	}
}
