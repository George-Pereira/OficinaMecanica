package entity;

public enum EnumMarca 
{ CHEVROLET, FIAT, FORD, HONDA, HYUNDAI, VW;
	public String getMarca() 
	{
		switch(this) 
		{
			case HONDA: return "HONDA";
			case FORD: return "FORD";
			case CHEVROLET: return "CHEVROLET";
			case FIAT: return "FIAT";
			case VW: return "VW";
			case HYUNDAI: return "HYUNDAI";
			default: return"";
		}
	}
}

