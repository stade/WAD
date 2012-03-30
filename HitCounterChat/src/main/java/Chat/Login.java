/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
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
public class Login extends HttpServlet {

    private String tunnus = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("tunnus") != null) {

            tunnus = request.getParameter("tunnus");


            if (tunnus != null && tunnus.length() > 3 && tunnus.length() < 9) {
                HttpSession session = request.getSession();

                session.setAttribute("ktunnus", tunnus);

                // POST-kutsun jälkeen takaisin listaukseen
                response.setStatus(302);

                response.setHeader("Location", request.getContextPath() + "/Chat");
                response.flushBuffer();

            }
        }
    }
}
