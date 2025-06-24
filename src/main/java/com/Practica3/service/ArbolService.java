package com.Practica3.service;

import com.Practica3.domain.Arbol;
import java.util.List;

public interface ArbolService {
    public List<Arbol> getArboles(boolean activos);
    public void guardar(Arbol arbol);
    public void eliminar(Arbol arbol);
    public Arbol getArbol(Arbol arbol);
}