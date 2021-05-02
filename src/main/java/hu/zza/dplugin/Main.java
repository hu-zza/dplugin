package hu.zza.dplugin;

import hu.zza.dplugin.api.Client;

public class Main {
  public static void main(String[] args) {
    Client client = new Client();
    try {
      System.out.println(client.simpleTranslate("Szervusztok!", "EN"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
