package com.example.escola_xyz.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.escola_xyz.model.Administrador;

public interface AdministradorRepository extends CrudRepository< Administrador, String>{
    //se precisar criar algumm método específico de busca no banco eu crio aqui

    Administrador findByCpf(String cpf); //busca pelo cepf no banco
    
}
