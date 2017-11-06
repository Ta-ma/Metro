package metro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

public class Test {
	
	static public void main (String[] args) throws IOException
	{
		File dir = new File(".//IN//");
		
		for(File arch : dir.listFiles())
		{
			Grafo grafo = new Grafo(arch);
			grafo.Resolver(new File(".//OUT//" + arch.getName().replaceAll(".in", ".out")));
		}
	}

}
