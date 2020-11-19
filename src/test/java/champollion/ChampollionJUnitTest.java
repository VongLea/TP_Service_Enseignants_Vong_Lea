package champollion;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention cours1, cours2;
        Salle salle1;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
                salle1 = new Salle("Salle de tp", 30);
                cours1 = new Intervention(salle1, uml, untel, new Date(), 9, 2, 5, 2);
                cours2 = new Intervention(salle1, uml, untel, new Date(), 5, 0, 5, 0);
	}
        
	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
        
        @Test
	public void testNouvelEnseignantAvecService() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
                untel.ajouteEnseignement(java, 0, 20, 0);
		assertEquals(30, untel.heuresPrevues(), "L'enseignant doit maintenant avoir 30 heures prévues");
	}
        
        @Test
	public void testSousService() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
                untel.ajouteEnseignement(java, 0, 20, 0);
		assertTrue(untel.enSousService(), "L'enseignant est en sous service");
	}
        
        @Test
	public void testEstEnService() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 173, 0);
                untel.ajouteEnseignement(java, 0, 20, 0);
		assertFalse(untel.enSousService(), "L'enseignant est en sous service");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
	public void testHeuresPlanifiees() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
                untel.ajouteIntervention(cours2);
		assertEquals(5, untel.heuresPlanifiees(), "Les heures ne sont pas bien planifiées");
                
                untel.ajouteEnseignement(uml, 2, 5, 2);
                untel.ajouteIntervention(cours1);
		assertEquals(24, untel.heuresPlanifiees(), "Les heures ne sont pas bien planifiées");	
	}
	
}
