package com.ajmpcode.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajmpcode.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
