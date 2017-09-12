package sort.java9.http;

import java.net.URI;

import jdk.incubator.http.*;

public class Http2GET {

    public static void main(String... args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://www.familysearch.org/"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

        System.out.println(response.statusCode());
        System.out.println(response.body().substring(0, 2048));
    }
}
