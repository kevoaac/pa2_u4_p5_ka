package com.uce.edu.controller;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// PATH: http://localhost:8085/personas

// DB        Service         Controlador
// TABLAS -> EntitiManager -> Recurso
@Controller
@RequestMapping("/personas") // en plural
public class PersonaController {
    @Autowired
    private IPersonaService iPersonaService;

    // Los métodos también deben tener parte del path
    // PATH: http://localhost:8085/personas/buscar
    @GetMapping("/buscar") // PATH GET
    public String buscarPorCedula(String cedula) {

        return "";
    }

    @GetMapping("/buscarTodos")
    public String buscarTodos(Model modelo){
        // Al método que va a enviar un modelo necesita en los argumentos la clase model
        List<Persona > lista = this.iPersonaService.consultarTodos();
        // Envio de la lista ("identificador", atributo)
        modelo.addAttribute("personas", lista);
        return "vistaListaPersonas";
    }


    @PutMapping("/actualizar")
    public String actualizar() {
        return "";
    }

    @DeleteMapping("/borrar")
    public String borrar() {
        return "";
    }

    @PostMapping
    public String guardar(){
        return "";
    }


}
