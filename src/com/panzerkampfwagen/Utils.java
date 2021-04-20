package com.panzerkampfwagen;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class Utils {
	public static Scanner scanner = new Scanner(System.in);

	public static <T> String joinList(List<T> list) {
		return list.stream().map(e -> e.toString()).collect(Collectors.joining(",", "[", "]"));
	}
}
