package entities;

public class Despesa {
	protected TipoItemDespesa tipoItemDespesa;
	protected TipoDespesa tipoDespesa;
	protected StatusDespesa statusDespesa;

	public TipoItemDespesa getTipoItemDespesa() {
		return tipoItemDespesa;
	}

	public void setTipoItemDespesa(TipoItemDespesa tipoItemDespesa) {
		this.tipoItemDespesa = tipoItemDespesa;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public StatusDespesa getStatusDespesa() {
		return statusDespesa;
	}

	public void setStatusDespesa(StatusDespesa statusDespesa) {
		this.statusDespesa = statusDespesa;
	}

}
