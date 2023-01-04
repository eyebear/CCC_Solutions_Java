package cccj;

import java.util.Scanner;

public class Q3_2022 {
	public void solve(){
		Scanner scr = new Scanner(System.in);
		String line = scr.nextLine();		
		String[] ins = line.split("(?<=\\+\\d)|(?<=\\-\\d)");
		for(String in : ins) {
			if(in.contains("+")) {
				String[] i=in.split("\\+");
				System.out.println(i[0]+" tighten "+i[1]);
			}
			if(in.contains("-")) {
				String[] i=in.split("\\-");
				System.out.println(i[0]+" loosen "+i[1]);
			}
		}
	}
}
