package com.Practica3.controller;

import com.Practica3.domain.Arbol;
import com.Practica3.service.ArbolService;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var arboles = arbolService.getArboles(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                String nombreImagen = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreImagen);
                Files.write(rutaCompleta, imagen.getBytes());
                arbol.setRutaImagen("/images/" + nombreImagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        arbolService.guardar(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminar(@PathVariable("idArbol") Long idArbol) {
        var arbol = new Arbol();
        arbol.setIdArbol(idArbol);
        arbolService.eliminar(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String modificar(@PathVariable("idArbol") Long idArbol, Model model) {
        var arbol = new Arbol();
        arbol.setIdArbol(idArbol);
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}
