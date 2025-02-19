package data;

import objects.Jugador;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import java.util.List;

public class JugadorDao extends MongoDBDao<Jugador, Integer> {

	public JugadorDao() {
		super("Jugadores");
	}

	// Método adicional: Buscar jugadores por equipo
	public List<Jugador> findByEquipo(int equipoId) {
		return collection.find(Filters.eq("equipo_id", equipoId))
				.map(this::fromDocument).into(new java.util.ArrayList<>());
	}

	@Override
	protected Document toDocument(Jugador jugador) {
		return new Document("_id", jugador.getId())
				.append("nombre", jugador.getNombre())
				.append("puesto", jugador.getPuesto())
				.append("estatura", jugador.getEstatura())
				.append("equipo_id", jugador.getEquipoId());
	}

	@Override
	protected Jugador fromDocument(Document doc) {
		return new Jugador(
				doc.getInteger("_id"),
				doc.getString("nombre"),
				doc.getString("puesto"),
				doc.getInteger("estatura"),
				doc.getInteger("equipo_id")
		);
	}

	@Override
	protected Integer getId(Jugador jugador) {
		return jugador.getId();
	}
}


