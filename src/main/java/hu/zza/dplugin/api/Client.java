package hu.zza.dplugin.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class Client {
  private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("credentials");
  private static final HttpClient httpClient = HttpClient.newBuilder().build();

  public String simpleTranslate(String text, String target)
      throws IOException, InterruptedException {
    String authKey = resourceBundle.getString("AUTH_KEY");
    HttpRequest.Builder request = HttpRequest.newBuilder();

    request.header("Content-Type", "application/x-www-form-urlencoded")
        .header("User-Agent", "dplugin")
        .uri(URI.create("https://api-free.deepl.com/v2/translate"))
        .POST(HttpRequest.BodyPublishers.ofString(
            String.format("auth_key=%s&text=%s&target_lang=%s", authKey, text, target)
        ));

    HttpResponse<String> response = httpClient.send(request.build(), HttpResponse.BodyHandlers.ofString());

    return response.body();

  }
}
