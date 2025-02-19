package objects;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class Equipo {
	private int id;
	private String nombre;

	// Constructor
	public Equipo(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Getters
	public int getId() { return id; }

	public String getNombre() { return nombre; }

	// ToString
	@Override
	public String toString() {
		return "Equipo{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
