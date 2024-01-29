package org.example.Service;

import org.example.Exception.BookServiceException;
import org.example.Exception.CLIException;
import org.example.View.CLIParser;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import org.slf4j.Logger;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        boolean flag = true;
        // prompt user for input

        while (flag) {
            System.out.println("add / view / delete");
            String input = sc.nextLine();
            try {

                String output = cliParser.parseCommandReturnOutput(input);
                System.out.println(output);
    // if user enters anything other than add view or delete
            } catch(CLIException exception){
                System.out.println(exception.getMessage());
                exception.printStackTrace();

            } catch(BookServiceException exception){
               System.out.println(exception.getMessage());
                exception.printStackTrace();


        }
        }
    }
}


