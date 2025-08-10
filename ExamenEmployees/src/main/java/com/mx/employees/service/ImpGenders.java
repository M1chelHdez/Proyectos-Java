package com.mx.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.employees.dao.GenderDao;

@Service
public class ImpGenders {
	@Autowired
	GenderDao genderDao;
	
	public boolean buscar(int id) {
		return genderDao.existsById(id);
	}
}
