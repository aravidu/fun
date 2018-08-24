package com.test.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CountriesAndCapitals {

	private static List<String> africas = new ArrayList<String>();
	private static List<String> americas = new ArrayList<String>();
	private static List<String> asias = new ArrayList<String>();
	private static List<String> europe = new ArrayList<String>();
	private static List<String> oceania = new ArrayList<String>();

	public static void main(String args[]) {

		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		//Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		
		List<Integer> usedCountries1 = new ArrayList<Integer>();
		List<Integer> usedCountries2 = new ArrayList<Integer>();
		List<Integer> usedCountries3 = new ArrayList<Integer>();
		List<Integer> usedCountries4 = new ArrayList<Integer>();
		List<Integer> usedCountries5 = new ArrayList<Integer>();

		// initialize countries/capitals
		initializeMaps();
		
		System.out.println("Choose the correct answer from the following: ");
		System.out.println();

		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int continent = 2;// rand1.nextInt(6);
			// System.out.println("continent: "+continents);
			if (continent == 0) {
				continue;
			}

			String country = null;
			Map<Integer, String> cityChoices = new HashMap<Integer, String>();

			int countryNum = 0;
			int index = 0;
			// get countries/capitals
			if (continent == 1) {
				// A 54
				index = 54;
				countryNum = rand2.nextInt(54);
				// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
				country = getChoicesForCountry(africas, cityChoices, countryNum, index);
			} else if (continent == 2) {
				// Am 35
				index = 35;
				while (true) {
					countryNum = rand2.nextInt(35);
					if (usedCountries2.contains(countryNum)) {
						if (usedCountries2.size()==index) {
							CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Countries & Capitals");
						}
						continue;
					} else {
						usedCountries2.add(countryNum);
						break;
					}
				}
				// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
				country = getChoicesForCountry(americas, cityChoices, countryNum, index);
			} else if (continent == 3) {
				// As 47
				index = 47;
				countryNum = rand2.nextInt(47);
				// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
				country = getChoicesForCountry(asias, cityChoices, countryNum, index);
			} else if (continent == 4) {
				// E 46
				index = 46;
				countryNum = rand2.nextInt(46);
				// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
				country = getChoicesForCountry(europe, cityChoices, countryNum, index);
			} else if (continent == 5) {
				// O 15
				index = 15;
				countryNum = rand2.nextInt(15);
				// System.out.println("Continent: " + continent + ", Country num: " + countryNum);
				country = getChoicesForCountry(oceania, cityChoices, countryNum, index);
			}

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
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Countries & Capitals");
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
		setMap2();
		setMap3();
		setMap4();
		setMap5();
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
		africas.add("Algeria,Algiers");
		africas.add("Angola,Luanda");
		africas.add("Benin,Porto Novo");
		africas.add("Botswana,Gaborone");
		africas.add("Burkina Faso,Ouagadougou");
		africas.add("Burundi,Bujumbura");
		africas.add("Cameroon,Yaoundé");
		africas.add("Cape Verde,Praia");
		africas.add("Central African Republic,Bangui");
		africas.add("Chad,N'Djamena");
		africas.add("Comoros,Moroni");
		africas.add("Democratic Republic of Congo,Kinshasa");
		africas.add("Djibouti,Djibouti");
		africas.add("Egypt,Cairo");
		africas.add("Equatorial Guinea,Malabo");
		africas.add("Eritrea,Asmara");
		africas.add("Ethiopia,Addis Ababa");
		africas.add("Gabon,Libreville");
		africas.add("Gambia,Banjul");
		africas.add("Ghana,Accra");
		africas.add("Guinea,Conakry");
		africas.add("Guinea-Bissau,Bissau");
		africas.add("Ivory Coast,Yamoussoukro");
		africas.add("Kenya,Nairobi");
		africas.add("Lesotho,Maseru");
		africas.add("Liberia,Monrovia");
		africas.add("Libya,Tripoli");
		africas.add("Madagascar,Antananarivo");
		africas.add("Malawi,Lilongwe");
		africas.add("Mali,Bamako");
		africas.add("Mauritania,Nouakchott");
		africas.add("Mauritius,Port Louis");
		africas.add("Morocco,Rabat");
		africas.add("Mozambique,Maaddo");
		africas.add("Namibia,Windhoek");
		africas.add("Niger,Niamey");
		africas.add("Nigeria,Abuja");
		africas.add("Republic of the Congo,Brazzaville");
		africas.add("Rwanda,Kigali");
		africas.add("São Tomé and Príncipe,São Tomé");
		africas.add("Senegal,Dakar");
		africas.add("Seychelles,Victoria");
		africas.add("Sierra Leone,Freetown");
		africas.add("Somalia,Mogadishu");
		africas.add("South Africa,Pretoria");
		africas.add("South Sudan,Juba");
		africas.add("Sudan,Khartoum");
		africas.add("Swaziland,Mbabane");
		africas.add("Tanzania,Dodoma");
		africas.add("Togo,Lomé");
		africas.add("Tunisia,Tunis");
		africas.add("Uganda,Kampala");
		africas.add("Zambia,Lusaka");
		africas.add("Zimbabwe,Harare");
	}

	private static void setMap2() {
		americas.add("Antigua and Barbuda,St. John's");
		americas.add("Argentina,Buenos Aires");
		americas.add("Bahamas,Nassau");
		americas.add("Barbados,Bridgetown");
		americas.add("Belize,Belmopan");
		americas.add("Bolivia,Sucre");
		americas.add("Brazil,Brasilia");
		americas.add("Canada,Ottawa");
		americas.add("Chile,Santiago");
		americas.add("Colombia,Bogota");
		americas.add("Costa Rica,San José");
		americas.add("Cuba,Havana");
		americas.add("Dominica,Roseau");
		americas.add("Dominican Republic,Santo Domingo");
		americas.add("Ecuador,Quito");
		americas.add("El Salvador,San Salvador");
		americas.add("Grenada,St. George's");
		americas.add("Guatemala,Guatemala City");
		americas.add("Guyana,Georgetown");
		americas.add("Haiti,Port-au-Prince");
		americas.add("Honduras,Tegucigalpa");
		americas.add("Jamaica,Kingston");
		americas.add("Mexico,Mexico City");
		americas.add("Nicaragua,Managua");
		americas.add("Panama,Panama City");
		americas.add("Paraguay,Asunción");
		americas.add("Peru,Lima");
		americas.add("Saint Kitts and Nevis,Basseterre");
		americas.add("Saint Lucia,Castries");
		americas.add("Saint Vincent and the Grenadines,Kingstown");
		americas.add("Suriname,Paramaribo");
		americas.add("Trinidad and Tobago,Port of Spain");
		americas.add("United States,Washington D.C.");
		americas.add("Uruguay,Montevideo");
		americas.add("Venezuela,Caracas");
	}

	private static void setMap3() {
		asias.add("Afghanistan,Kabul");
		asias.add("Armenia,Yerevan");
		asias.add("Azerbaijan,Baku");
		asias.add("Bahrain,Manama");
		asias.add("Bangladesh,Dhaka");
		asias.add("Bhutan,Thimphu");
		asias.add("Brunei,Bandar Seri Begawan");
		asias.add("Cambodia,Phnom Penh");
		asias.add("China,Beijing");
		asias.add("Georgia,Tbilisi");
		asias.add("India,New Delhi");
		asias.add("Indonesia,Jakarta");
		asias.add("Iran,Tehran");
		asias.add("Iraq,Baghdad");
		asias.add("Israel,Jerusalem");
		asias.add("Japan,Tokyo");
		asias.add("Jordan,Amman");
		asias.add("Kazakhstan,Astana");
		asias.add("North Korea,Pyongyang");
		asias.add("South Korea,Seoul");
		asias.add("Kuwait,Kuwait City");
		asias.add("Kyrgyzstan,Bishkek");
		asias.add("Laos,Vientiane");
		asias.add("Lebanon,Beirut");
		asias.add("Malaysia,Kuala Lumpur");
		asias.add("Maldives,Malé");
		asias.add("Mongolia,Ulaanbaatar");
		asias.add("Myanmar,Naypyidaw");
		asias.add("Nepal,Kathmandu");
		asias.add("Oman,Muscat");
		asias.add("Pakistan,Islamabad");
		asias.add("Palestine,East Jerusalem");
		asias.add("Philippines,Manila");
		asias.add("Qatar,Doha");
		asias.add("Saudi Arabia,Riyadh");
		asias.add("Singapore,Singapore");
		asias.add("Sri Lanka,Sri Jayawardenapura Kotte");
		asias.add("Syria,Damascus");
		asias.add("Taiwan,Taipei");
		asias.add("Tajikistan,Dushanbe");
		asias.add("Thailand,Bangkok");
		asias.add("Turkey,Ankara");
		asias.add("Turkmenistan,Ashgabat");
		asias.add("United Arab Emirates,Abu Dhabi");
		asias.add("Uzbekistan,Tashkent");
		asias.add("Vietnam,Hanoi");
		asias.add("Yemen,Sana'a");
	}

	private static void setMap4() {
		europe.add("Albania,Tirana");
		europe.add("Andorra,Andorra la Vella");
		europe.add("Austria,Vienna");
		europe.add("Belarus,Minsk");
		europe.add("Belgium,Brussels");
		europe.add("Bosnia and Herzegovina,Sarajevo");
		europe.add("Bulgaria,Sofia");
		europe.add("Croatia,Zagreb");
		europe.add("Cyprus,Nicosia");
		europe.add("Czech Republic,Prague");
		europe.add("Denmark,Copenagen");
		europe.add("Estonia,Tallinn");
		europe.add("Finland,Helsinki");
		europe.add("France,Paris");
		europe.add("Germany,Berlin");
		europe.add("Greece,Athens");
		europe.add("Hungary,Budapest");
		europe.add("Iceland,Reykjavík");
		europe.add("Ireland,Dublin");
		europe.add("Italy,Rome");
		europe.add("Kosovo,Pristina");
		europe.add("Latvia,Riga");
		europe.add("Liechtenstein,Vaduz");
		europe.add("Lithuania,Vilnius");
		europe.add("Luxembourg,Luxembourg");
		europe.add("Macedonia,Skopje");
		europe.add("Malta,Valletta");
		europe.add("Moldova,Chisinau");
		europe.add("Monaco,Monaco");
		europe.add("Montenegro,Podgorica");
		europe.add("Netherlands,Amsterdam");
		europe.add("Norway,Oslo");
		europe.add("Poland,Warsaw");
		europe.add("Portugal,Lisbon");
		europe.add("Romania,Bucharest");
		europe.add("Russia,Moscow");
		europe.add("San Marino,San Marino");
		europe.add("Serbia,Belgrade");
		europe.add("Slovakia,Bratislava");
		europe.add("Slovenia,Ljubljana");
		europe.add("Spain,Madrid");
		europe.add("Sweden,Stockholm");
		europe.add("Switzerland,Bern");
		europe.add("Ukraine,Kiev");
		europe.add("United Kingdom,London");
		europe.add("Vatican City,Vatican City");
	}

	private static void setMap5() {
		oceania.add("Australia,Canberra");
		oceania.add("East Timor,Dili");
		oceania.add("Fiji,Suva");
		oceania.add("Kiribati,Tarawa");
		oceania.add("Marshall Islands,Majuro");
		oceania.add("Micronesia,Palikir");
		oceania.add("Nauru,Yaren");
		oceania.add("New Zealand,Wellington");
		oceania.add("Palau,Melekeok");
		oceania.add("Papua New Guinea,Port Moresby");
		oceania.add("Samoa,Apia");
		oceania.add("Solomon Islands,Honiara");
		oceania.add("Tonga,Nukualofa");
		oceania.add("Tuvalu,Funafuti");
		oceania.add("Vanuatu,Port Vila");
	}

}
