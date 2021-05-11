package com.kevinnh;

import java.io.*;
import okhttp3.*;
public class Client {
  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder()
      .build();
    Request request = new Request.Builder()
      .url("https://kevinnh.zendesk.com/api/v2/tickets.json")
      .method("GET", null)
      .addHeader("Authorization", "Basic a2V2aW5uX2hAbGl2ZS5jb206OSRYRENXemYuKlNfaV9i")
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}