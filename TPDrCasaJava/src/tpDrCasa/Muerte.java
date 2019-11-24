package tpDrCasa;

public class Muerte extends Enfermedad {
	public Muerte(int cels){
		super(cels);
		}
	
	public void atenuar (int dosis, Persona persona){}
	
	public void afectarA(Persona persona) {
		persona.bajarTemperaturaA9();
		
	}
	
	public boolean esAgresiva(Persona persona) {
		return true;
	}
}
