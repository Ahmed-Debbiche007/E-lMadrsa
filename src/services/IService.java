/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author lmol
 */
public interface IService<T> {
     void insert(T t);
   void delete(int id);
   
   void update(T t);
    List<T>read();
    
    T readById(int id);
}
