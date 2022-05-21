package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Controllers;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;
//import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.IProductoService;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.IProductoServicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller 
public class ProductoController {

    
    @Autowired//Estamos conectandolo al Query (Consulta) para generar una vista 
    private IProductoServicie productoServicie;
    //private IProductoService productoService;
    /*@Qualifier("ClienteDaoJPA")//Identifica cual repositorio usar
    private IClienteDao clienteDao;//Instancia */


    @GetMapping("/listarProductos")
    public String listarProductos(Model model){ //Asigno información a los templates, con los models

        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", productoServicie.findAll());

        return "listarProductos";
    }

    @GetMapping("/formProductos")
    public String crear(Map<String,Object> model){//El String es lo que le vamos a enviar

        Producto producto = new Producto(); //Instanciamos el objeto

        model.put("producto", producto); //El primero es como se encuentra en el template (nombre de la variable en el html), y el otro es el objeto, con este le enviamos de otra forma
        model.put("titulo", "Formulario de Producto"); 

        return "formProductos";
    }

    //@PostMapping("/form") para guardar desde un formulario se utiliza el Post
    @RequestMapping(value = "/formProductos", method = RequestMethod.POST) //Hay que especificar ya que por predeterminado pone GET
    public String guardar(@Valid Producto producto,BindingResult result, Model model){ //Estamos validando al cliente ---- debemos entrar al pom.xml y duplicar la última dependencia y quitarle el Scope y cambiar el test por -validation


        if(result.hasErrors()){

            model.addAttribute("titulo","formulario de Producto");
            return "formProductos";
        }

        productoServicie.save(producto);//VAmos a guardar el cliente 
        return "redirect:listarProductos"; //Una vez que guarda nos manda nuevamente a listar
    }


    @GetMapping("/formProductos/{id}")
    public String editar(@PathVariable Long id, Map<String,Object> model){

        Producto producto = null;

        if(id>0){

            producto = productoServicie.findOne(id);
        }
        else{
            return "redirect:/listarProductos";
        }

        model.put("producto", producto); 
        model.put("titulo", "Editar Producto"); //editamos el titulo con el tymelife del template

        return "formProductos";
    }


    @GetMapping("/eliminarProductos/{id}")
    public String eliminar(@PathVariable Long id){

        if(id>0)
            productoServicie.delete(id);

        return "redirect:/listarProductos";
    }

}


