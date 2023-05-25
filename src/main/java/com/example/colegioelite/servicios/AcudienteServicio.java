package com.example.colegioelite.servicios;

import com.example.colegioelite.entidades.Acudiente;
import com.example.colegioelite.repositorios.AcudienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AcudienteServicio implements ServicioBase<Acudiente> {

    @Autowired
    protected AcudienteRepositorio acudienteRepositorio;

    @Override
    public List<Acudiente> buscarTodos() throws Exception {
        try {
            List<Acudiente> acudientes = acudienteRepositorio.findAll();
            return acudientes;

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public Acudiente buscarporId(Integer id) throws Exception {
        try {
            Optional<Acudiente> acudienteOptional = acudienteRepositorio.findById(id);
            if (acudienteOptional.isPresent()) {
                return acudienteOptional.get();
            } else {
                throw new Exception("Usuario no encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Acudiente registrar(Acudiente datosARegistrar) throws Exception {
        try {
            Acudiente acudienteGuardado = acudienteRepositorio.save(datosARegistrar);
            return acudienteGuardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public Acudiente actualizar(Integer id, Acudiente datosNuevos) throws Exception {
        try {
            Optional<Acudiente> acudienteOptional = acudienteRepositorio.findById(id);
            if (acudienteOptional.isPresent()) {
                Acudiente acudienteExistente = acudienteOptional.get();
                acudienteExistente.setNombre(datosNuevos.getNombre());
                acudienteExistente.setTelefono(datosNuevos.getTelefono());
                Acudiente acudienteActualizado = acudienteRepositorio.save(acudienteExistente);
                return acudienteActualizado;

            } else {
                throw new Exception("Usuario no encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Acudiente> acudienteOptional = acudienteRepositorio.findById(id);
            if (acudienteOptional.isPresent()) {
                acudienteRepositorio.deleteById();
                return true
            } else {
                throw new Exception("Usuario n encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}