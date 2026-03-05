package com.example.escola_xyz.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.escola_xyz.model.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm,String>{
    VerificaCadastroAdm findByCpf(String cpf);
}
