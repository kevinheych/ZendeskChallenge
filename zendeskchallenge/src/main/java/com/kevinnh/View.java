package com.kevinnh;

import java.io.IOException;
import java.util.ArrayList;

public class View {

    private int pageNumber = 1;
    final int pageSize = 10;
    int totalPages = 1;

    public void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("\t*Press 1 to view all tickets");
        System.out.println("\t*Press 2 to view a ticket");
        System.out.println("\t*Press 3 to quit");
    }

    public void displayAllTickets(ArrayList<Ticket> tickets) {
        // rounds up
        totalPages = (int) Math.ceil((float) tickets.size() / pageSize);
        // algorithm
        int to = Math.min(pageNumber * pageSize, tickets.size());
        int from = to - pageSize;
        for (int i = from; i < to; i++) {
            System.out.println(tickets.get(i).toString());
        }
    }

    public void displayTicket(int index, ArrayList<Ticket> tickets) {
        Ticket ticket = tickets.get(index - 1);
        System.out.println("\nID:" + ticket.getId() + " Subject: " + ticket.getSubject());
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

}
