package com.IVdev.advanced.socket;

import java.io.*;
import java.net.Socket;

public class ClientWithTroubleShouting {
    public static void main(String[] args) throws IOException {
        try
        (
            Socket clientSocket = new Socket("localhost", 8080);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        )
        {
            Thread.sleep(20000);
            writer.write("Hello from client with troubleshouting!!!!");
            writer.newLine();
            writer.flush();
            String response = reader.readLine();
            System.out.println(response);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
