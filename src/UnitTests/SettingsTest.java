package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Settings;

public class SettingsTest {
	
	Settings settings = Settings.getSettings();
	@Test
	public void testSettings() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSettings() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwitchReverbOn() {
		
	}

	@Test
	public void testSwitchReverbOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwitchCompressorOn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwitchCompressorOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsReverbOn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetReverbOn() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCompressorOn() {
		assertEquals(settings.isCompressorOn(), true);
	}

	@Test
	public void testSetCompressorOn() {
		boolean on = true;
		settings.setCompressorOn(on);
	}

}
