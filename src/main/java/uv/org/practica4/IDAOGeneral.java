/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.org.practica4;

import java.util.List;

/**
 *
 * @author kali
 */
public interface IDAOGeneral<T, ID> {
    public T create(T p);
    public boolean delete(ID id);
    public T update(T p, ID id);
    
    public List<T> findAll();
    public T findById(ID id);
}
