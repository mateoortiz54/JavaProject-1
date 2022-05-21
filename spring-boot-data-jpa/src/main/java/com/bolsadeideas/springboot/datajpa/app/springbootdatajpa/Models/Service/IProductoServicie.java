package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

public interface IProductoServicie {

    
    public List<Producto> findAll();

    //guardar al cliente
    public void save(Producto producto);

    //traemos un Producto
    //Long de clase se puede comparar con null, en el caso que lo sea, y el tipo de dato no
    public Producto findOne(Long Id);

    public void delete(Long id);
    
}
