package programa;

import java.util.List;

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
	public Medico(int _cantCelulas,int _temperatura, List<Enfermedad> _enfermedades, int _dosis) {
		super(_cantCelulas,_temperatura,_enfermedades);
		dosis=_dosis;
		
	}
	//getters & setters

	public Persona getPaciente() {
		return paciente;
	}
}
