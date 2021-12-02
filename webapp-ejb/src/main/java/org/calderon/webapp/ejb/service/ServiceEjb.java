package org.calderon.webapp.ejb.service;

import jakarta.ejb.Stateless;
import org.calderon.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

//@RequestScoped
@Stateless
public class ServiceEjb implements ServiceEjbLocal {
    private int contador;

    public String saludar(String nombre) {
        System.out.println("Imprimiendo dentro del ejb la instancia: " + this);
        contador++;
        System.out.println("imprimiendo el valor del contador en el metodo saludar: " + contador);
        return "Hola como estas?" + nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> producto = new ArrayList<>();
        producto.add(new Producto("Mango"));
        producto.add(new Producto("Guayaba"));
        producto.add(new Producto("Fresa"));
        return producto;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Gurdando el producto...");
        Producto p = new Producto();
        p.getNombre();
        return p;
    }
}
