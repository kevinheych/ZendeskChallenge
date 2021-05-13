package com.kevinnh;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

	private Scanner input = new Scanner(System.in);

    public void handleMenu(){

        try {
        switch(input.nextInt()){

            case 1:
            System.out.println("One");
            
            break;
            case 2:
            System.out.println("Two");
            break;
            case 3:
            System.out.println("Three");
            break;
            
            default:
            System.out.println("Try again");
            break;
        }

    }
    catch (InputMismatchException error) {
        input.nextLine();
        System.out.println("Input not accepted.Try again");
    }
    }

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.handleMenu();
    }
}
