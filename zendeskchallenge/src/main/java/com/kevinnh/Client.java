package com.kevinnh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import okhttp3.*;

public class Client {

  private String zendeskURL = "https://kevinnh.zendesk.com/api/v2/tickets.json";
  private String username = "kevinn_h@live.com";
  private String password = "a2V2aW5uX2hAbGl2ZS5jb206OSRYRENXemYuKlNfaV9i";
  private ArrayList<Ticket> ticketDatabase = new ArrayList<Ticket>();

  public ArrayList<Ticket> getTicketDatabase() {
    return ticketDatabase;
  }

  public void addTickets(List<Ticket> list){
      ticketDatabase.addAll(list);
  }

  public void getJSONTickets() {
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    Request request = new Request.Builder().url(zendeskURL).method("GET", null)
        .addHeader("Authorization", "Basic " + password).build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful())
        throw new IOException("Unexpected code " + response);

      Gson gson = new Gson();
      Tickets ticketResponse = gson.fromJson(response.body().string(), Tickets.class);
      addTickets(ticketResponse.getTickets());

      if (ticketResponse.getNextPage() != null) {
        getNextPage(ticketResponse.getNextPage());
      }

    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }

  public void getNextPage(String endpoint) {
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    Request request = new Request.Builder().url(endpoint).method("GET", null)
        .addHeader("Authorization", "Basic " + password).build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful())
        throw new IOException("Unexpected code " + response);

      Gson gson = new Gson();
      Tickets ticketResponse = gson.fromJson(response.body().string(), Tickets.class);
      addTickets(ticketResponse.getTickets());

      if (ticketResponse.getNextPage() != null) {
        getNextPage(ticketResponse.getNextPage());
      }
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }


}