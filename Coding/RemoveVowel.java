package Coding;


public class RemoveVowel {
    public static String removeVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(vowels.indexOf(c) != -1) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(removeVowels("iamapig"));
    }
}
