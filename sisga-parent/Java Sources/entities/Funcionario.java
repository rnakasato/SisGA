package entities;

public class Funcionario extends PessoaFisica {
	private int numero;
	private double salario;
	private CarteiraTrabalho carteiraTrabalho;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public CarteiraTrabalho getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(CarteiraTrabalho carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

}
