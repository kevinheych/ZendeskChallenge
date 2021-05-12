package com.kevinnh;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

import okhttp3.*;

public class Client {

    private String zendeskURL = "https://kevinnh.zendesk.com/api/v2/tickets.json";
    private String username = "kevinn_h@live.com";
    private String password = "a2V2aW5uX2hAbGl2ZS5jb206OSRYRENXemYuKlNfaV9i";
    private ArrayList<Ticket> ticketDatabase = new ArrayList<Ticket>();

    private void getJSONTickets() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(zendeskURL)
                .method("GET", null).addHeader("Authorization", "Basic "+ password)
                .build();
        Response response = client.newCall(request).execute();
        
        Gson gson = new Gson();
        Tickets ticketResponse = gson.fromJson(response.body().string(), Tickets.class);
        ticketDatabase = (ArrayList<Ticket>) ticketResponse.getTickets();
        
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.getJSONTickets(); 
    }
}