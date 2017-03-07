package entities;

import java.util.Date;

public abstract class AbstractEntity implements IEntity{
	protected long id;
	protected Date dateInsertion;
	protected String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatInsercao() {
		return datInsercao;
	}

	public void setDatInsercao(Date datInsercao) {
		this.datInsercao = datInsercao;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
