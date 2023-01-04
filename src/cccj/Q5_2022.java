package cccj;

import java.util.Scanner;

public class Q5_2022 {
	public void solve(){
		Scanner scr = new Scanner(System.in);
		int dimension = scr.nextInt();
//		String[][] map = new String[dimension][dimension];
//		for(int i=0; i<dimension; i++) {
//			for(int j=0; j<dimension; j++) {
//				map[i][j]="N";
//			}
//		}
		int treeCount = scr.nextInt();
		String[][] trees = new String[treeCount][];
		scr.nextLine();
		for(int i=0; i<treeCount; i++) {
			String treeLoc = scr.nextLine();
			trees[i]=treeLoc.split(" ");
//			map[Integer.parseInt(trees[i][0])-1][Integer.parseInt(trees[i][1])-1]="Y";

		}
		int endX = 0;
		int endY = 0;
		int largest = 0;
		boolean found = false;
		for(int height=dimension; height>0; height--) {
			if(found == true) {
				break;
			}
			for(int startY = 1;startY<=dimension; startY++) {
				if(found == true) {
					break;
				}
				for(int startX = 1;startX<=dimension; startX++) {
					if(found == true) {
						break;
					}
					if((startX+height-1)<=(dimension)&&(startY+height-1)<=(dimension)) {    //			if endX and endY smaller than boundary
					endX = startX+height-1;
					endY = startY+height-1;
					for(int k = 0; k<treeCount;k++) {
						if((Integer.parseInt(trees[k][0]))>=startY&&(Integer.parseInt(trees[k][0]))<=endY) {
								if((Integer.parseInt(trees[k][1]))>=startX&&(Integer.parseInt(trees[k][1]))<=endX) {
									break;
								}
						}
						if(k==treeCount-1 && height > largest) {
							found = true;
							largest = height;
						}
					}
				}
					else {
						continue;
					}
				}
			}
		}
		System.out.println(largest);
	}
}
