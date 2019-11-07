package entity;

import javafx.collections.ObservableList;

public class Veiculo 
{
	private int anoFabrica;
	private String chassis;
	private double motor;
	private EnumCor cor;
	private String placa;
	private String model;
	private EnumMarca marca;
	private String desc;
	@Override
	public String toString() {
		return model;
	}
	
	public Veiculo(int anoFabrica, String chassis, double motor, EnumCor cor, String placa, String model, EnumMarca marca, String desc) 
	{
		this.anoFabrica = anoFabrica;
		this.chassis = chassis;
		this.motor = motor;
		this.cor = cor;
		this.placa = placa;
		this.setDesc(desc);
		this.model = model;
		this.setMarca(marca);
	}
	public Veiculo() 
	{
	}
	public int getAnoFabrica() 
	{
		return anoFabrica;
	}
	public void setAnoFabrica(int anoFabrica) {
		this.anoFabrica = anoFabrica;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	public String getCor() {
		return cor.getCor();
	}
	public EnumCor getCorEnum() 
	{
		return cor;
	}
	public void setCor(EnumCor cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public EnumMarca getMarcaEnum() {
		return marca;
	}
	public void setMarca(EnumMarca marca) {
		this.marca = marca;
	}
	public String getMarca() 
	{
		return marca.toString();
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
