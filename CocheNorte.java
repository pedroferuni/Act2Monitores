package monitores;

import java.util.Random;

import monitores.Puente;

public class CocheNorte  extends Thread {
	private Puente Puente;
	public CocheNorte(monitores.Puente Puente)
	{
		this.Puente=Puente;
		start(); 
		
	} 
  public int numcoche()
  {
	Random rdm=new Random();
	int numcoche=rdm.nextInt(100-1)+1;		
	int tiemporecurso=rdm.nextInt(500-60+1)+60; 
	
	try {
		sleep (tiemporecurso);
	}catch (InterruptedException e)
	{
		e.printStackTrace();
	}
	return numcoche;
	
  }
public void run()
{
	while(true)
	{
		int numcoche=numcoche();
		System.out.println("norte");
		String norte="N";
		Puente.Obtengopaso(norte,numcoche);
		Puente.pull(norte);		
		
	}
}
}
