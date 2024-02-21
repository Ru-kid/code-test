package com.hong;

import com.hong.factory.CandyCrushFactory;

import java.util.Scanner;

/**
 * @author hongrunhao
 * @description
 * @date 2024/02/20 019
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string containing the letters a-z：");
        String input = scanner.nextLine();
        System.out.println("Please enter the number and select the elimination mode (1.match 3 / 2.replace)：");
        String type = scanner.nextLine();

        CandyCrushFactory.configure(input, Integer.parseInt(type));
    }

}
