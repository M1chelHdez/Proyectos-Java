package com.mx.employees.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEmployee {
	String message;
	boolean success;
	Object employees;
}
