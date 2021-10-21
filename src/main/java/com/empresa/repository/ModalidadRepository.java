package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;
import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {


	@Query("select m from Modalidad m where "
			
			+ "( :#{#fil.nombre} is '' or m.nombre like :#{#fil.nombre} ) and "
			+ "( :#{#fil.idDeporte} is 0  or m.deporte.idDeporte = :#{#fil.idDeporte} ) ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);
}
