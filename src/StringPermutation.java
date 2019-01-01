import java.util.HashSet;

public class StringPermutation {

	public static HashSet<String> getPermutations(String str){
		HashSet<String> permutations = new HashSet<>();
		if(str == null || str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainingString = str.substring(1);
		HashSet<String> words = getPermutations(remainingString);
		for(String word : words){
			for(int i=0;i<=word.length();i++){
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(prefix + first + suffix); 
			}
		}
		return permutations;
	}
	
	public static void main(String[] args){
		System.out.println(StringPermutation.getPermutations("ABC").toString());
	}
	
}
