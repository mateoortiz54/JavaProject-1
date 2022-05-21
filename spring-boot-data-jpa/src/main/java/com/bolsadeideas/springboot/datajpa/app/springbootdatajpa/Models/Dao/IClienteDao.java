package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;


public interface IClienteDao { /*Esto es para crear la interfaz que nos mostrará la BD (O también un elemento de comunicacion con la BD)*/
    
    
    public List<Cliente> findAll();

    //guardar al cliente
    public void save(Cliente cliente);

    //traemos un cliente
    //Long de clase se puede comparar con null, en el caso que lo sea, y el tipo de dato no
    public Cliente findOne(Long Id);

    public void delete(Long id);
        

}
