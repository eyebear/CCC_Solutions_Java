package cccj;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Q5_2018 {
	public int totalPages;
	public String[] instructions;
	
	public int startPage = 1;
	public int currentPageCount = 1;
	public int minPageCount = 99999;
	
	public Q5_2018() {
		Scanner scr = new Scanner(System.in);
		totalPages = scr.nextInt();
		scr.nextLine();
		instructions = new String[totalPages];
		for(int i = 0; i < totalPages; i++) {
			instructions[i] = scr.nextLine();
		}
		scr.close();
	}
	public void solve() {
		//checks if all pages are reachable
		int[] reachablePageCount = new int[totalPages];
		for(int i=1; i<totalPages; i++) {
			reachablePageCount[i]=0;
		}
		for(int i=0; i<totalPages; i++) {
			String[] temp = instructions[i].split(" ");
			for(int j=1; j<temp.length;j++) {
				reachablePageCount[Integer.parseInt(temp[j])-1]=1;
			}
//			System.out.println();
		}
		for(int i=1; i<totalPages; i++) {
			if(reachablePageCount[i]==0){
				System.out.println("N");
				break;
			}
			if(i==totalPages-1) {
				System.out.println("Y");
			}
		}
		
		ArrayList<Integer> instr = new ArrayList<Integer>();

		String[] firstPageInstruction = instructions[0].split(" ");
		for(String ins : firstPageInstruction) {
			instr.add(Integer.parseInt(ins));
		}
		BFS(instr,startPage);
		System.out.println("minPageCount "+minPageCount);
		
	}
//	public ArrayList<Integer> pathCounts = new ArrayList<Integer>();
	public void BFS(ArrayList<Integer> pagesTocheck, int level) {
		level += 1;
		ArrayList<Integer> childNodes = new ArrayList<Integer>();
		for(int page : pagesTocheck) {
			if(instructions[page-1].equals("0")) {
				if(level<minPageCount) {
					minPageCount = level;
					return;
				}
			}
			else {
				String[] tempInstructionArray = instructions[page-1].split(" ");//check current page instructions. break down the instructions to get the child pages
				for(int j=1; j<tempInstructionArray.length;j++) {
					childNodes.add(Integer.parseInt(tempInstructionArray[j]));//calculate the child page number
//					System.out.println("in J: "+j);
				}
			}
		}
		BFS(childNodes, level);
	}
	
}
