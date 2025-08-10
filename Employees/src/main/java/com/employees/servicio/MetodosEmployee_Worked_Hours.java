package com.employees.servicio;

import java.util.List;

import com.employees.dominio.Employee_Worked_Hours;

public interface MetodosEmployee_Worked_Hours {

	public void guardar(Employee_Worked_Hours employee_worked_hours);

	public void editar(Employee_Worked_Hours employee_worked_hours);

	public void eliminar(Employee_Worked_Hours employee_worked_hours);

	public Employee_Worked_Hours buscar(Employee_Worked_Hours employee_worked_hours);

	public List listar();
}
