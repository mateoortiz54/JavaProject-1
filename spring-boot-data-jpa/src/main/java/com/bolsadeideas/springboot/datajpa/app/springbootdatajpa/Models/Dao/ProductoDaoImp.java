package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
    
@Repository("ProductoDaoJPA")
public class ProductoDaoImp implements IProductoDao{ 
    
 /* Implements también puede ser herencia */

    @PersistenceContext
    private EntityManager em; //EntityManager

    @SuppressWarnings("unchecked") /*Esto es para quitar lo subrayado en amarillo*/
    @Transactional(readOnly = true)//Esto es para que sea de solo lectura y no se pueda modififcar
    @Override
    public List<Producto> findAll() {
        return em.createQuery("from Producto").getResultList(); /*Creamos un query para hacer una consulta y una vez hecha debe retornarlo en una lista */
    }

    @Override//sobreescribir
    @Transactional //Para guardar los productos
    public void save(Producto producto) {

        //if(producto != null){
            //em.merge(producto);//editar actualizar
        //}
        if(producto.getId() != null && producto.getId()>0){
            em.merge(producto);
        }
        else{
            em.persist(producto); //Estamos mandando los clientes a la BD

        }
    }

    @Transactional(readOnly = true)//Esto es para que sea de solo lectura y no se pueda modififcar
    @Override
    public Producto findOne(Long id) {
        // TODO Auto-generated method stub
        //entity manager : em
        return em.find(Producto.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        Producto producto = findOne(id);
        em.remove(producto);
        
    }

    

    
}


