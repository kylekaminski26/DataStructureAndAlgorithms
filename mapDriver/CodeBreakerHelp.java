package mapDriver;

import map.*;
import set.*;
import sort.QuickSort;
import sort.Sorter;
import list.*;
import java.io.*;

/**
 * Use a list of English words to unscramble the enemies messages.
 * 
 * @author Kyle Kaminski
 * @version (Apr 2019)
 */
public class CodeBreakerHelp {

	Map<String, Set<String>> map;
	List<String> words;

	public static void main(String[] args) {
		new CodeBreakerHelp();
	}

	public CodeBreakerHelp() {
		map = new HashMap<>(100000);
		words = getWords();
		buildMap();
		System.out.println(map.get(sort("niaiuanmrisotzrtiiocm")));
		System.out.println(map.get(sort("fo")));
		System.out.println(map.get(sort("uealcisonlesm")));
		System.out.println(map.get(sort("npesoaw")));
		System.out.println(map.get(sort("tpso")));
		System.out.println(map.get(sort("nialtrenosotiaertuc")));
	}

	// get a list of English words from a text file
	private List<String> getWords() {
		List<String> strings = new ArrayList<String>();
		try {
			File wordFile = new File("words.txt");
			java.util.Scanner scanner = new java.util.Scanner(wordFile);
			String word;
			while (scanner.hasNextLine())
				strings.add(scanner.nextLine());
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		}
		return strings;
	}

	/**
	 * @return the given string, with letters in alphabetic order If str is "pots"
	 *         the result should be "opst"
	 */
	private String sort(String str) {
		List<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++)
			chars.add(str.charAt(i));
		Sorter<Character> sorter;
		sorter = new QuickSort<Character>();
		sorter.sort(chars);
		String result = "";
		Iterator<Character> itty = chars.iterator();
		while (itty.hasNext())
			result += itty.next();
		return result;
	}

	public void buildMap() {
		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			String w = it.next();
			String s = sort(w);
			if (map.containsKey(s))
				map.get(s).add(w);
			else {
				Set<String> words = new HashSet<String>();
				words.add(w);
				map.put(s, words);
			}
		}
	}
}