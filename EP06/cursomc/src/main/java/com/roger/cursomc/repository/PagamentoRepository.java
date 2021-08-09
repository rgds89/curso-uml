package com.roger.cursomc.repository;

import com.roger.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
}
