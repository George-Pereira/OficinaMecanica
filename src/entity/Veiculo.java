package entity;

public class Veiculo 
{
	private long id;
	private int anoFabrica;
	private String chassis;
	private double motor;
	private Cor cor;
	private String placa;
	private Long model;
	private Long marca;
	private String desc;
	private Historico hist;
	
	public Veiculo(int anoFabrica, String chassis, double motor, Cor cor, String placa, long model, long marca, String desc) 
	{
		this.anoFabrica = anoFabrica;
		this.chassis = chassis;
		this.motor = motor;
		this.cor = cor;
		this.placa = placa;
		this.desc = desc;
		this.model = model;
		this.marca = marca;
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
	public long getModel() {
		return model;
	}
	public void setModel(long model) {
		this.model = model;
	}
	public long getMarca() {
		return marca;
	}
	public void setMarca(long marca) {
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
}
