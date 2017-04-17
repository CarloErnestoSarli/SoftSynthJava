/*
 * @author Carlo Sarli 
 * 
 */
package source;

import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;
import views.Components;
import views.GUI;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
//singleton pattern
public class Settings {

	private static Settings settings = null;

	/** The Constant START_FREQ. */
	public static final float START_FREQ = 0.0f;
	private final int MIN_OSC_FREQ = 1635;
	private final int MAX_OSC_FREQ = 100000;
	private final int NOTE_A_FREQ = 44000;
	private final int LFO_MIN_FREQ = 2;
	private final int LFO_MAX_FREQ = 2000;
	private final int MIN_VOLUME = 0;
	private final int MAX_VOLUME = 100;
	private final int LEFT = -10;
	private final int RIGHT = 10;
	//private final int START_VOLUME = 50;
	private final int START_POSITION = 0;
	//private final float START_VOLUME = 0.5f;
	private final float START_PANNER_POSITION = 0.0f;
	/** The Constant START_TIME. */
	public static final float START_TIME = 500.0f;
	private final float START_THRESHOLD = 0.6f;
	private final float START_RATIO = 2.0f;
	private final float START_ATTACK = 500f;
	private final float START_DECAY = 500f;
	public static final float MIN_FREQ = 0.02f;
	private final float MAX_FREQ = 20.0f;
	private final float START_DAMP = 0.5f;
	private final float START_SIZE = 0.5f;
	private final float START_EARLY = 1.0f;
	private final float START_LATE = 1.0f;
	private final int TEN_FACTOR = 10;
	private final int HUNDRED_FACTOR = 100;
	
	private boolean m_play;

	/**
	 * Instantiates a new settings.
	 */
	protected Settings() {
	
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public static Settings getSettings() {
		if (settings == null) {
			settings = new Settings();
		}
		return settings;
	}

	// ----------------------------------------------------SETTERS-----------------------------------------------------

	public void setPlay(boolean m_play) {
		this.m_play = m_play;
	}
	
	// -------------------------------------------------GETTERS----------------------------------------------

	public boolean getPlay() {
		return m_play;
	}

	

	

}
