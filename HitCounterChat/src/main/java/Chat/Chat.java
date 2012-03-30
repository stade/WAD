/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stade
 */
public class Chat extends HttpServlet {

    private Viestijono viestijono = new Viestijono();
    private String viesti;
    private String tunnus;
    private String osoite;

    private int tarkistaKirjautuminen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if (session.getAttribute("ktunnus") == null) {
            osoite = "/Login";
            
            //RequestDispatcher dispatcher = request.getRequestDispatcher(osoite);
            //dispatcher.forward(request, response);
            response.sendRedirect(request.getContextPath() + "/Login");
            response.flushBuffer();
            
            
            return 0;
            
        } else {
            osoite = "WEB-INF/Chat.jsp";
            return 1;
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (tarkistaKirjautuminen(request, response) == 1) {


        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("viestit", viestijono.getViestit());
        request.setAttribute("osoite", request.getContextPath() + "/Logout");

        RequestDispatcher dispatcher = request.getRequestDispatcher(osoite);
        dispatcher.forward(request, response);
        
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        tarkistaKirjautuminen(request, response);

        tunnus = "" + request.getSession().getAttribute("ktunnus");


        if (request.getParameter("viesti") != null) {
            viesti = tunnus + ": " + request.getParameter("viesti");
            viestijono.lisaaViestijonoon(viesti);
        }

        // POST-kutsun jälkeen takaisin listaukseen
        response.setStatus(302);
        response.setHeader("Location", request.getContextPath() + "/Chat");
        response.flushBuffer();
    }
}