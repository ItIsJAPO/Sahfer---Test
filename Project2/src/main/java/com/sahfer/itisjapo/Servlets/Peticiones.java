package com.sahfer.itisjapo.Servlets;

import com.sahfer.itisjapo.Util.Variables;
import com.sahfer.itisjapo.dao.PersonaDao;
import com.sahfer.itisjapo.entity.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


public class Peticiones extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(Peticiones.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Persona persona = new Persona();
        Date fecha_nacimiento;

        persona.setIdPersona(UUID.randomUUID().toString());
        persona.setNombre(request.getParameter(Variables.NOMBRE) != null ? request.getParameter(Variables.NOMBRE) : "");
        persona.setApellidoPaterno(request.getParameter(Variables.APELLIDOP) != null ? request.getParameter(Variables.APELLIDOP) : "");
        persona.setApellidoMaterno(request.getParameter(Variables.APELLIDOM) != null ? request.getParameter(Variables.APELLIDOM) : "");
        persona.setCorreoElectronico(request.getParameter(Variables.CORREO_ELECTRONICO) != null ? request.getParameter(Variables.CORREO_ELECTRONICO) : "");
        persona.setUser(request.getParameter(Variables.USER) != null ? request.getParameter(Variables.USER) : "");
        persona.setPassword(request.getParameter(Variables.PASSWORD) != null ? request.getParameter(Variables.PASSWORD) : "");


        persona.setFechaNacimiento(new Date());

        HttpSession session = request.getSession();
        try {
            new PersonaDao().guardarPersona(persona);
            Persona persona2 = new PersonaDao().getPersonaByID(persona.getIdPersona());
            session.setAttribute(Variables.PERSONA2, persona2);
            session.setAttribute(Variables.RESULTADO, Variables.UserStatus.OK.toString());
        } catch (Exception e) {
            log.error("Error al procesar el guardado o recuperacion", e);
            session.setAttribute(Variables.RESULTADO, Variables.UserStatus.KO.toString());
        }

         response.sendRedirect("resultado.jsp");

    }
}
