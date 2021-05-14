package com.kevinnh;
 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private Scanner input = new Scanner(System.in);
    private boolean quit = false;
    private boolean isViewing = true;
 
    public void handleMenu(Client tickets) {
        ArrayList<Ticket> allTickets = tickets.getTicketDatabase();
        View ui = new View();

        try {
            switch (input.nextInt()) {

                case 1:
                    System.out.println("\nTicket List");
                    isViewing = true;
                    while (isViewing) {
                        ui.displayAllTickets(allTickets);
                        ui.displayPages();
                        navigatePages(ui);
                    }
                    break;
                case 2:
                    System.out.println("\nEnter Ticket ID: ");
                    int userInput = input.nextInt();
                    ui.displayTicket(userInput, allTickets);
                    break;
                case 3:
                    System.out.println("\nQuit");
                    setQuit(true);
                    break;

                default:
                    System.out.println("\n\nTry again");
                    break;
            } 
        } catch (InputMismatchException error) {
            input.nextLine();
            System.out.println("\n\nInteger input required. Try again");
        }
    }

    private void navigatePages(View ui) { 
        System.out.println("\n[1]Next Page [2]Previous Page [3]Main Menu ");
        try {
            switch (input.nextInt()) {

                case 1:
                    ui.nextPage();
                    break;
                case 2:
                    ui.previousPage();
                    break;
                case 3:
                    isViewing = false;
                    break;

                default:
                    System.out.println("\n\nTry again");
                    break;
            } 
        } catch (InputMismatchException error) {
            input.nextLine();
            System.out.println("\n\nInteger input required. Try again");
        }
    } 

    public boolean isQuit() {
        return quit;
    }

    private void setQuit(boolean quit) {
        this.quit = quit;
    }

}
