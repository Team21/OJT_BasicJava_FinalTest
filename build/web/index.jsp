<%-- 
    Document   : index
    Created on : Oct 7, 2014, 2:32:34 AM
    Author     : thienle
--%>

<%@page import="sample.Recruitment.Recruitment"%>
<%@page import="sample.Candidate.Candidate"%>
<%@page import="java.util.List"%>
<%@page import="sample.Recruitment.RecruitmentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recruitment Page</title>
    </head>
    <body>
        <h1>Requirement 1: Add new candidate</h1>
        <form action="CenterServlet" method="POST">
            Choose a candidate type: <select name="ddlCandidateType">
                <option>Experience Candidate</option>
                <option>Fresher Candidate</option>
                <option>Intern Candidate</option>
            </select><br/><br/>
            <input type="submit" value="Select" name="btAction" />
        </form>
        </br>
        <h1>Requirement 2: Recruit a candidate</h1>
        <h4>1. Select a candidate</h4>
        <%
            RecruitmentDAO dao = new RecruitmentDAO();

            List<Candidate> candidates = dao.getCandidateList();
            request.setAttribute("CANDIDATES", candidates);

            List<Recruitment> recruitments = dao.getRecruitmentList();
            request.setAttribute("RECRUITMENTS", recruitments);
        %>
        <form action="CenterServlet">
            <table border="1">
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Candidate ID</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Candidate type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="candidate" items="${requestScope.CANDIDATES}">
                        <tr>
                            <td>
                                <input type="radio" name="rbCandidate" value="${candidate.getCandidate_type()}" />
                            </td>
                            <td>${candidate.getId()}</td>
                            <td>${candidate.getFirstName()}</td>
                            <td>${candidate.getLastName()}</td>
                            <td>${candidate.getCandidate_type()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </br>
            <h4>2. Select an available recruitment program</h4>
            <table border="1">
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Recruitment code</th>
                        <th>Position</th>
                        <th>Package</th>
                        <th>Participant</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="recruitment" items="${requestScope.RECRUITMENTS}">
                        <tr>
                            <td>
                                <input type="radio" name="rbRecruitment" value="${recruitment.getRecruitmentPackage()}" />
                            </td>
                            <td>${recruitment.getRecruitmentCode()}</td>
                            <td>${recruitment.getPosition()}</td>
                            <td>${recruitment.getRecruitmentPackage()}</td>
                            <td>${recruitment.getParticipant()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </br>
            <input type="submit" value="Recruit" name="btAction" />
        </form>
    </body>
</html>
