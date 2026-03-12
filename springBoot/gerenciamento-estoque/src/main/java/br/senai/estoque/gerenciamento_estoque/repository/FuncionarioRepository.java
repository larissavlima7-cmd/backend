package br.senai.estoque.gerenciamento_estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.estoque.gerenciamento_estoque.model.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	Optional<Funcionario> findByNif(String nif);
	boolean existsByNif(String nif);
}
