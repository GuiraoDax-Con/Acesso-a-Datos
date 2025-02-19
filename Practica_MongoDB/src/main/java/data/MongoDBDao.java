package data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import utils.MongoDBConnection;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoDBDao<T, S> implements Dao<T, S> {
	protected MongoCollection<Document> collection;

	// Constructor genérico para manejar cualquier colección
	public MongoDBDao(String collectionName) {
		this.collection = MongoDBConnection.getDatabase().getCollection(collectionName);
	}

	@Override
	public void save(T model) {
		collection.insertOne(toDocument(model));
		System.out.println("Documento guardado en MongoDB.");
	}

	@Override
	public T read(S id) {
		Document doc = collection.find(Filters.eq("_id", id)).first();
		return (doc != null) ? fromDocument(doc) : null;
	}

	@Override
	public void update(T model) {
		collection.replaceOne(Filters.eq("_id", getId(model)), toDocument(model));
		System.out.println("Documento actualizado.");
	}

	@Override
	public void delete(S id) {
		collection.deleteOne(Filters.eq("_id", id));
		System.out.println("Documento eliminado.");
	}

	@Override
	public List<T> findAll() {
		List<T> results = new ArrayList<>();
		for (Document doc : collection.find()) {
			results.add(fromDocument(doc));
		}
		return results;
	}

	// Métodos abstractos para convertir entre objetos y documentos BSON
	protected abstract Document toDocument(T model);
	protected abstract T fromDocument(Document doc);
	protected abstract S getId(T model);
}

