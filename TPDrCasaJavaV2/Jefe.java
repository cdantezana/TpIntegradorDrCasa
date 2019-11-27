package programa;

import java.util.ArrayList;
import java.util.Random;
public class Jefe extends Medico {

	ArrayList<Medico> subordinados= new ArrayList<Medico>();
	public Jefe(int a, int b, ArrayList<Enfermedad> c, int d, ArrayList<Medico> e) {
		super(a,b,c,d);
		subordinados=e;
		
	}

	public int obtenerRandom()
	{
		Random random = new Random();
		return random.nextInt(subordinados.size());
		
	}
	
	public void atender(Persona persona)
	{
		subordinados.get(obtenerRandom()).atender(persona);
	}

	public void agregarSubordinado(Medico medico)
	{
		subordinados.add(medico);
	}
}
