package entities;

public class TipoProducao extends AbstractEntity {
	private TipoEstoque tipoEstoque;

	public TipoEstoque getTipoEstoque() {
		return tipoEstoque;
	}

	public void setTipoEstoque(TipoEstoque tipoEstoque) {
		this.tipoEstoque = tipoEstoque;
	}
}
