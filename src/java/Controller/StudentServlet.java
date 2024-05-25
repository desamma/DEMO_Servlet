/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lethimcook
 */
public class StudentServlet extends HttpServlet {

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
         String numStudentsStr = request.getParameter("numStudents");
        int numStudents = Integer.parseInt(numStudentsStr);
        List<Student> students = getSampleStudents();

        if (numStudents > students.size()) {
            numStudents = students.size();
        }
// praise the sublisttttttttttttttttttttttttttttttttttttttttttttttttttttttttt
        List<Student> limitedStudents = students.subList(0, numStudents);

        request.setAttribute("students", limitedStudents);
        request.setAttribute("numStudents", numStudents);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    private List<Student> getSampleStudents() {
        List<Student> students = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            students.add(new Student(1, "Abvc", true, sdf.parse("13-11-1988")));
            students.add(new Student(2, "Cdkxf", false, sdf.parse("2-3-1972")));
            students.add(new Student(3, "GASEGD", true, sdf.parse("1-6-1934")));
            students.add(new Student(4, "FDCDas", true, sdf.parse("23-8-1976")));
            students.add(new Student(5, "Sgeage", true, sdf.parse("9-3-2014")));
            students.add(new Student(6, "agina", false, sdf.parse("3-5-1972")));
            students.add(new Student(7, "fasfVc", true, sdf.parse("2-4-1977")));
            students.add(new Student(8, "Xfargh", false, sdf.parse("15-12-1989")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return students;
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
