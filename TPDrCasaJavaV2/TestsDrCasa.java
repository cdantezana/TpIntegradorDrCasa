package programa;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestsDrCasa {
	
	//Enfermedades a)
	EnfermedadInfecciosa malaria = new EnfermedadInfecciosa(500);
	EnfermedadInfecciosa otitis = new EnfermedadInfecciosa(100);
	EnfermedadAutoinmune lupus = new EnfermedadAutoinmune(10000);
	
	//Enfermedades b)
	EnfermedadInfecciosa otraMalaria = new EnfermedadInfecciosa(800);
	
	//Personas c)
	Persona logan;
	//Personas d)
	Persona frank;
	
	//Medico
	Medico cameron;
	
	//Jefe
	Jefe house;
	
	//Muerte
	Muerte muerte = new Muerte(0);
	
	@Before
	public void fixture() {
		ArrayList<Enfermedad> listaLogan = new ArrayList<Enfermedad>();
		listaLogan.add(malaria);
		listaLogan.add(otitis);
		listaLogan.add(lupus);
		logan = new Persona (3000000,36, listaLogan );
				
		ArrayList<Enfermedad> listaFrank = new ArrayList<Enfermedad>();
		frank= new Persona (3500000, 36,listaFrank);
		
		ArrayList<Enfermedad> listaCameron = new ArrayList<Enfermedad>();
		cameron= new Medico (9999, 30, listaCameron, 0);
		
		ArrayList<Enfermedad> listaHouse = new ArrayList<Enfermedad>();
		ArrayList<Medico> subordinados= new ArrayList<Medico>();
		subordinados.add(cameron);
		
		house= new Jefe (999999999, 60, listaHouse, 0 ,subordinados);
		
		
		
	}
	
	/////////////////////////////////////////////////TEMPORADA 1/////////////////////////////////////
	
	//1) Al contraer la enfermedad b, Frank queda con otraMalaria
	@Test
	public void contraerFrankMalariaTest() {
		frank.contraer(otraMalaria);
		Assert.assertTrue(frank.enfermedades.contains(otraMalaria));
	}
	
	//2) Al reproducirse una enfermedad infecciosa esta duplica su cantidad de celulas amenazadas
	@Test
	public void reproducirInfecciosaDuplicTest() {
		int celulasAfectadasAntesDeReproducirse = malaria.getCantCelulasAmenazadas();
		malaria.reproducirse();
		Assert.assertEquals(celulasAfectadasAntesDeReproducirse * 2, malaria.getCantCelulasAmenazadas());
	}
	
	//3-a) Una persona vive un dia, y veo cantidad de celulas afectadas por agresivas
	@Test
	public void vivirDiaCantCelulasTest() {
		int cantCelulasAntesDeSerAfectadas = logan.getCantCelulas();
		logan.vivirUnDia();
		Assert.assertEquals(cantCelulasAntesDeSerAfectadas - 10000, logan.getCantCelulas());
	}
	
	//3-b)Una persona vive un dia, y veo la enfermedad que mas celulas afecte
	@Test
	public void vivirDiaMasAfectaTest() {
		logan.vivirUnDia();
		Assert.assertEquals(lupus,logan.enfermedadQueAmenazaMasCelulas());
	}
	
	//3-c) Una persona vive un dia, y veo si esta en coma
	@Test
	public void vivirDiaEnComaTest() {
		logan.vivirUnDia();
		Assert.assertFalse(logan.estaEnComa());
	}
	//3-d (extra)
	@Test
	public void vivirDiaTemperaturaTest() {
		float temperaturaAntesDeSerAfectada = logan.getTemperatura();
		logan.vivirUnDia();
		Assert.assertEquals((temperaturaAntesDeSerAfectada + 0.6),logan.getTemperatura(), 0.1d);
	}
	
	//4-a	Una persona vive 31 días, y veo cantidad de celulas afectadas por agresivas
	
	@Test
	public void vivir31CantCelulasTest() {
		int cantCelulasAntesDeSerAfectadas = logan.getCantCelulas();
		logan.vivirUnMes();
		
		Assert.assertEquals(cantCelulasAntesDeSerAfectadas - 310000,logan.getCantCelulas());
	}
	//4-b  Una persona vive 31 días, y veo la enfermedad que mas celulas afecte
	@Test
	public void vivir31MasAfectaTest()
	{
			logan.vivirUnMes();
			Assert.assertEquals(lupus,logan.enfermedadQueAmenazaMasCelulas());
		
		
	}
	
	//4-c  Una persona vive 31 días,  y veo si esta en coma
	@Test
	public void vivir31EnComaTest() {
		
		logan.vivirUnMes();
		Assert.assertTrue(logan.estaEnComa());
	}
	
	//5   La temperatura de una persona no puede subir a mas de 45 grados
	@Test
	public void noSubirMas45Test() {
		logan.aumentarTemperatura(1000);
		Assert.assertEquals(45, logan.getTemperatura(), 0.1d);
		
	}
	
	//6 Una persona esta en coma cuando su temperatura es 45
	@Test
	public void enComaCon45Test() {
		logan.setTemperatura(45);
		Assert.assertTrue(logan.estaEnComa());
	}
	
	//7 Una persona esta en coma cuando su cantidad de celulas es menor a 1000000
		@Test
		public void enComaMenorNumero() {
			logan.setCantCelulas(999999);
			Assert.assertTrue(logan.estaEnComa());
		}

//	Temporada 2
//	1 - a - Hacer que la malaria se atenue en 100 y el lupus en 500
		@Test
		public void disminuirMalariaEn100() {
			malaria.destruirCelulasAmenazadas(100);
			Assert.assertEquals(400, malaria.getCantCelulasAmenazadas());
		}

//	1 - b - Hacer que el lupus se atenue en 500
			@Test
			public void disminuirLupusEn500() {
				lupus.destruirCelulasAmenazadas(500);
				Assert.assertEquals(9500, lupus.getCantCelulasAmenazadas());
			}
// 2 - Hacer que Cameron atienda a Logan
			@Test
			public void atiendaCameronALogan() {
				cameron.atender(logan);
				Assert.assertEquals(logan, cameron.getPaciente());
			}

// 3 - Hacer que Cameron atienda el paciente de House - Arbitrariamente logan
			@Test
			public void houseAtiendeACameron() {
				house.agregarSubordinado(cameron);
			house.atender(logan);
				Assert.assertEquals(logan, cameron.getPaciente());
			}
// 4 - a - Hacer que Cameron contraiga malaria.
			@Test
			public void cameronContraeMalaria() {
				cameron.contraer(malaria);
				Assert.assertTrue(cameron.enfermedades().contains(malaria));
			}
// 4 - b - Hacer que House contraiga malaria.
			@Test
			public void houseContraeMalaria() {
				house.contraer(malaria);
				Assert.assertTrue(house.enfermedades().contains(malaria));
			}
// 5 - Hacer que House contraiga la Muerte. 
			@Test
			public void houseContraeLaMuerte() {
				house.contraer(muerte);
				Assert.assertTrue(house.enfermedades().contains(muerte));
			}
}
