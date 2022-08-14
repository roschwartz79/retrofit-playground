package com.rs.retrofit.playground.app;

import com.rs.retrofit.playground.example.client.ExampleClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // We can use the scalars converter factory since we are just passing Strings back and forth!
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("http://localhost:8080")
                .build();

        // Setup our client
        ExampleClient exampleClient = retrofit.create(ExampleClient.class);

        String makeCall = "y";

        while (makeCall.equalsIgnoreCase("y")) {
            System.out.println("Select a call to make\n(1) hello\n(2) hi");
            String callToMake = sc.nextLine();

            switch(callToMake) {
                case "1":
                    System.out.println("Calling hello....");
                    // Setup our call object
                    Call<String> helloCall = exampleClient.sayHello();

                    // Execute the call and get a response
                    Response<String> helloResponse = helloCall.execute();

                    // Get the raw response
                    String helloRawResponse = helloResponse.body();

                    System.out.println("Here's the response.... " + helloRawResponse);

                    break;
                case "2":
                    System.out.println("Enter the name to say hi to:");
                    String name = sc.nextLine();

                    System.out.println("Saying hi to " + name);
                    // Setup our call object
                    Call<String> hiCall = exampleClient.sayHiToName(name);

                    // Execute the call and get a response
                    Response<String> hiResponse = hiCall.execute();

                    // Get the raw response
                    String hiRawResponse = hiResponse.body();

                    System.out.println("Here's the response.... " + hiRawResponse);
            }

            System.out.println("Do you want to make another call? (y/n)");
            makeCall = sc.nextLine();
        }

        System.out.println("That was fun. Exiting!");
    }
}
