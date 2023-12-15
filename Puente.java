package monitores;

import java.util.LinkedList;
import java.util.Queue;

public class Puente {
	//public final boolean cochescontrario=false;
	  
    private Queue<Integer> cochesNorte = new LinkedList<Integer>();
	private Queue<Integer> cochesSur = new LinkedList<Integer>();
  public synchronized void Obtengopaso(String lado,int idCoche)
  {
	  if (lado.equals("S"))
	  {
		  if (cochesNorte.size()!=0)
	      {
			  try {
					System.out.println("Hay coches cruzado del lado Norte");
				  wait();
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}	
			  
		  }
		  cochesSur.add(idCoche);
		  System.out.println("El sur con id"+idCoche +"puede cruzar");
		  notify();
	  }
	  else if (lado.equals("N"))
	  {
		  if (cochesSur.size()!=0)
	      {
			  try {
					System.out.println("Hay coches cruzado del lado Sur");
				  wait();
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}	
			  
		  }
		  cochesNorte.add(idCoche);
		  System.out.println("El coche norte con id"+idCoche +"puede cruzar");
		  notify();
	  }
		  
	  
  }
  public synchronized void pull(String lado)
  {
	  if (lado.equals("S"))
	  {
		  if (cochesSur.size()==0)
	      {
			  try {
					System.out.println("No hay coches cruzando del Sur");
				  wait();
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}	
			  
		  }
		  cochesSur.poll();
		  notify();
		  
	  }
	  else if (lado.equals("N"))
	  {
		  if (cochesNorte.size()==0)
	      {
			  try {
					System.out.println("No hay coche lado Norte");
				  wait();
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}	
			  
		  }
		  cochesNorte.poll();
		 notify();
	  }
  }
}
