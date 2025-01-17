package testModele;//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRegularisationCharges {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRecuperationChargesLocataire() {
		// ETANT DONNE un locataire ayant des charges dans un bien
		// QUAND les provisions pour charge sont inferieures au montant reel 
		// ALORS les loyers pour l'annee prochaine augmentent.
	}

	@Test
	public void testProvisionsSuperieurAuReelLoyerDiminue() {
		// ETANT DONNE un locataire ayant des charges dans un bien
		// QUAND les provisions pour charge sont superieure au montant reel 
		// ALORS les loyers pour l'annee prochaine diminuent. 
	}
	
	@Test
	public void testProvisionsInferieurAuReelLoyerAugmente() {
		// ETANT DONNE un locataire ayant des charges dans un bien
		// QUAND les provisions pour charge sont inferieures au montant reel 
		// ALORS les loyers pour l'annee prochaine augmentent. 
	}
	
	@Test
	public void testProvisionsSuperieurAuReelProvisionsDiminue() {
		// ETANT DONNE un locataire ayant des charges dans un bien
		// QUAND les provisions pour charge sont inferieures au montant reel 
		// ALORS les loyers pour l'annee prochaine augmentent.
	}
	
	@Test
	public void testProvisionsInferieurAuReelProvisionsAugmente() {
		// ETANT DONNE un locataire ayant des charges dans un bien
		// QUAND les provisions pour charge sont inferieures au montant reel 
		// ALORS les loyers pour l'annee prochaine augmentent.
	}

}
