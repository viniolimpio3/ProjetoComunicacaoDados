package com.fesa.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fesa.model.OndaDenteDeSerra;
import com.fesa.model.OndaQuadrada;
import com.fesa.model.Onda;
import com.fesa.model.OndaSenoidalRetificada;
import com.fesa.model.OndaTriangular;

public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{ 
            
            // Recuperar o tipo de canal escolhido pelo usuário
            String tipoCanal = request.getParameter("tipoCanal");
            String tipoOnda = request.getParameter("tipoOnda");

            ObjectMapper om = new ObjectMapper();

            System.out.println(tipoOnda);
            Onda ondaEntrada = null;
            switch (tipoOnda) {
                case "triangular" ->
                    ondaEntrada = new OndaTriangular();
                case "dente-serra" ->
                    ondaEntrada = new OndaDenteDeSerra();
                case "senoidal-retificada" ->
                    ondaEntrada = new OndaSenoidalRetificada();
                case "quadrada" ->
                    ondaEntrada = new OndaQuadrada();
            }

            if (ondaEntrada == null) 
                throw new Exception("Tipo de Onda inválida!");
                                    
            ondaEntrada.setFrequenciaFundamental(Integer.parseInt(request.getParameter("frequenciaFundamental")));

            String emitido = om.writeValueAsString(ondaEntrada.calcOndaEmitida());

            request.setAttribute("emitido", emitido);
            System.out.println(emitido);

            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
            rd.forward(request, response);
        } catch(Exception ex){
            System.out.println(ex);
            request.setAttribute("message", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/error.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
