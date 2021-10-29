package io.github.parambirs.gradle.graal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        logger.info("Hello, graal VM over slf4j!");

        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder(new URI("https://www.google.com/"))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        logger.info(response.body());
    }

    // Java-8 compatible way:
//    static String getData() throws IOException {
//        return convertStreamToString(new URL("https://www.google.com/").openStream());
//    }
//
//    static String convertStreamToString(java.io.InputStream is) {
//        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\\\A");
//        return s.hasNext() ? s.next() : "";
//    }
}
