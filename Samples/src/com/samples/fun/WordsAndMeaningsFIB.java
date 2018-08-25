package com.samples.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordsAndMeaningsFIB {

	private static List<String> list = new ArrayList<String>();

	public static void main(String args[]) {

		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand2 = new Random();

		List<Integer> usedWords = new ArrayList<Integer>();

		// initialize
		initializeMaps();

		System.out.println("Fill in the blanks: ");
		System.out.println();

		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String meaning = null;

			int wordNum = 0;
			int index = 138;
			// get list
			while (true) {
				wordNum = rand2.nextInt(index);
				if (usedWords.contains(wordNum)) {
					if (usedWords.size() == index) {
						CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Meanings To Words");
					}
					continue;
				} else {
					usedWords.add(wordNum);
					break;
				}
			}
			// meaning = getMeaningForWord(list, wordNum, index);
			String meaningToWord = list.get(wordNum);
			String[] cc1ItemAsArr = meaningToWord.split("\\|");
			meaning = cc1ItemAsArr[0];
			String word = cc1ItemAsArr[1];

			// present the question.. fill in the blank
			System.out.println(sno + "). \"" + meaning + "\" means _________________________");

			String userInput = scanner.nextLine();

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Meanings To Words");
			}

			if (word.contains(userInput) && !"".equals(userInput)) {
				System.out.println("correct, answer is: " + word);
				System.out.println();
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + word);
				System.out.println();
				incorrect++;
			}
			sno++;
		}
	}

	private static void initializeMaps() {
		setMap1();
	}

	private static void setMap1() {
		list.add("abolish|cancel; put an end to");
		list.add("absurd|ridiculous");
		list.add("abuse|cruel or inhumane treatment");
		list.add("access|a way of entering or leaving");
		list.add("accomplish|to do something by making an effort; to complete successfully");
		list.add("achievement|something done that takes skill or effort");
		list.add("aggressive|ready to attack or start fights; acting in a hostile way");
		list.add("alternate|go back and forth");
		list.add("altitude|height above sea level");
		list.add("antagonist|an opponent; one who opposes or competes");
		list.add("antonym|a word that means the opposite of another word");
		list.add("anxious|worried; concerned");
		list.add("apparent|obvious");
		list.add("approximate|be close or similar");
		list.add("aroma|a pleasant smell");
		list.add("assume|to take for granted; to suppose");
		list.add("astound|to surprise; to amaze");
		list.add("available|ready for use, at hand");
		list.add("avalanche|a slide of large masses of snow and ice and mud down a mountain");
		list.add("banquet|a ceremonial dinner party for many people");
		list.add("beverage|a liquid used as a drink");
		list.add("bland|mild; tasteless; dull");
		list.add("blizzard|a storm with widespread snowfall accompanied by strong winds");
		list.add("budge|to move or shift.");
		list.add("bungle|make a mess of, destroy or ruin");
		list.add("cautiously|carefully");
		list.add("challenge|something difficult to accomplish");
		list.add("character|a person or animal in a story");
		list.add("combine|add together from different sources");
		list.add("companion|person who goes along with another");
		list.add("crave|to have an extremely strong desire for something");
		list.add("compassion|sympathy for another's suffering; pity");
		list.add("compensate|do or give something to somebody in return");
		list.add("comply|to do as one is asked or ordered");
		list.add("compose|to make up");
		list.add("concept|an idea or principle");
		list.add("confident|sure of yourself");
		list.add("convert|to change from one form to another");
		list.add("course|a line or route along which something travels or moves");
		list.add("courteous|polite and gracious; considerate toward others; well-mannered");
		list.add("debate|discuss the pros and cons of an issue");
		list.add("decline|a gradual decrease");
		list.add("dedicate|to set aside for a certain purpose.");
		list.add("deprive|to take or keep something away from someone");
		list.add("detect|to discover something not easily noticed");
		list.add("dictate|to give orders");
		list.add("document|a written or printed record that gives information or proof");
		list.add("duplicate|identically copied from an original");
		list.add("edible|any substance that can be used as food");
		list.add("endanger|to expose to danger");
		list.add("escalate|to elevate, to increase in intensity");
		list.add("evade|to avoid, dodge");
		list.add("exasperate|to irritate, annoy, or anger");
		list.add("excavate|find by digging in the ground");
		list.add("exert|make a great effort at a mental or physical task");
		list.add("exhibit|something shown to the public");
		list.add("exult|feel extreme happiness or elation");
		list.add("frigid|extremely cold");
		list.add("gigantic|huge, giant, immense");
		list.add("gorge|a deep ravine (usually with a river running through it)");
		list.add("guardian|one who protects");
		list.add("hazy|unclear, misty; not readily seen or understandable");
		list.add("hearty|healthy; strong");
		list.add("homonym|a word spelled exactly like another word, but having a different meaning");
		list.add("identical|exactly alike");
		list.add("illuminate|to light up; make clear");
		list.add("immense|very large or great");
		list.add("impressive|exceptionally good");
		list.add("independent|someone who does things on his or her own");
		list.add("industrious|hardworking; not lazy");
		list.add("intense|showing great concentration or determination");
		list.add("intercept|to stop something from reaching its intended destination");
		list.add("jubilation|a feeling or expression of great joy");
		list.add("kin|one's relatives");
		list.add("luxurious|providing ease and comfort far beyond what is ordinary or necessary");
		list.add("major|more important, bigger or more serious than others of the same type");
		list.add("miniature|small; tiny");
		list.add("minor|of lesser importance or stature or rank");
		list.add("mischief|behavior that causes problems for others");
		list.add("monarch|a person who rules over a kingdom or empire");
		list.add("moral|relating to principles of right and wrong");
		list.add("myth|a traditional story accepted as history");
		list.add("narrator|someone who tells a story");
		list.add("navigate|direct carefully and safely");
		list.add("negative|bad or harmful");
		list.add("nonchalant|calm, casual, unconcerned");
		list.add("numerous|a large number; very many");
		list.add("oasis|an area in the desert with a water source");
		list.add("obsolete|out-of-date, no longer in use");
		list.add("occasion|a special event");
		list.add("overthrow|to end the rule of; to defeat, often by using force");
		list.add("pardon|legal forgiveness of a crime");
		list.add("pasture|a field of growing grass where animals can eat; a meadow");
		list.add("pedestrian|a person who travels by foot");
		list.add("perish|to die");
		list.add("petrify|turn to stone; cause to become stonelike; stun or paralyze");
		list.add("portable|capable of being easily carried");
		list.add("prefix|a syllable added to the beginning of a word");
		list.add("preserve|keep in safety and protect from harm, decay, loss, or destruction");
		list.add("protagonist|main character");
		list.add("provide|to give what is needed; to supply");
		list.add("purchase|to buy");
		list.add("reassure|to make less worried or fearful; to comfort");
		list.add("reign|to rule as a queen or king");
		list.add("reliable|able to be depended on; trustworthy");
		list.add("require|make someone do something");
		list.add("resemble|to be like or similar to.");
		list.add("retain|keep in one's mind");
		list.add("retire|to stop working because one has reached a certain age");
		list.add("revert|go back to a previous state");
		list.add("route|the path that must be followed to get to a place");
		list.add("saunter|to stroll; walk in an easy, leisurely way");
		list.add("seldom|not often");
		list.add("senseless|foolish; pointless; ridiculous");
		list.add("sever|to separate, divide into parts");
		list.add("slither|to move with a sliding, side-to-side motion of the body");
		list.add("sluggish|slow and lazy");
		list.add("soar|the act of rising upward into the air");
		list.add("solitary|being alone; lacking the company of others");
		list.add("solo|any activity that is performed alone without assistance");
		list.add("sparse|thinly scattered");
		list.add("spurt|to shoot out quickly in a stream");
		list.add("strategy|an overall plan of action");
		list.add("suffix|a letter or syllable added to the end of a word");
		list.add("suffocate|deprive of oxygen and prevent from breathing");
		list.add("summit|the top point of a mountain or hill");
		list.add("suspend|to stop; to put on hold");
		list.add("synonym|a word that means the same as another word");
		list.add("talon|a sharp hooked claw especially on a bird of prey");
		list.add("taunt|to make fun of in an insulting way");
		list.add("thrifty|careful about money; economical");
		list.add("translate|restate (words) from one language into another language");
		list.add("tropical|very hot and humid climate");
		list.add("visible|able to be seen");
		list.add("visual|having to do with sight or seeing");
		list.add("vivid|bright, distinct, and clear");
		list.add("wilderness|an area where there are few people living; an area still in its natural state");
		list.add("withdraw|take back; remove");
		list.add("ability|the power or skill to do something");
		list.add("accurate|exactly correct");
		list.add("address|direct a question at someone");
		list.add("afford|have the financial means to do something or buy something");
		list.add("alert|an automatic signal (usually a sound) warning of danger");
		list.add("analyze|to examine carefully; study closely");
		list.add("ancestor|someone from whom you are descended (but usually more remote than a grandparent)");
		list.add("annual|happening once a year");
		list.add("apparent|obvious; easy to see");
		list.add("appropriate|suitable for a particular person or place or condition");
		list.add("arena|type of performance space with audience surrounding all sides of the stage.");
		list.add("arrest|the act of apprehending (especially apprehending a criminal)");
		list.add("ascend|to move upward");
		list.add("assist|to aid; to help");
		list.add("attempt|to try; to make an effort");
		list.add("attentive|alert and watchful; considerate; thoughtful");
		list.add("attractive|pleasing to the eye or mind");
		list.add("awkward|lacking grace or skill in manner or movement or performance");
		list.add("baggage|a case used to carry belongings when traveling");
		list.add("basic|essential, fundamental");
		list.add("benefit|to gain or receive good results from something");
		list.add("blend|mix together different elements");
		list.add("blossom|develop or come to a promising stage");
		list.add("burrow|a hole in the ground made by an animal for shelter");
		list.add("calculate|to work out by using arithmetic");
		list.add("capable|have the skills and qualifications to do things well");
		list.add("captivity|the state of being held against one's will; loss of freedom");
		list.add("carefree|free from worries; having no problems");
		list.add("century|100 years");
		list.add("chamber|a natural or artificial enclosed space");
		list.add("circular|having the shape of a circle");
		list.add("coax|to persuade or urge in a gentle way");
		list.add("column|an article giving opinions or perspectives, usually in a newspaper");
		list.add("communicate|to make known; to give or exchange information");
		list.add("competition|an occasion on which a winner is selected from among two or more contestants");
		list.add("complete|to finish");
		list.add("concentrate|to focus all one's thoughts or efforts on.");
		list.add("concern|a feeling of sympathy for someone or something");
		list.add("conclude|decide by reasoning");
		list.add("confuse|mistake one thing for another");
		list.add("congratulate|to express pleasure over someone's success");
		list.add("considerable|great in amount, size, importance");
		list.add("content|satisfied");
		list.add("contribute|to give, along with others who are giving");
		list.add("crafty|skilled at tricking others");
		list.add("create|bring into existence");
		list.add("demonstrate|provide evidence for");
		list.add("descend|to go down");
		list.add("desire|expect and wish");
		list.add("destructive|causing harm or damage");
		list.add("develop|come into existence");
		list.add("disaster|something that causes great damage or harm");
		list.add("disclose|to make known");
		list.add("distract|draw someone's attention away from something");
		list.add("distress|to cause pain or sorrow; to trouble or worry.");
		list.add("dusk|the time of day immediately following sunset");
		list.add("eager|full of energy and desire to do something");
		list.add("ease|make easier");
		list.add("entertain|to interest and amuse");
		list.add("entire|having nothing left out; whole; complete");
		list.add("entrance|something that provides access; a way to get into something");
		list.add("envy|jealousy");
		list.add("essential|absolutely necessary");
		list.add("extraordinary|beyond what is ordinary or usual");
		list.add("flexible|bending and snapping back readily without breaking");
		list.add("focus|direct one's attention on something");
		list.add("fragile|easily broken or damaged or destroyed");
		list.add("frantic|wildly excited");
		list.add("frequent|happening often");
		list.add("frontier|a wilderness at the edge of a settled area of a country");
		list.add("furious|very angry");
		list.add("generosity|act of giving to others, willingness to contribute");
		list.add("hail|greet enthusiastically or joyfully");
		list.add("hardship|something that is hard to bear; difficulty");
		list.add("heroic|showing extreme courage");
		list.add("host|a person who invites guests to a social event");
		list.add("humble|not proud; modest");
		list.add("impact|influencing strongly");
		list.add("increase|make bigger or more");
		list.add("indicate|to show");
		list.add("inspire|to motivate, guide, or influence; to give hope and courage.");
		list.add("instant|without delay; happening at once");
		list.add("invisible|impossible or nearly impossible to see");
		list.add("jagged|having a sharp, pointed edge or outline");
		list.add("lack|to be without");
		list.add("limb|an arm, leg, or wing");
		list.add("limp|not having strength, or walking unevenly");
		list.add("manufacture|the act of making something (a product) from raw materials");
		list.add("master|be or become completely proficient or skilled in");
		list.add("mature|characteristic of maturity, characteristic of maturity");
		list.add("meadow|a field of grass or wildflowers.");
		list.add("mistrust|doubt about someone's honesty");
		list.add("mock|to make fun of");
		list.add("modest|simple; not fancy or extreme");
		list.add("noble|showing greatness of character by unselfish behavior");
		list.add("orchard|a place where fruit trees grow");
		list.add("outstanding|distinguished from others in excellence");
		list.add("peculiar|unusual, strange");
		list.add("peer|an equal in age or position");
		list.add("permit|a legal document giving official permission to do something");
		list.add("plead|to beg");
		list.add("plentiful|in great supply, easily available; more than enough");
		list.add("pointless|serving no useful purpose");
		list.add("portion|a part or share of the whole");
		list.add("practice|learn by repetition");
		list.add("precious|very valuable");
		list.add("prefer|like better");
		list.add("prepare|to make or get ready");
		list.add("proceed|continue with one's activities");
		list.add("queasy|sick to one's stomach; nauseated");
		list.add("recent|of a time just before the present");
		list.add("recognize|to identify someone or something seen before");
		list.add("reduce|make smaller");
		list.add("release|to let go");
		list.add("represent|to stand for or in place of");
		list.add("request|to ask for");
		list.add("resist|to work or fight against");
		list.add("response|a statement (either spoken or written) that is made in reply to a question, request, criticism, or accusation");
		list.add("reveal|make visible");
		list.add("routine|regular way of doing something");
		list.add("severe|very bad or serious");
		list.add("shabby|showing signs of wear and tear");
		list.add("shallow|not deep");
		list.add("sole|the underside of the foot");
		list.add("source|the place where something begins, where it springs into being");
		list.add("sturdy|strongly built");
		list.add("surface|the outside layer; the top");
		list.add("survive|continue to live");
		list.add("terror|an overwhelming feeling of fear and anxiety");
		list.add("threat|something that is a source of danger");
		list.add("tidy|neat and in good order");
		list.add("tour|a trip or journey in which one usually returns to the starting point.");
		list.add("tradition|values and beliefs passed from generation to generation");
		list.add("tragic|causing great sadness; terrible or dreadful");
		list.add("typical|regular; normal; usual");
		list.add("vacant|empty; unoccupied");
		list.add("valiant|brave, courageous");
		list.add("variety|a number of different kinds; assortment");
		list.add("vast|very great or very large");
		list.add("venture|to go somewhere despite the risk of possible dangers");
		list.add("weary|very tired");
	}

}
