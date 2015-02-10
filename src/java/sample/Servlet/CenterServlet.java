/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/

package sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thienle
 */
public class CenterServlet extends HttpServlet {
    //  Pages for redirect
    private final String internCandidateInput = "internCandidateInput.html";
    private final String fresherCandidateInput = "fresherCandidateInput.html";
    private final String experienceCandidateInput = "experienceCandidateInput.html";
    private final String recruitmentServlet = "RecruitmentServlet";
   
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //  Get parameters and action
            String button = request.getParameter("btAction");
            String candidateType = request.getParameter("ddlCandidateType");
            //  Check action and redirect
            if (button.equals("Select")) {  //  Add new candidate
                if (candidateType.equals("Experience Candidate")) {
                    response.sendRedirect(experienceCandidateInput);
                } else if (candidateType.equals("Fresher Candidate"))    {
                    response.sendRedirect(fresherCandidateInput);
                } else if (candidateType.equals("Intern Candidate"))    {
                    response.sendRedirect(internCandidateInput);
                }
            }
            //  Recruit
            if (button.equals("Recruit")) {
                RequestDispatcher rd = request.getRequestDispatcher(recruitmentServlet);
                rd.forward(request, response);
            }
        } finally {
            out.close();
        }
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
