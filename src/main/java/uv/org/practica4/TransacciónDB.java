/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.org.practica4;

import java.sql.Connection;

/**
 *
 * @author kali
 */
public abstract class TransacciónDB<T> {

    /**
     *
     */
    protected T p;
    protected TransacciónDB(T p){
        this.p = p;
    }
    public abstract boolean execute(Connection con);
}
