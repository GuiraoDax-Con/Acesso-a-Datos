import BasesDatos.EmpresaBD;
import Entidades.Empleado;
import Entidades.Pedir;
import Ficheros.Ficheros;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Main {
	public static void main(String[] args) {
		Pedir pd = new Pedir();

		System.out.println("Ejercicio 1");
		Ficheros ficheros = new Ficheros();
		List<Empleado> empleados = ficheros.getEmpleados();
		System.out.println(empleados);


		System.out.println("Ejercicio 2");
		EmpresaBD empresaBD = new EmpresaBD();
		List<Empleado> empleados2 = new ArrayList<>();

		Date fecha = pd.convertirStringASqlDate("01-01-2024");
			empleados2.add(new Empleado(1, "Daniel", "Programador", fecha, 1000, 100, 1));
			empleados2.add(new Empleado(2, "Juan", "Programador", fecha, 1000, 100, 1));
			empleados2.add(new Empleado(3, "Pedro", "Programador", fecha, 1000, 100, 1));
		empresaBD.insertaEmpleados(empleados2);

		System.out.println("Ejercicio 3");
		empresaBD.modificaTablaDepartamento();


		System.out.println("Ejercicio 4");
		empresaBD.intercambiaDepartamento(1, 2);

		System.out.println("Ejercicio 5");
		empresaBD.imprimeMediaSalarioLocalidad();

	}
}
