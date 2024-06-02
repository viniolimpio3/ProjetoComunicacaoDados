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
import com.fesa.model.canal.Canal;
import com.fesa.model.canal.CanalPassaBaixa;
import com.fesa.model.canal.CanalPassaFaixa;
import com.fesa.model.onda.OndaDenteDeSerra;
import com.fesa.model.onda.OndaQuadrada;
import com.fesa.model.onda.Onda;
import com.fesa.model.onda.OndaSenoidalRetificada;
import com.fesa.model.onda.OndaTriangular;

public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{ 
            
            // Recuperar o tipo de canal escolhido pelo usuário
            String tipoCanal = request.getParameter("tipoCanal");
            String tipoOnda = request.getParameter("tipoOnda");
            
            int frequenciaInicial = Integer.parseInt(request.getParameter("frequenciaInicial"));
            int frequenciaFinal = tipoCanal.equals("bx") ? 0 : Integer.parseInt(request.getParameter("frequenciaFinal"));
            int frequenciaFundamental = Integer.parseInt(request.getParameter("frequenciaFundamental"));
            
            
            if(tipoCanal.equals("fx") && frequenciaFinal <= frequenciaInicial)
                throw new Exception("A frequência final deve ser maior que a frequência inicial!");
            
            if(frequenciaInicial == 0 || frequenciaFundamental == 0 || (tipoCanal.equals("bx") && frequenciaFundamental == 0))
                throw new Exception("As frequências não podem ser zero!");
            
            request.setAttribute("tipoCanal", tipoCanal);
            request.setAttribute("tipoOnda", tipoOnda);
            request.setAttribute("frequenciaFundamental", frequenciaFundamental);
            request.setAttribute("frequenciaInicial", frequenciaInicial);
            request.setAttribute("frequenciaFinal", frequenciaFinal);

            ObjectMapper om = new ObjectMapper();
            
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
            
            Canal canal = null;
            switch (tipoCanal) {
                case "fx" ->
                    canal = new CanalPassaFaixa(frequenciaInicial, frequenciaFinal);
                case "bx" ->
                    canal = new CanalPassaBaixa(frequenciaInicial);
            }
            
            if (canal == null) 
                throw new Exception("Tipo de Canal inválido!");
            
            ondaEntrada.setFrequenciaFundamental(frequenciaFundamental);

            String emitido = om.writeValueAsString(ondaEntrada.calcOndaEmitida());
            String faseEntrada = om.writeValueAsString(ondaEntrada.getFase());
            String espectroAmplitudeEntrada = om.writeValueAsString(ondaEntrada.getAn());
            String moduloCanal = om.writeValueAsString(canal.calcModuloFreqCanal());
            String faseCanal = om.writeValueAsString(canal.calcFaseCanal());
            String amplitudeSaida = om.writeValueAsString(ondaEntrada.calcAmplitudeSaida(canal));
            String faseSaida = om.writeValueAsString(ondaEntrada.calcFaseSaida(canal));
            
            request.setAttribute("emitido", emitido);
            request.setAttribute("jsonFaseEntrada", faseEntrada);
            request.setAttribute("espectroAmplitudeEntrada", espectroAmplitudeEntrada);
            request.setAttribute("moduloCanal", moduloCanal);
            request.setAttribute("faseCanal", faseCanal);
            request.setAttribute("amplitudeSaida", amplitudeSaida);
            request.setAttribute("faseSaida", faseSaida);

            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
            rd.forward(request, response);
        } catch(Exception ex){
            System.out.println(ex);
            request.setAttribute("message", "Erro: " + ex.getMessage());
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
