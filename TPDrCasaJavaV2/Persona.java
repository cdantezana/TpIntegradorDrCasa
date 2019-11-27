package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Persona {

	public Persona( int _cantCelulas,int _temperatura, List<Enfermedad> _enfermedades) {
		cantCelulas=_cantCelulas;
		temperatura=_temperatura;
		enfermedades=_enfermedades;
		}
	public boolean estaEnComa() {
		return ((temperatura == 45) || (cantCelulas < 1000000));
	}
	
	List<Enfermedad> enfermedades= new ArrayList<>();
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
	
	public List<Enfermedad> enfermedadesAgresivas(){
		enfermedades.removeIf(enfermedad -> enfermedad.esAgresiva(this));
		return enfermedades;
	}
	
	public int cantCelulasAfectadasPorAgresivas ()
	{
		
		int totCelAfect= enfermedadesAgresivas().stream().mapToInt(enfermedad ->enfermedad.getCantCelulasAmenazadas()).sum();
		return totCelAfect;
				
	}
	
	public Enfermedad enfermedadQueAmenazaMasCelulas() {
		
		Enfermedad amenazativaMaxima=enfermedades.stream().max(Comparator.comparing(Enfermedad::getCantCelulasAmenazadas)).get();
		return amenazativaMaxima;
			
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
	public List<Enfermedad> enfermedades() {
		return enfermedades;
	}
	
}
