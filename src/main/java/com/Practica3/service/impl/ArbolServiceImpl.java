package com.Practica3.service.impl;

import com.Practica3.dao.ArbolDao;
import com.Practica3.domain.Arbol;
import com.Practica3.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    public List<Arbol> getArboles(boolean activos) {
        return arbolDao.findAll(); // puedes filtrar si se necesita
    }

    @Override
    public void guardar(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    public void eliminar(Arbol arbol) {
        arbolDao.delete(arbol);
    }

    @Override
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }
}