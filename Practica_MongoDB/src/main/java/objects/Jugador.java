package objects;

import org.bson.Document;

public class Jugador {
	private int id;
	private String nombre;
	private String puesto;
	private int estatura;
	private int equipoId;

	public Jugador(int id, String nombre, String puesto, int estatura, int equipoId) {
		this.id = id;
		this.nombre = nombre;
		this.puesto = puesto;
		this.estatura = estatura;
		this.equipoId = equipoId;
	}

	// Convertir objeto Jugador a documento BSON para MongoDB
	public Document toDocument() {
		return new Document("_id", id)
				.append("nombre", nombre)
				.append("puesto", puesto)
				.append("estatura", estatura)
				.append("equipo_id", equipoId);
	}

	// Convertir documento BSON a objeto Jugador
	public static Jugador fromDocument(Document doc) {
		return new Jugador(
				doc.getInteger("_id"),
				doc.getString("nombre"),
				doc.getString("puesto"),
				doc.getInteger("estatura"),
				doc.getInteger("equipo_id")
		);
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public int getEstatura() {
		return estatura;
	}

	public int getEquipoId() {
		return equipoId;
	}

	// ToString
	@Override
	public String toString() {
		return "Jugador{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", puesto='" + puesto + '\'' +
				", estatura=" + estatura +
				", equipoId=" + equipoId +
				'}';
	}
}
