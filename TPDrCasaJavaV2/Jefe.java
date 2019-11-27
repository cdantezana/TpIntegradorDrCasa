package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Jefe extends Medico {

	List<Medico> subordinados= new ArrayList<Medico>();
	public Jefe(int _cantCelulas,int _temperatura, List<Enfermedad> _enfermedades, int _dosis, List<Medico> _subordinados) {
		super(_cantCelulas,_temperatura,_enfermedades,_dosis);
		subordinados=_subordinados;
		
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
