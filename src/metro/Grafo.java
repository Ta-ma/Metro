package metro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Grafo {

	Arista[] aristas;
	
	public Grafo (File arch) throws FileNotFoundException
	{
		Scanner sc = new Scanner(arch);
		int cantNodos = sc.nextInt(); // innecesario
		int cantTuneles = sc.nextInt();
		int cantPuentes = sc.nextInt();
		
		aristas = new Arista[cantTuneles + cantPuentes];
		for (int i = 0; i < cantTuneles; i++)
			aristas[i] = new Arista(sc.nextInt() - 1, sc.nextInt() - 1, 0);
		
		for (int i = cantTuneles; i < cantPuentes + cantTuneles; i++)
			aristas[i] = new Arista(sc.nextInt() - 1, sc.nextInt() - 1, 1);
		
		sc.close();
	}
	
	public void Resolver (File arch) throws IOException
	{
		System.out.println(arch.getName());
		long tInicial = System.currentTimeMillis();
		Set<Integer> v = new HashSet<Integer>();
		List<Arista> lista = new LinkedList<Arista>();
		
		int costoFinal = 0;
		
		// agrego el nodo origen de la primera arista para indicar que ya est� visitado
		v.add(aristas[0].getNodoOrigen());
		
		// la lista ya viene ordenada
		for (int i = 0; i < aristas.length; i++)
		{
			int nodoO = aristas[i].getNodoOrigen();
			int nodoD = aristas[i].getNodoDestino();
			
			if(!v.contains(nodoD) || !v.contains(nodoO))
			{
				v.add(nodoD);
				costoFinal += aristas[i].getCosto();
				lista.add(aristas[i]);
			}
		}
		
		long tFinal = System.currentTimeMillis();
		System.out.println(tFinal - tInicial);
		
		// out
		PrintWriter out = new PrintWriter(new FileWriter(arch));
		
		out.println(costoFinal);
		for (int i = 0; i < lista.size(); i++)
			out.println(lista.get(i));
		
		out.close();
	}
}
