package com.test.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Squares {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand1 = new Random();
		List<Integer> usedList = new ArrayList<Integer>();
		while (true) {
			int num = rand1.nextInt(20);
			if (num < 2 | usedList.contains(num)) {
				if (usedList.size()==18) {
					// exit
					CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Squares");
				} else {
					continue;
				}
			}
			usedList.add(num);	
		
			System.out.println(sno + "). " + num + "x" + num + "=");
			int ans = num * num;
			String userInput = scanner.nextLine();
			int sol = 0;
			try {
				sol = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				// i know that it's not a number
				if ("".equals(userInput) || !"exit".equalsIgnoreCase(userInput) || !userInput.contains("exit")) {
					System.out.println("incorrect, answer is: " + ans);
					incorrect++;
					sno++;
					continue;
				}
			}

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Addition");
			}
			if (sol == ans) {
				System.out.println("correct");
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + ans);
				incorrect++;
			}
			sno++;
		}
	}
}
