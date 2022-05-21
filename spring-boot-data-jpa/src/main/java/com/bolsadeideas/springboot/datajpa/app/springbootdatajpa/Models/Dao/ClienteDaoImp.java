package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ClienteDaoJPA")
public class ClienteDaoImp implements IClienteDao{ /* Implements también puede ser herencia */

    @PersistenceContext
    private EntityManager em; //EntityManager

    @SuppressWarnings("unchecked") /*Esto es para quitar lo subrayado en amarillo*/
    @Transactional(readOnly = true)//Esto es para que sea de solo lectura y no se pueda modififcar
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList(); /*Creamos un query para hacer una consulta y una vez hecha debe retornarlo en una lista */
    }

    @Override
    @Transactional //Para guardar los clientes
    public void save(Cliente cliente) {

        if(cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente);
        }
        else{
            em.persist(cliente); //Estamos mandando los clientes a la BD

        }
    }

    @Transactional(readOnly = true)//Esto es para que sea de solo lectura y no se pueda modififcar
    @Override
    public Cliente findOne(Long id) {
        // TODO Auto-generated method stub
        //entity manager : em
        return em.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        Cliente cliente = findOne(id);
        em.remove(cliente);
        
    }
    

    
}
