package tpDrCasa;

public class EnfermedadAutoinmune extends Enfermedad {

	public EnfermedadAutoinmune(int cels) {
		super(cels);
	}
	
	private int dias = 0;
	
	public void afectarA(Persona persona) {
		persona.destruirCelulas(getCantCelulasAmenazadas());
		dias++;
		
	}
	public boolean esAgresiva (Persona persona) {
		return (dias>30);
	}
	
	



}
