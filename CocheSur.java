package monitores;

import java.util.Random;

public class CocheSur extends Thread {
	private Puente Puente;
	public CocheSur(monitores.Puente Puente)
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
			System.out.println("sur");
			String sur="S";
			Puente.Obtengopaso(sur,numcoche);
			Puente.pull(sur);	
			
		}
	}
}


