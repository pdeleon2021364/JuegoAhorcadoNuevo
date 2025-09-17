package controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"}
public interface Validar extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletRequest response)
        throws ServerException, IOException{
    System.out.println("mensaje");
    String accion = request.getParameter("accion");
    if ("Ingresar".equalsIgnoreCase(accion)){
        System.out.println("Ingresando";
    }


}







}


