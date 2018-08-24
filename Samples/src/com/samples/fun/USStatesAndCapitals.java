package com.samples.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class USStatesAndCapitals {

	private static List<String> list = new ArrayList<String>();

	public static void main(String args[]) {

		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		// Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		
		List<Integer> usedCountries1 = new ArrayList<Integer>();

		// initialize countries/capitals
		initializeMaps();
		
		System.out.println("Choose the correct answer from the following: ");
		System.out.println();

		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String country = null;
			Map<Integer, String> cityChoices = new HashMap<Integer, String>();

			int countryNum = 0;
			int index = 50;
			// get countries/capitals
			while (true) {
				countryNum = rand2.nextInt(50);
				if (usedCountries1.contains(countryNum)) {
					if (usedCountries1.size()==index) {
						CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "US States & Capitals");
					}
					continue;
				} else {
					usedCountries1.add(countryNum);
					break;
				}
			}
			// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
			country = getChoicesForCountry(list, cityChoices, countryNum, index);
		

			// randomize 4 choices
			int[] choiceArr = { 1, 2, 3, 4 };
			for (int i = 0; i < choiceArr.length; i++) {
				int randomPosition = rand3.nextInt(choiceArr.length);
				int temp = choiceArr[i];
				choiceArr[i] = choiceArr[randomPosition];
				choiceArr[randomPosition] = temp;
			}

			// present the question with 4 choices
			String ans = poseQuestion(sno, country, cityChoices, choiceArr);

			String userInput = scanner.nextLine();

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "US States & Capitals");
			}

			if (ans.equalsIgnoreCase(userInput)) {
				System.out.println("correct");
				System.out.println();
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + ans);
				System.out.println();
				incorrect++;
			}
			sno++;
		}
	}

	private static String poseQuestion(int sno, String country, Map<Integer, String> choiceMap, int[] choiceArr) {
		System.out.println(sno + "). What is the capital city of " + country + "?");

		String ans = null;
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				if (choiceArr[i] == 1) {
					ans = "a";
				}
				System.out.println("a. " + choiceMap.get(choiceArr[i]));
			} else if (i == 1) {
				if (choiceArr[i] == 1) {
					ans = "b";
				}
				System.out.println("b. " + choiceMap.get(choiceArr[i]));
			} else if (i == 2) {
				if (choiceArr[i] == 1) {
					ans = "c";
				}
				System.out.println("c. " + choiceMap.get(choiceArr[i]));
			} else if (i == 3) {
				if (choiceArr[i] == 1) {
					ans = "d";
				}
				System.out.println("d. " + choiceMap.get(choiceArr[i]));
			}
		}
		return ans;
	}

	private static void initializeMaps() {
		setMap1();
	}

	private static String getChoicesForCountry(List<String> list, Map<Integer, String> choiceMap, int countryNum, int index) {
		String country;
		String capital;
		List<Integer> usedCountries = new ArrayList<Integer>();
		usedCountries.add(countryNum);
		String countryNCapital = list.get(countryNum);
		String[] cc1ItemAsArr = countryNCapital.split(",");
		country = cc1ItemAsArr[0];
		capital = cc1ItemAsArr[1];
		// put right choice in map
		choiceMap.put(1, capital);

		for (int i = 2; i < 5; i++) {
			Random r = new Random();
			int otherCountryNum = 0;
			while (true) {
				otherCountryNum = r.nextInt(index);
				if (usedCountries.contains(otherCountryNum)) {
					continue;
				} else {
					usedCountries.add(otherCountryNum);
					break;
				}
			}
			String otherCountryNCapital = list.get(otherCountryNum);
			String[] otherCountryNCapitalAsArr = otherCountryNCapital.split(",");
			// put wrong choices in map
			choiceMap.put(i, otherCountryNCapitalAsArr[1]);
		}
		return country;
	}

	private static void setMap1() {
		list.add("Alabama,Montgomery ");
		list.add("Alaska,Juneau ");
		list.add("Arizona,Phoenix ");
		list.add("Arkansas,Little Rock ");
		list.add("California,Sacramento ");
		list.add("Colorado,Denver ");
		list.add("Connecticut,Hartford ");
		list.add("Delaware,Dover ");
		list.add("Florida,Tallahassee ");
		list.add("Georgia,Atlanta ");
		list.add("Hawaii,Honolulu ");
		list.add("Idaho,Boise ");
		list.add("Illinois,Springfield ");
		list.add("Indiana,Indianapolis ");
		list.add("Iowa,Des Moines ");
		list.add("Kansas,Topeka ");
		list.add("Kentucky,Frankfort ");
		list.add("Louisiana,Baton Rouge ");
		list.add("Maine,Augusta ");
		list.add("Maryland,Annapolis ");
		list.add("Massachusetts,Boston ");
		list.add("Michigan,Lansing ");
		list.add("Minnesota,St. Paul ");
		list.add("Mississippi,Jackson ");
		list.add("Missouri,Jefferson City ");
		list.add("Montana,Helena");
		list.add("Nebraska,Lincoln");
		list.add("Nevada,Carson City");
		list.add("New Hampshire,Concord");
		list.add("New Jersey,Trenton");
		list.add("New Mexico,Santa Fe");
		list.add("New York,Albany");
		list.add("North Carolina,Raleigh");
		list.add("North Dakota,Bismarck");
		list.add("Ohio,Columbus");
		list.add("Oklahoma,Oklahoma City");
		list.add("Oregon,Salem");
		list.add("Pennsylvania,Harrisburg");
		list.add("Rhode Island,Providence");
		list.add("South Carolina,Columbia");
		list.add("South Dakota,Pierre");
		list.add("Tennessee,Nashville");
		list.add("Texas,Austin");
		list.add("Utah,Salt Lake City");
		list.add("Vermont,Montpelier");
		list.add("Virginia,Richmond");
		list.add("Washington,Olympia");
		list.add("West Virginia,Charleston");
		list.add("Wisconsin,Madison");
		list.add("Wyoming,Cheyenne");
	}

}
