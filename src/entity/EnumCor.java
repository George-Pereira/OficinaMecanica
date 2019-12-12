package entity;

public enum EnumCor 
{
	PRETO, VERMELHO, AZUL, VERDE, PRATA, BRANCO, BEGE, MARROM;
	
	public String getCor() 
	{
		switch(this) 
		{
		case PRETO: return "PRETO";
		case VERMELHO: return "VERMELHO";
		case AZUL: return "AZUL";
		case VERDE: return "VERDE";
		case PRATA: return "PRATA";
		case BRANCO: return "BRANCO";
		case BEGE: return "BEGE";
		case MARROM: return "MARROM";
		default: return "";
		}
	}
}
