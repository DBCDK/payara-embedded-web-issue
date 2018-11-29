package com.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;


public class ClientIT {

    @Test
    public void test() {
        System.out.println("test");

        Client client = ClientBuilder.newClient();

        Response response = client.target("http://example.com/")
                .request(MediaType.WILDCARD_TYPE)
                .get();

        if (response.getStatus() == 200)
            System.out.println("content = " + response.readEntity(String.class));
    }
}
