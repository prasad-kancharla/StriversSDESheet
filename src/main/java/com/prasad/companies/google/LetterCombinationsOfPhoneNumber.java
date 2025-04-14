package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        int length = digits.length();
        if (length == 0) return combinations;

        Map<Integer, List<String>> charMap = new HashMap();

        charMap.put(2, List.of("a", "b", "c"));
        charMap.put(3, List.of("d", "e", "f"));
        charMap.put(4, List.of("g", "h", "i"));
        charMap.put(5, List.of("j", "k", "l"));
        charMap.put(6, List.of("m", "n", "o"));
        charMap.put(7, List.of("p", "q", "r", "s"));
        charMap.put(8, List.of("t", "u", "v"));
        charMap.put(9, List.of("w", "x", "y", "z"));

        return getCombinations(length - 1, length, digits, charMap);
    }

    private List<String> getCombinations(int index, int length, String digits, Map<Integer, List<String>> charMap) {
        if (index == 0) {
            return charMap.get(digits.charAt(index) - '0');
        }

        List<String> stringsFromPrev = getCombinations(index - 1, length, digits, charMap);
        List<String> stringsFromCurrNumber = charMap.get(digits.charAt(index) - '0');
        List<String> ans = new ArrayList();

        for (String s1 : stringsFromCurrNumber) {
            for (String s2 : stringsFromPrev) {
                ans.add(s2 + s1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }
}