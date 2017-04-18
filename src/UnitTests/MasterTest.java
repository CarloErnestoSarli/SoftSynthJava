/**
 * 
 */
package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Master;

/**
 * @author carlo
 *
 */
public class MasterTest {
	
	Master master = Master.getMaster();
	/**
	 * Test method for {@link source.Master#setOsc1Gain(float)}.
	 */
	@Test
	public void testSetOsc1Gain() {
		master.setOsc1Gain(5);
		float x = 5.0f;
		assertEquals(master.getOsc1Gain(), x);
	}

	/**
	 * Test method for {@link source.Master#setOsc2Gain(float)}.
	 */
	@Test
	public void testSetOsc2Gain() {
		master.setOsc2Gain(10);
		float x = 10.0f;
		assertEquals(master.getOsc2Gain(), x);
	}

	/**
	 * Test method for {@link source.Master#setOscMix(float)}.
	 */
	@Test
	public void testSetOscMix() {
		master.setOscMix(0.5f);
		float x = 0.5f;
		assertEquals(master.getOscMix(), x);
	}

	/**
	 * Test method for {@link source.Master#setFil1Gain(float)}.
	 */
	@Test
	public void testSetFil1Gain() {
		master.setFil1Gain(0.5f);
		float x = 0.5f;
		assertEquals(master.getFil1Gain(), x);
	}

	/**
	 * Test method for {@link source.Master#setFil2Gain(float)}.
	 */
	@Test
	public void testSetFil2Gain() {
		master.setFil2Gain(0.5f);
		float x = 0.5f;
		assertEquals(master.getFil2Gain(), x);
	}

	/**
	 * Test method for {@link source.Master#setFilMix(float)}.
	 */
	@Test
	public void testSetFilMix() {
		master.setFilMix(0.5f);
		float x = 0.5f;
		assertEquals(master.getFilMix(), x);
	}

	/**
	 * Test method for {@link source.Master#setMasterVolume(float)}.
	 */
	@Test
	public void testSetMasterVolume() {
		master.setMasterVolume(0.5f);
		float x = 0.5f;
		assertEquals(master.getMasterVolume(), x);
	}

	/**
	 * Test method for {@link source.Master#setPannerPosition(float)}.
	 */
	@Test
	public void testSetPannerPosition() {
		master.setPannerPosition(0.8f);
		float x = 0.8f;
		assertEquals(master.getPannerPosition(), x);
	}

}
