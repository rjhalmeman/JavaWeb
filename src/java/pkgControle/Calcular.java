package pkgControle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author radames
 */
public class Calcular extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double p = Double.valueOf(request.getParameter("peso"));
        double a = Double.valueOf(request.getParameter("altura"));
        double imc = p / (a * a);

        String situacao;
        if (imc < 18.5) {
            situacao = "abaixo do peso ideal";
        } else if (imc < 24.9) {
            situacao = "peso ideal";
        } else if (imc < 29.9) {
            situacao = "sobre peso";
        } else if (imc < 34.9) {
            situacao = "Obesidade grau I";
        } else if (imc < 39.9) {
            situacao = "Obesidade grau II";
        } else {
            situacao = "Obesidade grau III";
        }

        //    response.sendRedirect("Resposta.jsp?imc="+String.valueOf(imc));      
        //enviar para Resposta.jsp
        request.setAttribute("peso", String.valueOf(p));
        request.setAttribute("altura", String.valueOf(a));
        request.setAttribute("imc", String.valueOf(imc));
        request.setAttribute("situacao", situacao);

        try {
            request.getRequestDispatcher("Resposta.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(Calcular.class.getName()).log(Level.SEVERE, null, ex);
        }
        // response.sendRedirect("Resposta.jsp);      

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
