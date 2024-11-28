/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package zip;
import Ficheros.Ficheros;
import Entidades.Empleado;

/*
 * import es.ad.examen1.bbdd.EmpresaBD;
 * import es.ad.examen1.ficheros.Empleado;
 * import es.ad.examen1.ficheros.Ficheros;
 */
import java.util.List;

/**
 *
 * @author educarm
 */
public class AdExamen1 {

	public static void main(String[] args) {
		Ficheros ficheros = new Ficheros();

		/* Ejercicio 1 */
		//List<Empleado> empleados = ficheros.getMockEmpleado();
		List<Empleado> empleados = ficheros.getEmpleados();
		for (Empleado e : empleados) {
			System.out.println(e);
		}
        
        /*EmpresaBD empresaBD = new EmpresaBD();
        empresaBD.insertaEmpleados(empleados);
        empresaBD.modificaTablaDepartamento() ;
        if (empresaBD.intercambiaDepartamento(7369, 7782)) 
            System.out.println("Se han intercambiado los departamentos de 7369 y 7782  ¡¡¡ERROR!!!");
        else System.out.println("NO se han intercambiado los departamentos de 7369 y 7782  ¡¡¡ok!!!");

        if (empresaBD.intercambiaDepartamento(7369, 7900)) 
            System.out.println("Se han intercambiado los departamentos de 7369 y 7900 OK");
        else 
            System.out.println("NO se han intercambiado los departamentos de 7369 y 7900 ERROR!!!");

        empresaBD.imprimeMediaSalarioLocalidad();
        
        ficheros.agregarEmpleado();*/
	}
}
