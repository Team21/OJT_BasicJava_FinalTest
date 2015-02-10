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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.Candidate.Experience_candidate;
import sample.Candidate.Experience_candidateDAO;

/**
 *
 * @author thienlh
 */
public class AddExperienceCandidate extends HttpServlet {
    //  Pages for redirect
    private final String invalidPage = "invalid.html";
    private final String succeedPage = "succeed.html";
    private final int candidateType = 0;    //  Type of candidate

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

        out.println("<h1>Add new Exprience Candidate</h1></br>");
        try {
            //  Get parameters
            String firstName = request.getParameter("txtFirstName");
            String lastName = request.getParameter("txtLastName");
            int birthDate = Integer.parseInt(request.getParameter("txtBirthDate"));
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            int expInYear = Integer.parseInt(request.getParameter("txtExpInYear"));
            String proSkill = request.getParameter("txtProSkill");
            //  Get action
            String button = request.getParameter("btAction");
            //  Check action
            if (button.equals("Submit")) {  //  Add new candidate
                //  Create DAO and add
                Experience_candidateDAO dao = new Experience_candidateDAO();
                Experience_candidate ec = new Experience_candidate(firstName, lastName, birthDate, address, phone, email, candidateType, expInYear, proSkill);
                if (ec.isValid()) {
                    dao.add(ec);
                    response.sendRedirect(succeedPage);
                } else {
                    throw new NumberFormatException("Invalid info!");
                }
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
