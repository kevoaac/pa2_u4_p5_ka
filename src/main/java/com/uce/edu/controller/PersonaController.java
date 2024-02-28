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
    // El modelo viaja en el response
    @GetMapping("/buscarTodos")
    public String buscarTodos(Model modelo) {
        // Al método que va a enviar un modelo necesita en los argumentos la clase model
        List<Persona> lista = this.iPersonaService.consultarTodos();
        // Envio de la lista ("identificador", atributo)
        modelo.addAttribute("personas", lista);

        return "vistaListaPersonas";
    }

    // GET
    // Recibimos el id(cedula) a travez del path
    // PATH: http://localhost:8085/personas/buscarPorCedula/0402068
    @GetMapping("/buscarPorCedula/{cedulaPersona}")
    public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
        Persona persona = this.iPersonaService.consultarPorCedula(cedula);
        modelo.addAttribute("persona", persona);
        return "vistaPersona";
    }

    // Cuando viaja el modelo en el request
    @PutMapping("/actualizar/{cedulaPersona}")
    public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) {
        Persona perAux = this.iPersonaService.consultarPorCedula(cedula);
        perAux.setApellido(persona.getApellido());
        perAux.setNombre(persona.getNombre());
        perAux.setCedula(persona.getCedula());
        perAux.setGenero(persona.getGenero());

        this.iPersonaService.actualizar(perAux);
        return "redirect:/personas/buscarTodos";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        this.iPersonaService.guardar(persona);
        return "redirect:/personas/buscarTodos";
    }

//    @PostMapping("/guardar")
//    public String guardar(InventarioTo inv) {
//        this.iPersonaService.guardar(persona);
//        return "redirect:/personas/buscarTodos";
//    }

    // Cuando voy a insertar primero debo mostrar alguna pagina GET, luego cuando insertemos mediente un botón haremos el POST
    @GetMapping("/nuevaPersona")
    public String mostrarNuevaPersona(Model model) {
        // Forma 1: enviar una persona vacía para que no de error al mostrar los inputs : <td><input type="text" th:field="${persona.nombre}"></td>
        model.addAttribute("persona", new Persona());
        return "vistaNuevaPersona";
    }

    @DeleteMapping("/borrar/{cedula}")
    public String borrar(@PathVariable("cedula") String cedula) {
        this.iPersonaService.borrarPorCedula(cedula);
        return "redirect:/personas/buscarTodos";
    }


}
