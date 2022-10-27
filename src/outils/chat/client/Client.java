/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils.chat.client;

/**
 *
 * @author ahmed
 */
import entities.Messages;
import entities.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.UserService;
import services.UtilisateurService;

public class Client implements Runnable {

    /* The Socket of the Client */
    private Socket clientSocket;
    private BufferedReader serverToClientReader;
    private PrintWriter clientToServerWriter;
    private String name;
    public ObservableList<String> chatLog;

    public Client(String hostName, int portNumber, String name) throws UnknownHostException, IOException {

        /* Try to establish a connection to the server */
        clientSocket = new Socket(hostName, portNumber);
        /* Instantiate writers and readers to the socket */
        serverToClientReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
        clientToServerWriter = new PrintWriter(
                clientSocket.getOutputStream(), true);
        chatLog = FXCollections.observableArrayList();
        /* Send name data to the server */
        this.name = name;
        clientToServerWriter.println(name);

    }

    public void writeToServer(String input, String sname) {
        clientToServerWriter.println(sname + " : " + input);
    }

    public void run() {
        /* Infinite loop to update the chat log from the server */
        while (true) {
            try {

                final String inputFromServer = serverToClientReader.readLine();
                Platform.runLater(new Runnable() {
                    public void run() {
                        chatLog.add(inputFromServer);
                    }
                });

            } catch (SocketException e) {
                Platform.runLater(new Runnable() {
                    public void run() {
                        chatLog.add("Error in server");
                    }

                });
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void writeOldMessage(Messages message) {
        UtilisateurService userservice = new UtilisateurService();
        User sender = userservice.getByUserId((int) message.getIdSender());
        chatLog.add(sender.getNom()+" : "+message.getMessage());
    }
}
