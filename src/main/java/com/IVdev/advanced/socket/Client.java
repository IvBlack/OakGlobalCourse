package com.IVdev.advanced.socket;

import java.io.*;
import java.net.Socket;

/*
    Самописный скрипт-клиент.
    В одном потоке нужно четко разграничивать запрос-ответ.
    Вылет из строя и клиента, и сервера ведет к потере передаче данных.

    Сокет создан для установления соединения разных машин, разнесенных географически.
    Все примеры демонстрационные.
*/
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        try
            (
                Socket clientSocket = new Socket("localhost", 8080);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            )
        {
            writer.write("Hello from good client!");
            writer.newLine();
            writer.flush();

            for (int i = 0; i < 8; i++) {
                Thread.sleep(1000);
                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
