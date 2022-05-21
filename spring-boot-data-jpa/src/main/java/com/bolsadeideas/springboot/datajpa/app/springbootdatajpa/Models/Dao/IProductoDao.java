package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

public interface IProductoDao {

    public List<Producto> findAll(); //los traigo todos

    //guardar al producto
    public void save(Producto producto);

    //traemos un cliente
    //Long de clase se puede comparar con null, en el caso que lo sea, y el tipo de dato no
    public Producto findOne(Long id);

    public void delete(Long id);
        

}
