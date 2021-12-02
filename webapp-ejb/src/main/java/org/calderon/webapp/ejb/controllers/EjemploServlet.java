package org.calderon.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.calderon.webapp.ejb.models.Producto;
import org.calderon.webapp.ejb.service.ServiceEjb;
import org.calderon.webapp.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    //   @Inject
//    private ServiceEjbLocal servicio;

    // @Inject
    //private ServiceEjbLocal servicio2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal servicio = null;
        ServiceEjbLocal servicio2 = null;
        try {
            InitialContext ctx = new InitialContext();
            servicio = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb}/ServiceEjb!org.calderon.webapp.ejb.service.ServiceEjbLocal");
            servicio2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb}/ServiceEjb!org.calderon.webapp.ejb.service.ServiceEjbLocal");

        } catch (NamingException e) {
            e.printStackTrace();
        }

        System.out.println("si el servico es igual a servicio2 " + servicio.equals(servicio2));
        Producto p = servicio.crear(new Producto("uvas"));
        System.out.println("Nuevo producto " + p);
        req.setAttribute("saludo", servicio.saludar("Daniel"));
        req.setAttribute("saludo2", servicio2.saludar("Alexander"));
        req.setAttribute("listado", servicio.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
