package com.kevinnh;


public class App {
    
    public static void main(String[] args)  { 

        Client ticketClient = new Client();
        Controller input = new Controller();
        View ui = new View();

        ticketClient.getJSONTickets();
       
        while(!input.isQuit()){
            ui.displayMenu();
            input.handleMenu(ticketClient);
        }
        System.exit(0);
    }
}
