package com.IVdev.advanced.rmi;

import com.IVdev.core2.Optional.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Optional;

public interface IRemoteService extends Remote {
    String SERVICE_NAME = "egov/person";
    int PORT = 1101;
    Object getData(Person data) throws RemoteException;
    void stopServer() throws RemoteException;
}