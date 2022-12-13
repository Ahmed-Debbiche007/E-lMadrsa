/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;

/**
 *
 * @author ahmed
 */
public class ss {

    public static void main(String[] args) {
        String hashPass = Hashing.sha256().hashString("qq2019qq", StandardCharsets.UTF_8).toString();
        System.out.println(hashPass.equals("ee54e18dac975294788bbcae4737c02daa9ab52f4f4b681bf8915c96b16c21bf"));
        
    }

}
