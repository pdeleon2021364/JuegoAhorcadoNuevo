package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Palabra;
import modelo.PalabraDAO;

import java.io.IOException;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public interface Controlador extends HttpServlet {
    PalabraDAO palabraDAO = new PalabraDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        menu = "Palabras";
        if (menu.equals("Palabras")) {
            switch (accion) {
                case "Listar":
                    System.out.println("listandopalabra");
                    List<Palabra> listaPalabras = palabraDAO.li star();
                    request.setAttribute("palabras", listaPalabras);
                    request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
                    System.out.println(listaPalabras);
                    break;

                default:
                    response.sendRedirect("index.jsp");
                    break;
            }

        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador principal para el proyecto de Ahorcado";
    }
}
