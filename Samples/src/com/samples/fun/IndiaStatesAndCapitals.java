package com.samples.fun;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class IndiaStatesAndCapitals {

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
			int index = 36;
			// get countries/capitals
			while (true) {
				countryNum = rand2.nextInt(36);
				if (usedCountries1.contains(countryNum)) {
					if (usedCountries1.size()==index) {
						computeStatsAndExit(sno, correct, incorrect, startTime, scanner);
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
				computeStatsAndExit(sno, correct, incorrect, startTime, scanner);
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

	private static void computeStatsAndExit(int sno, double correct, double incorrect, long startTime,
			Scanner scanner) {
		scanner.close();
		long elapsed = System.currentTimeMillis() - startTime;
		long elapsedInSec = elapsed / 1000;
		double timeInMin = elapsedInSec/60d;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
		System.out.println();
		System.out.println(sdf.format(new Date()) + "\tMultiplication\t" + df.format(timeInMin) + "\t"
				+ (sno - 1) + "\t" + Math.round(correct) + "\t" + Math.round(incorrect) + "\t"
				+ Math.round((correct / (sno - 1)) * 100) + " %");
		System.exit(1);
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
		list.add("Andhra Pradesh,Hyderabad");
		list.add("Arunachal Pradesh,Itanagar");
		list.add("Assam,Dispur");
		list.add("Bihar,Patna");
		list.add("Chhattisgarh,Raipur");
		list.add("Goa,Panaji");
		list.add("Gujarat,Gandhinagar");
		list.add("Haryana,Chandigarh");
		list.add("Himachal Pradesh,Shimla");
		list.add("Jammu and Kashmir,Srinagar (summer); Jammu (winter)");
		list.add("Jharkhand,Ranchi");
		list.add("Karnataka,Bengaluru (formerly Bangalore)");
		list.add("Kerala,Thiruvananthapuram");
		list.add("Madhya Pradesh,Bhopal");
		list.add("Maharashtra,Mumbai");
		list.add("Manipur,Imphal");
		list.add("Meghalaya,Shillong");
		list.add("Mizoram,Aizawl");
		list.add("Nagaland,Kohima");
		list.add("Odisha,Bhubaneswar");
		list.add("Punjab,Chandigarh");
		list.add("Rajasthan ,Jaipur");
		list.add("Sikkim ,Gangtok");
		list.add("Tamil Nadu ,Chennai");
		list.add("Telangana ,Hyderabad");
		list.add("Tripura,Agartala");
		list.add("Uttar Pradesh,Lucknow");
		list.add("Uttarakhand ,Dehradun");
		list.add("West Bengal ,Kolkata");
		list.add("Andaman and Nicobar Islands,Port Blair");
		list.add("Chandigarh,Chandigarh");
		list.add("Dadar and Nagar Haveli,Silvassa");
		list.add("Daman and Diu,Daman");
		list.add("Delhi ,Delhi");
		list.add("Lakshadweep ,Kavaratti");
		list.add("Puducherry (Pondicherry),Pondicherry");
	}

}
