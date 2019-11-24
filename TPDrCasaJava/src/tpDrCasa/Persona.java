package tpDrCasa;
import java.util.ArrayList;
public class Persona {

	public Persona( int a,int b,ArrayList<Enfermedad> c) {
		cantCelulas=a;
		temperatura=b;
		enfermedades=c;
		}
	public boolean estaEnComa() {
		return ((temperatura == 45) || (cantCelulas < 1000000));
	}
	
	ArrayList<Enfermedad> enfermedades= new ArrayList<Enfermedad>();
	private int cantCelulas;
	private float temperatura;
	
	public void contraer(Enfermedad enfermedad)
	{
		enfermedades.add(enfermedad);
	}
	public void vivirUnDia() {
		enfermedades.forEach(enfermedad -> enfermedad.afectarA(this));
	}
	public void aumentarTemperatura (float grados) {
		temperatura+=grados;
		temperatura= Math.min(temperatura, 45);
	}
	
	public void destruirCelulas(int cantidadCelulas) {
		cantCelulas -= cantidadCelulas;
		cantCelulas = Math.max(cantCelulas, 0);
	}
	
	public ArrayList<Enfermedad> enfermedadesAgresivas(){
		enfermedades.removeIf(enfermedad -> enfermedad.esAgresiva(this));
		return enfermedades;
	}
	
	public int cantCelulasAfectadasPorAgresivas ()
	{
		int cant=0;
		for(Enfermedad enfermedadAgre: enfermedadesAgresivas())
		{
			cant+= enfermedadAgre.getCantCelulasAmenazadas();
		}
		return cant;
				
	}
	
	public Enfermedad enfermedadQueAmenazaMasCelulas() {
		
		Enfermedad max= enfermedades.get(0);
		for (Enfermedad enfermedad : enfermedades) {
			if(enfermedad.getCantCelulasAmenazadas()>max.getCantCelulasAmenazadas())
				max=enfermedad;
		}
		return max;
			
	}
	public void recibirMedicamento(int dosis) {
		enfermedades.forEach(enfermedad -> enfermedad.atenuar(dosis, this));
	}
	
	public void curarseDe(Enfermedad enfermedad) {
		enfermedades.remove(enfermedad);
	}
	
	public void bajarTemperaturaA9() {
		temperatura=0;
	}
	
	public void vivirUnMes() {
		for (int i = 0; i < 31; i++) {
			this.vivirUnDia();
		}
	}
	//Getters& Setters
	public int getCantCelulas() {
		return cantCelulas;
	}
	public void setCantCelulas(int cantCelulas) {
		this.cantCelulas = cantCelulas;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
	
	


}
