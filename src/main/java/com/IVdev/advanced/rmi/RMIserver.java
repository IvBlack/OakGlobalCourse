package com.IVdev.advanced.rmi;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicBoolean;

public class RMIserver implements IRemoteService {
    // Потокозащищенная логическая переменная для возможности остановки сервера
    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    // Метод получения данных
    public Object getData(Person person) {
        String data;
        try {
            data = "Hello, " + person + " from " + UnicastRemoteObject.getClientHost();
        } catch (ServerNotActiveException e) {
            data = "";
        }
        return data;
    }

    @Override
    public Object getData(com.IVdev.core2.Optional.Person data) throws RemoteException {
        return null;
    }

    @Override
    // Метод остановки сервера
    public void stopServer() {
        stopServer.set(true);
    }

    public static void main(String... args) throws AccessException, RemoteException, AlreadyBoundException {
        System.out.println("Starting service...");
        final IRemoteService service = new RmiServer();
        LocateRegistry.createRegistry(IRemoteService.PORT).bind(IRemoteService.SERVICE_NAME, UnicastRemoteObject.exportObject(service, 0));
        while (!stopServer.get()) { // Бесконечный цикл, пока переменная stopServer не выключит его
            try {
                Thread.sleep(100); // Небольшая задержка для правильной работы цикла в потоке
            } catch (InterruptedException e) { // Завершение потока при внешнем прерывании
                break;
            }
        }
        System.out.println("Server stopped");
        System.exit(0);
    }

}
