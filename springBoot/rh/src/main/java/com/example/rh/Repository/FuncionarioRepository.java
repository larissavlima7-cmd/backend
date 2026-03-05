package com.example.rh.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.rh.Model.Funcionario;
import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
    //metodos para realzar o crud do Funcionario
    //criar uma busca pela chave primaria do Funcionario
    Funcionario findById (long id);

    //busca pelo nome
    Funcionario findById (String nome);

    //Busca para vários nomes// Não existe no JPA
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<Funcionario> findByNomes(String nome);



}