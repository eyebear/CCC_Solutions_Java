package cccj;

import java.util.Scanner;

public class Q4_2022 {
	public void solve(){
		int violated = 0;
		String[][] X = null;
		String[][] Y = null;
		Scanner scr = new Scanner(System.in);
		String linex = scr.nextLine();
		if(Integer.parseInt(linex)!=0) {
			X = new String[Integer.parseInt(linex)][2];
			for (int i=0;i<Integer.parseInt(linex);i++) {
				X[i]=scr.nextLine().split(" ");
	//			System.out.println(X[i][0]+X[i][1]);
			}
		}
		String liney= scr.nextLine();
		if(Integer.parseInt(liney)!=0) {
			Y =new String[Integer.parseInt(liney)][2];
			for (int i=0;i<Integer.parseInt(liney);i++) {
				Y[i]=scr.nextLine().split(" ");
	//			System.out.println(Y[i]);
			}
		}
		String lineg= scr.nextLine();
		String[] G =new String[Integer.parseInt(lineg)];
		for (int i=0;i<Integer.parseInt(lineg);i++) {
			G[i]=scr.nextLine();
			if(X!=null) {
				for(String[] ruleX : X) {
					if(!G[i].contains(ruleX[0])&&G[i].contains(ruleX[1])) {
						violated++;
					}
				}
			}
			if(Y!=null) {
				for(String[] ruleY : Y) {
					if(G[i].contains(ruleY[0])&&G[i].contains(ruleY[1])) {
						violated++;
					}
				}
			}
		}
		
		System.out.println(violated);
		
		
	}
}
