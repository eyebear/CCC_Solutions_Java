package cccj;

import java.util.Scanner;

public class Q1_2022 {
	public void solve() {
		// TODO Auto-generated method stub
		System.out.println("Input R and S");
		Scanner sc = new Scanner(System.in);
		int regularBoxes = sc.nextInt();
		int smallBoxes = sc.nextInt();
		int total = regularBoxes*8+smallBoxes*3;
		int leftover = total-28;
		if(leftover<0) {
			System.out.println("Not enough cupcakes");
			return;
		}
		System.out.println("Leftover number is "+leftover);
	}
}
