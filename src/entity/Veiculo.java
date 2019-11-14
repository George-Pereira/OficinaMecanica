package entity;

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
	private Historico hist;
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
	public void setAnoFabrica(int anoFabrica) 
	{
		if(anoFabrica > 1890) 
		{
			this.anoFabrica = anoFabrica;
		}
	}
	public String getChassis() 
	{
		return chassis;
	}
	public void setChassis(String chassis) 
	{
		if(chassis.length() == 17) 
		{
			this.chassis = chassis;
		}
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
	public void setPlaca(String placa) 
	{
		boolean alpha = true;
		boolean num = true;
		if(placa.length() == 7) 
		{
			char [] plc = placa.toCharArray();
			for(int cta = 0; cta<3;cta++) 
			{
				if(!(Character.isAlphabetic(plc[cta]))) 
				{
					alpha = false;
					break;
				}
			}
			for(int cta = 3; cta <7; cta++) 
			{
				if(!(Character.isDigit(plc[cta]))) 
				{
					num = false;
					break;
				}
			}
			if(alpha == true && num == true) 
			{
				this.placa = placa;
			}
		}
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
	public String getDesc() 
	{
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Historico getHist() {
		return hist;
	}

	public void setHist(Historico hist) {
		this.hist = hist;
	}
}
