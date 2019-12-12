package entity;

public enum EnumMarca 
{ CHEVROLET, FIAT, FORD, HONDA, HYUNDAI, VW;
	public String getMarca() 
	{
		switch(this) 
		{
			case CHEVROLET: return "CHEVROLET";
			case FIAT: return "FIAT";
			case FORD: return "FORD";
			case HONDA: return "HONDA";
			case HYUNDAI: return "HYUNDAI";
			case VW: return "VW";
			default: return"";
		}
	}
}

