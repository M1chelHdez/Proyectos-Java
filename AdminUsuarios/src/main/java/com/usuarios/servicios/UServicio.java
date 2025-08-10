package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.usuarios.entidad.Usuario;
import com.usuarios.repositorio.URepo;

@Service
public class UServicio {

	private URepo repo;

	public UServicio(URepo repo){
		this.repo = repo;
	}

	public void addEmp(Usuario u) {
		repo.save(u);
	}

	public List<Usuario> getAll() {
		return repo.findAll();
	}

	public Usuario getById(int id) {
		Optional<Usuario> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public Page<Usuario> getByPaginate(Pageable pageable) {
		return repo.findAll(pageable);
	}
	

}
