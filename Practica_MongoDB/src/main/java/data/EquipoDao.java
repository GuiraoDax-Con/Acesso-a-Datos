package data;

import objects.Equipo;
import org.bson.Document;

public class EquipoDao extends MongoDBDao<Equipo, Integer> {

	public EquipoDao() {
		super("Equipos");
	}

	@Override
	protected Document toDocument(Equipo equipo) {
		return new Document("_id", equipo.getId())
				.append("nombre_equipo", equipo.getNombre());
	}

	@Override
	protected Equipo fromDocument(Document doc) {
		return new Equipo(doc.getInteger("_id"), doc.getString("nombre_equipo"));
	}

	@Override
	protected Integer getId(Equipo equipo) {
		return equipo.getId();
	}
}

