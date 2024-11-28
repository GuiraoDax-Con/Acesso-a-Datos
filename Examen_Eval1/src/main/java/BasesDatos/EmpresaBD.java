/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BasesDatos;
import Entidades.Empleado;
import Entidades.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author educarm
 */
public class EmpresaBD {
	private static final String URL = "jdbc:mysql://localhost:3306/empresa";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	// Colores
	public static final String ANSI_RED = "\u001B[31m"; // Cambiára el color del print a rojo.
	public static final String ANSI_GREEN = "\u001B[32m"; // Cambiára el color del print a verge.
	public static final String ANSI_RESET = "\u001B[0m"; // Cambiára el color del print a blanco.


	public void insertaEmpleados(List<Empleado> empleados) {
		String sql = "INSERT INTO empleado (id, nombre, oficio, fecha_alta, salario, comision, departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);

			for (Empleado empleado : empleados) {
				pstmt.setInt(1, empleado.getId());
				pstmt.setString(2, empleado.getNombre());
				pstmt.setString(3, empleado.getOficio());
				pstmt.setDate(4, empleado.getFecha_alt());
				pstmt.setFloat(5, empleado.getSalario());
				pstmt.setFloat(6, empleado.getComision());
				pstmt.setInt(7, empleado.getIdDepartamento());

				pstmt.addBatch();
			}

			pstmt.executeUpdate();
			conn.commit();
			System.out.println(ANSI_GREEN +"Edificio AÑADIDO con éxito." + ANSI_RESET);
		} catch (Exception e) {
			System.err.println(ANSI_RED + "Error al INSERTAR el usuario: " + e.getMessage() + ANSI_RESET);
		}
	}


	public void modificaTablaDepartamento() {
		// Añadir la tabla jefe tipo integer a la tabla departamento
		String sql1 = "ALTER TABLE departamento ADD COLUMN jefe INTEGER";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql1)) {

			pstmt.executeUpdate();
			System.out.println(ANSI_GREEN + "Columna \"jefe\" AÑADIDA con éxito." + ANSI_RESET);

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al MODIFICAR la tabla departamento: " + e.getMessage() + ANSI_RESET);
		}

		// Añadir clave foranea de jefe a id de empleado
		String sql2 = "ALTER TABLE departamento ADD CONSTRAINT fk_jefe FOREIGN KEY (jefe) REFERENCES empleado(id)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql2)) {

			pstmt.executeUpdate();
			System.out.println(ANSI_GREEN + "Clave foránea \"fk_jefe\" AÑADIDA con éxito." + ANSI_RESET);

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al MODIFICAR la tabla departamento: " + e.getMessage() + ANSI_RESET);
		}
	}



	public boolean intercambiaDepartamento(int idEmpleado1, int idEmpleado2) {
		if (isJefe(idEmpleado1) || isJefe(idEmpleado2)) {
			System.out.println(ANSI_RED + "No se puede INTERCAMBIAR el departamento de un JEFE." + ANSI_RESET);
			return false;
		}

		int idDepartamentoEmpleado1 = obtenerIdDepartamento(idEmpleado1);
		int idDepartamentoEmpleado2 = obtenerIdDepartamento(idEmpleado2);


		String sql = "UPDATE empleado SET departamento = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);

			// Actualizar empleado 1
			pstmt.setInt(1, idDepartamentoEmpleado2);
			pstmt.setInt(2, idEmpleado1);
			pstmt.executeUpdate();

			// Actualizar empleado 2
			pstmt.setInt(1, idDepartamentoEmpleado1);
			pstmt.setInt(2, idEmpleado2);
			pstmt.executeQuery();

			conn.commit();
			System.out.println(ANSI_GREEN + "Empleado 1 y 2 INTERCAMBIADOS con éxito." + ANSI_RESET);

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al INTERCAMBIAR DEPARTAMENTO: " + e.getMessage() + ANSI_RESET);
		}

		return false;
	}
	private int obtenerIdDepartamento(int idEmpleado) {
		String sql = "SELECT departamento FROM empleado WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idEmpleado);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("departamento");
			}

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al OBTENER ID DEPARTAMENTO: " + e.getMessage() + ANSI_RESET);
		}

		return -1;
	}
	private boolean isJefe(int idEmpleado) {
		String sql = "SELECT jefe FROM departamento WHERE jefe = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idEmpleado);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al OBTENER JEFE: " + e.getMessage() + ANSI_RESET);
		}

		return false;

	}



	public void imprimeMediaSalarioLocalidad() {
		List<Empleado> empleados = obtenerEmpleados();
		List<Departamento> departamentos = obtenerDepartamentos();
		List<String> localidades = obtenerLocalidades(departamentos);

		System.out.println("LOCALIDAD \t SALARIO");
		for (String localidad : localidades) {
			float sumaSalarios = 0;
			int contador = 0;
			for (Empleado empleado : empleados) {
				for (Departamento departamento : departamentos) {
					if (empleado.getIdDepartamento() == departamento.getId()
							&& departamento.getLocalidad().equals(localidad)) {

						sumaSalarios += empleado.getSalario();
						contador++;
					}
				}
			}

			float media = sumaSalarios / contador;
			System.out.println(localidad.toUpperCase() + "\t" + media);
		}
	}
	private List<Empleado> obtenerEmpleados() {
		List<Empleado> empleados = new ArrayList<>();
		String sql = "SELECT * FROM empleado";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("oficio"),
						rs.getDate("fecha_alta"),
						rs.getFloat("salario"),
						rs.getFloat("comision"),
						rs.getInt("departamento"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al OBTENER EMPLEADO: " + e.getMessage() + ANSI_RESET);
		}
		return empleados;
	}
	private List<Departamento> obtenerDepartamentos() {
		List<Departamento> departamentos = new ArrayList<>();
		String sql = "SELECT * FROM departamento";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql);

			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Departamento departamento = new Departamento(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("localidad"),
						rs.getInt("jefe")
				);
				departamentos.add(departamento);
			}

		} catch (SQLException e) {
			System.err.println(ANSI_RED + "Error al OBTENER DEPARTAMENTOS: " + e.getMessage() + ANSI_RESET);
		}
		return departamentos;
	}
	private List<String> obtenerLocalidades(List<Departamento> departamentos) {
		List<String> localidades = new ArrayList<>();
		for (Departamento departamento : departamentos) {
			if (!localidades.contains(departamento.getLocalidad())) {
				localidades.add(departamento.getLocalidad());
			}
		}
		return localidades;
	}
}
