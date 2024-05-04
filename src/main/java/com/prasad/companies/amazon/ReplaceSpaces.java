package com.prasad.companies.amazon;

public class ReplaceSpaces {

	public static void main(String[] args) {
		System.out.println(replaceSpaces(new StringBuilder("Hello World")));
	}
	public static StringBuilder replaceSpaces(StringBuilder str) {
		String s = str.toString().replaceAll("\\s", "@40");
		return new StringBuilder(s);
	}
}