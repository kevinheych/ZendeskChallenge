package com.kevinnh;

import java.io.IOException;

public class View {

    public void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("\t*Press 1 to view all tickets");
        System.out.println("\t*Press 2 to view a ticket");
        System.out.println("\t*Enter 'quit' to exit");
    }

    

    



    public static void main(String[] args) throws IOException {
        View view = new View();
        view.displayMenu();
    }
}
