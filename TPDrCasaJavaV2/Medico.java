package programa;

import java.util.ArrayList;

public class Medico extends Persona{

	public int dosis;
	private Persona paciente;
	
	public void atender(Persona persona) {
		persona.recibirMedicamento(dosis);
		paciente=persona;
	}
	
	public void contraer(Enfermedad enfermedad) {
		super.contraer(enfermedad);
		this.atender(this);
	}
	public Medico(int a, int b, ArrayList<Enfermedad> c, int d) {
		super(a,b,c);
		dosis=d;
		
	}
	//getters & setters

	public Persona getPaciente() {
		return paciente;
	}
}
