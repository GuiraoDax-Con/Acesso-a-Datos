package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	private static final String URI = "mongodb://localhost:27017"; // Cambia si es necesario
	private static final String DATABASE_NAME = "Baloncesto";

	private static MongoClient mongoClient;
	private static MongoDatabase database;

	// Método para conectar a MongoDB
	public static MongoDatabase getDatabase() {
		if (mongoClient == null) {
			mongoClient = MongoClients.create(URI);
			database = mongoClient.getDatabase(DATABASE_NAME);
			System.out.println("✅ Conectado a MongoDB ヾ(≧▽≦*)o");
		} else {
			System.out.println("❌ Conexión a MongoDB ya establecida ¯\\_( ͡° ͜ʖ ͡°)_/¯");
			}
		return database;
	}

	// Método para cerrar conexión
	public static void closeConnection() {
		if (mongoClient != null) {
			mongoClient.close();
		}

		System.out.println("🔴 Conexión a MongoDB cerrada. ┌(。Д。)┐");
	}
}
