/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import Candidate.Intern_candidate;
import Candidate.Intern_candidateDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thienlh
 */
public class AddInternCandidate extends HttpServlet {

    private final String invalidPage = "invalid.html";
    private final String succeedPage = "succeed.html";

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
            //  Get parameters
            String firstName = request.getParameter("txtFirstName");
            String lastName = request.getParameter("txtLastName");
            int birthDate = Integer.parseInt(request.getParameter("txtBirthDate"));
            String address = request.getParameter("txtAddress");
            int phone = Integer.parseInt(request.getParameter("txtPhone"));
            String email = request.getParameter("txtEmail");
            String majors = request.getParameter("txtMajors");
            String semester = request.getParameter("txtSemester");
            String universityName = request.getParameter("txtUniversityname");

            String button = request.getParameter("btAction");

            if (button.equals("Submit")) {
                //  Create DAO and add
                Intern_candidateDAO dao = new Intern_candidateDAO();
                dao.add(new Intern_candidate(firstName, lastName, birthDate, address, phone, email, 2, majors, semester, universityName));
                response.sendRedirect(succeedPage);
            }
        } catch (IOException e) {
            System.out.println("Error while adding data to database!" + e.getMessage());
            response.sendRedirect(invalidPage);
        } catch (NumberFormatException e) {
            System.out.println("Error while parsing number!" + e.getMessage());
            response.sendRedirect(invalidPage);
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
