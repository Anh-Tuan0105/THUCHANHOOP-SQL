import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int spaceCount = input.length() - input.replace(" ", "").length();
        int wordCount = input.trim().isEmpty() ? 0 : input.trim().split("\\s+").length;

        System.out.println(spaceCount);
        System.out.println(wordCount);

        scanner.close();
    }
}
