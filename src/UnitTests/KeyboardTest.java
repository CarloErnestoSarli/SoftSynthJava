/**
 * 
 */
package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Keyboard;

/**
 * @author carlo
 *
 */
public class KeyboardTest {
	Keyboard k = new Keyboard();
	/**
	 * Test method for {@link source.Keyboard#Keyboard()}.
	 */
	@Test
	public final void testKeyboard() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link source.Keyboard#populateMidiNotes()}.
	 */
	@Test
	public final void testPopulateMidiNotes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link source.Keyboard#getNote(int)}.
	 */
	@Test
	public final void testGetNote() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link source.Keyboard#getMidifromNote(java.lang.String)}.
	 */
	@Test
	public final void testGetMidifromNote() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link source.Keyboard#pitchToFrequency(int)}.
	 */
	@Test
	public final void testPitchToFrequency() {
		float pitch = 138.59131f;
		assertEquals(k.pitchToFrequency(49),pitch);
	}

}
