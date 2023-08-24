package com.practice.programs.medium.recursion.string;

public class PrintAllPossiblePermutations {

    public static void main(String[] args) {
        permutations("abc");
    }

	public static void permutations(String input){
		print(input, "");
	}
    
    private static void print(String str, String res) {
        if (str.length() == 0) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            StringBuilder wd = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (j != i) {
                    wd.append(str.charAt(j));
                }
            }
            print(wd.toString(), res + str.charAt(i));
        }
    }
}