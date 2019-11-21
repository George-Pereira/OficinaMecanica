package entity;

public class Veiculo 
{
	private long id;
	private int anoFabrica;
	private String chassis;
	private double motor;
	private Cor cor;
	private String placa;
	private Modelo model;
	private Marca marca;
	private String desc;
	private Historico hist;
	
	public Veiculo(int anoFabrica, String chassis, double motor, Cor cor, String placa, Modelo model, Marca marca, String desc) 
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
	public Cor getCor() 
	{
		return cor;
	}
	public void setCor(Cor cor) 
	{
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
	public Modelo getModel() {
		return model;
	}
	public void setModel(Modelo model) {
		this.model = model;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setMarca(Modelo model) {
		// TODO Auto-generated method stub
		
	}
}
