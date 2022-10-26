/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listners;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

import java.util.EventListener;

public interface NewScreenListener extends EventHandler {
    public void ChangeScreen(Node node);
    public void removeTopScreen();
}
