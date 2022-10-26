/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import javafx.collections.ObservableList;

/**
 *
 * @author ahmed
 */
public interface GenericService<T> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    public ObservableList<T> getAll ();
    public ObservableList<T> getSingle(String query, int filter);
    public ObservableList<T> getSingle(String query, String filter);
}
