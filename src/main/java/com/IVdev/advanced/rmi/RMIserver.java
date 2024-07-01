package com.IVdev.advanced.rmi;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicBoolean;

public class RMIserver implements IRemoteService {
    // ���������������� ���������� ���������� ��� ����������� ��������� �������
    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    // ����� ��������� ������
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
    // ����� ��������� �������
    public void stopServer() {
        stopServer.set(true);
    }

    public static void main(String... args) throws AccessException, RemoteException, AlreadyBoundException {
        System.out.println("Starting service...");
        final IRemoteService service = new RmiServer();
        LocateRegistry.createRegistry(IRemoteService.PORT).bind(IRemoteService.SERVICE_NAME, UnicastRemoteObject.exportObject(service, 0));
        while (!stopServer.get()) { // ����������� ����, ���� ���������� stopServer �� �������� ���
            try {
                Thread.sleep(100); // ��������� �������� ��� ���������� ������ ����� � ������
            } catch (InterruptedException e) { // ���������� ������ ��� ������� ����������
                break;
            }
        }
        System.out.println("Server stopped");
        System.exit(0);
    }

}
