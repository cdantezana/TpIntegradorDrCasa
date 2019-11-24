package tpDrCasa;

public class EnfermedadInfecciosa extends Enfermedad {

	public EnfermedadInfecciosa(int cels) {
		super(cels);
	}

	public void afectarA(Persona persona) {
		persona.aumentarTemperatura((float)getCantCelulasAmenazadas()/(float)1000);
	}
	public void reproducirse() {
		setCantCelulasAmenazadas(getCantCelulasAmenazadas() *  2);
	}
	public boolean esAgresiva(Persona persona) {
		return (getCantCelulasAmenazadas()>persona.getCantCelulas()* 0.1);
	}
	
	

}
