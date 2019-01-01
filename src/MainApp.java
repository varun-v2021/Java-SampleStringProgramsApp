import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MainApp {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		testingSubStringAPI("abcdefghijkl");
		getFirstNonRepeatingCharacter("ggjadfssghkklm");
		reverseString("abcd");
		permutationUtil("123");
		removeDuplicateCharacters("bananas");
		String result = recursiveRemovalOfCharacter("abcd", 'b');
		System.out.println("String after removing unwanted character: " + result);
		System.out.println("New Permutation method ");
		permutation2(0, "ABC");
		System.out.println("One more Permutation method ");
		String str = "ABC";
		permutation3(str,0,str.length()-1);
	}

	public static void testingSubStringAPI(String str) {
		int startingIndex = 0;
		int endingIndex = str.length() - 1;
		System.out.println(str.substring(0, 0)); // returns empty value (not
													// null)
		System.out.println(str.substring(startingIndex, endingIndex));
		System.out.println(str.substring(startingIndex + 1, endingIndex - 1));
		System.out
				.println(str.substring(startingIndex + 1, endingIndex - 1) + str.substring(startingIndex, endingIndex));
	}

	public static void getFirstNonRepeatingCharacter(String str) {
		Map<Character, CountIndex> mMap = new HashMap<>();
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length; ++i) {
			if (mMap.containsKey(charArr[i])) {
				++mMap.get(charArr[i]).count;
			} else {
				mMap.put(charArr[i], new CountIndex(i));
			}
		}
		int result = Integer.MAX_VALUE;
		for (Map.Entry<Character, CountIndex> entry : mMap.entrySet()) {
			if (entry.getValue().count == 1 && result > entry.getValue().index) {
				result = entry.getValue().index;
			}
		}
		System.out.println("getFirstNonRepeatingCharacter Result: " + result);
	}

	public static void reverseString(String str) {
		char[] charArr = str.toCharArray();
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			char temp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = temp;
			++i;
			--j;
		}
		System.out.println(new String(charArr));
	}

	public static void permutationUtil(String input) {
		permutation("", input);
	}

	public static void permutation(String perm, String word) {
		System.out.println("permutation(" + perm + "," + word + ")");
		if (word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				System.out.println("perm + word.charAt(" + i + ")" + perm + word.charAt(i));
				System.out.println("word.substring(0," + i + ") + word.substring(" + i + " + 1, word.length())");
				System.out.println("" + word.substring(0, i) + word.substring(i + 1, word.length()));
				System.out.println("word.substring(0,i) " + word.substring(0, i));
				System.out.println("word.substring(i + 1, word.length()" + word.substring(i + 1, word.length()));
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}

	public static void permutation2(int fixed, String str) {
		char[] chr = str.toCharArray();
		if (fixed == str.length())
			System.out.println(str);
		for (int i = fixed; i < str.length(); i++) {
			System.out.println("Fixed : " + fixed);
			System.out.println("i : " + i);
			System.out.println("Before swapping: " + new String(chr));
			char ch = chr[i];
			chr[i] = chr[fixed];
			chr[fixed] = ch;
			System.out.println("After swapping: " + new String(chr));
			permutation2(fixed + 1, new String(chr));
		}
	}

	public static void permutation3(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str,l,i);
				permutation3(str,l+1,r);
				str = swap(str,l,i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	// input = aabbccdd, output = abcd & input = bananas, output = bans
	public static void removeDuplicateCharacters(String str) {
		char[] charArr = str.toCharArray();
		Queue<Character> sQueue = new LinkedList();
		StringBuilder outStr = new StringBuilder();
		for (Character ch : charArr) {
			if (!sQueue.contains(ch)) {
				sQueue.add(ch);
				outStr.append(ch);
			}
		}
		System.out.println(outStr);
	}

	public static String recursiveRemovalOfCharacter(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1)
			return word;
		return recursiveRemovalOfCharacter(word.substring(0, index) + word.substring(index + 1, word.length()), ch);
	}
}
