/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

import redis.clients.jedis.Jedis;

/**
 *
 * @author ahmed
 */
public class MyRedis {
    
    static MyRedis inst; 
    Jedis jedis;
    private MyRedis(){
        try {
            jedis = new Jedis("localhost",6379);
//prints out "Connection Successful" if Java successfully connects to Redis server.
            System.out.println("Redis: Connection Successful");
            System.out.println("The server is running " + jedis.ping());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static MyRedis getInstance() {
        if (inst == null) {
            inst = new MyRedis();
        }
        return inst;
    }
    
    public Jedis getCnx() {
        return jedis;
    }
    
    
}
