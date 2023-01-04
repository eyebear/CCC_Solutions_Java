package cccj;

import java.util.ArrayList;
import java.util.Scanner;

public class Q5_2021 {
	public void solve() {
		int M, N, K;
		Scanner scr = new Scanner(System.in);
		M = scr.nextInt();
		N = scr.nextInt();
		K = scr.nextInt();
		String action;
		int actionNum;
		int counterG = 0;
		char[][] map = new char[M][N];
		for(int m = 0; m < M; m++) {
			for (int n = 0; n < N; n++) {
				map[m][n]='B';
			}
		}		
		//record the actions for ROW paint and COL paint
		//sequence does NOT matter because each cell only cares about how many times it is toggled. 
		//It does NOT matter whether it is toggled by a ROW command or a COL command.
		//The final state of the CELL is determined by how many times it has been toggled, NOT who toggles it.
		for(int i = 0; i < K; i++) {
			action = scr.next();
			actionNum = scr.nextInt();
			if(action.equals("R")) {
				int row = actionNum-1;
				for(int c = 0; c < N; c++) {
					if(map[row][c]=='B') {
						map[row][c]='G';
						counterG++;//increase G by 1 everytime we flip to G
					}
					else {
						map[row][c]='B';
						counterG--;//decrease G by 1 everytime we flip to B
					}
				}
				
			}
			if(action.equals("C")) {
				int col = actionNum-1;
				for(int r = 0; r < M; r++) {
					if(map[r][col]=='B') {
						map[r][col]='G';
						counterG++;//increase G by 1 everytime we flip to G
					}
					else {
						map[r][col]='B';
						counterG--;//decrease G by 1 everytime we flip to B
					}
				}
			}
		}
		scr.close();		
		System.out.println(counterG);
	}
	public void solve2() {
		int M, N, K;
		Scanner scr = new Scanner(System.in);
		M = scr.nextInt();
		N = scr.nextInt();
		K = scr.nextInt();
		boolean[] paintRow = new boolean[M];
		boolean[] paintCol = new boolean[M];
		for(int k = 0; k < K; k++) {
			String rowCol = scr.next();
			int pos = scr.nextInt();
			pos--;
			if(rowCol.equals("R")) {
				paintRow[pos]=!paintRow[pos];
			}else {
				paintCol[pos]=!paintCol[pos];
			}
		}
		int goldTiles = 0;
		int rowsB = 0;
		int rowsG = 0;
		for(int m = 0; m<M;m++) {
			if(paintRow[m]==true) {
				rowsG++;
				goldTiles+=N;
			}else {
				rowsB++;
			}
		}
		int newGoldTiles = 0;
		for(int n = 0; n<N; n++) {
			if(paintCol[n]==true) {
				newGoldTiles=rowsB-rowsG;
				goldTiles+=newGoldTiles;
			}
		}
		System.out.println(goldTiles);
	}
}











