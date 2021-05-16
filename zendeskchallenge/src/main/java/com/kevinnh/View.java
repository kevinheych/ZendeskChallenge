package com.kevinnh;
 
import java.util.ArrayList;
/**
 * The View class is he user interface of the application. 
 */
public class View {

    private int pageNumber = 1;
    final int pageSize = 25;
    int totalPages = 1;

    public void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("\t*Press 1 to view all tickets");
        System.out.println("\t*Press 2 to view a ticket");
        System.out.println("\t*Press 3 to quit");
    }

    public void displayAllTickets(ArrayList<Ticket> tickets) {
        if (tickets.size() <= 0 ){return;}

        // rounds up
        totalPages = (int) Math.ceil((float) tickets.size() / pageSize);
        // algorithm
        int to = Math.min(pageNumber * pageSize, tickets.size());
        int from = Math.max(to - pageSize, 0);
        for (int i = from; i < to; i++) {
            System.out.println(tickets.get(i).toString());
        }
    }

    public void displayTicket(int index, ArrayList<Ticket> tickets) {
        if (tickets.size() <= 0 ){return;}
        if (index > tickets.size() ){
            System.out.println("Ticket Number not valid");
            return;}

        Ticket ticket = tickets.get(index - 1);
        System.out.println("\n[" + ticket.getId() + "] Subject: " + ticket.getSubject());
        System.out.println("\nCreated At: " + ticket.getCreatedAt() + "\nRequester ID: " + ticket.getRequesterId());
        System.out.println("Description: " + ticket.getDescription());

    }

    public void displayPages() {
        System.out.println("\nPage " + pageNumber + "/" + totalPages);
    }

    public void nextPage() {
        if (pageNumber < totalPages) {
            pageNumber++;
        }
    }

    public void previousPage() {
        if (pageNumber > 1) {
            pageNumber--;
        }
    }

    public void displayPageOptions(){
        String msg = "\n";
        if (pageNumber < totalPages){
            msg += "[1]Next Page ";
        }
        if (pageNumber>1){
            msg += "[2]Previous Page ";
        }
        msg += "[3]Main Menu";
        System.out.println(msg);
    }

}
