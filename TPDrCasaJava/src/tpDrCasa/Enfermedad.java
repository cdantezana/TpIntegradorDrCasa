package tpDrCasa;

abstract public class Enfermedad {
	
	public Enfermedad(int cels) {
		cantCelulasAmenazadas=cels;
	}
	
	private int cantCelulasAmenazadas;
	
	
	
	public abstract void afectarA(Persona persona);
	public abstract boolean esAgresiva (Persona persona);
	
	

	public void destruirCelulasAmenazadas(int cantCelulas) {
		cantCelulasAmenazadas+=cantCelulas;
		cantCelulasAmenazadas = Math.max(0, cantCelulasAmenazadas);
	}
	
	public void atenuar (int dosis,Persona persona)
	{
		this.destruirCelulasAmenazadas(-15*dosis);
		if(cantCelulasAmenazadas==0)
		{
			persona.curarseDe(this);
		}
	}
	
	//getters & setters
	public int getCantCelulasAmenazadas() {
		return cantCelulasAmenazadas;
	}
	public void setCantCelulasAmenazadas(int cantCelulasAmenazadas) {
		this.cantCelulasAmenazadas = cantCelulasAmenazadas;
	}
}
