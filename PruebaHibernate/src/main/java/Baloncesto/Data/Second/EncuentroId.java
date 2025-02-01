package Baloncesto.Data.Second;

import java.util.Date;

/**
 * Autor: Daniel Guirao Coronado
 */
public class EncuentroId {
	protected int equipoCasa;
	protected int equipoVisitante;
	protected Date fecha;

	public EncuentroId() {

	}

	public EncuentroId(int equipoCasa, int equipoVisitante, Date fecha) {
		this.equipoCasa = equipoCasa;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof EncuentroId) {
			EncuentroId encuentroId = (EncuentroId) object;
			return this.equipoCasa == encuentroId.equipoCasa &&
					this.equipoVisitante == encuentroId.equipoVisitante &&
					this.fecha.equals(encuentroId.fecha);
		} else {
			return false;
		}
	}
}
