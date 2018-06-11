package pkgControle;

import DAOs.DAOStatus;
import Entidades.Status;
import java.io.IOException;
import java.util.List;
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
public class Listar extends HttpServlet {

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
       
        DAOStatus daoStatus = new DAOStatus();
        List<Status> listaStatus = daoStatus.list();
        
        String texto = "";
        for (int i = 0; i < listaStatus.size(); i++) {
            texto+=listaStatus.get(i).getNomeStatus()+"<br>";
        }
      
        //    response.sendRedirect("Resposta.jsp?imc="+String.valueOf(imc));      
        //enviar para Resposta.jsp
        request.setAttribute("listaComStatus", String.valueOf(texto));
       

        try {
            request.getRequestDispatcher("Resposta.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
        // response.sendRedirect("Resposta.jsp);      
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
