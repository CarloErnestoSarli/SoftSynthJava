/*
 * @author Carlo Sarli 
 * 
 */
package source;

import net.beadsproject.beads.ugens.Compressor;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.Reverb;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
// singleton pattern
public class Settings {

	/** The settings. */
	private static Settings settings = null;

	// -------------------------------------OSC----------------------------
	public final int MIN_OSC_FREQ = 1635;
	public final int MAX_OSC_FREQ = 1600000;
	public final int MIN_TRANSPOSE = 0;
	public final int MAX_TRANSPOSE = 5;
	public final int MIN_FINE_TUNING = -11;
	public final int MAX_FINE_TUNING = 11;
	public final int MIN_PHASE_SHIFT = 0;
	public final int MAX_PHASE_SHIFT = 300;
	public final int OSC_START_FREQ = 44000;
	public final int TRANSPOSE_START = 0;
	public final int FINE_TUNE_START = 0;
	public final int PHASE_START_SHIFT = 0;

	// -------------------------------------FIL----------------------------
	public final boolean FILTER_1_ON = false;
	public final boolean FILTER_2_ON = false;
	public final int MIN_FIL_FREQ = 1635;
	public final int MAX_FIL_FREQ = 1600000;
	public final int MIN_FIL_GAIN = 0;
	public final int MAX_FIL_GAIN = 10;
	public final int FIL_START_FREQ = 44000;
	public final int FIL_START_GAIN = 5;
	// -------------------------------------LFO----------------------------
	public final int MIN_LFO_FREQ = 22;
	public final int MAX_LFO_FREQ = 2000;
	public final int MIN_LFO_AMPL = 0;
	public final int MAX_LFO_AMPL = 1;
	public final int START_LFO_FREQ = 1000;
	public final int START_LFO_AMPL = 1;
	// -------------------------------------ADSR---------------------------
	public final int MIN_ADSR_TIME = 1;
	public final int MAX_ADSR_TIME = 1000;
	public final int ADSR_START_TIME = 100;
	// -------------------------------------EQ-----------------------------
	public final int MIN_EQ_FREQ = 1635;
	public final int MAX_EQ_FREQ = 1600000;
	public final int MIN_EQ_GAIN = 0;
	public final int MAX_EQ_GAIN = 10;
	public final int EQ_START_FREQ = 44000;
	public final int EQ_START_GAIN = 5;
	// -------------------------------------PAN----------------------------
	public final int LEFT_PAN = -10;
	public final int RIGHT_PAN = 10;
	public final int START_PANNER_POSITION = 0;
	// -------------------------------------MASTER-------------------------
	/** The min volume. */
	public final int MIN_VOLUME_MASTER = 0;

	/** The max volume. */
	public final int MAX_VOLUME_MASTER = 100;

	public final int START_VOLUME_MASTER = 50;
	// -------------------------------------REV----------------------------
	public final int MIN_DAMP = 0;
	public final int MAX_DAMP = 10;
	public final int MIN_SIZE = 0;
	public final int MAX_SIZE = 10;
	public final int MIN_EARLY = 0;
	public final int MAX_EARLY = 10;
	public final int MIN_LATE = 0;
	public final int MAX_LATE = 10;
	/** The start damp. */
	public final int START_DAMP = 5;

	/** The start size. */
	public final int START_SIZE = 5;

	/** The start early. */
	public final int START_EARLY = 10;

	/** The start late. */
	public final int START_LATE = 10;
	// -------------------------------------COMP---------------------------
	public final int MIN_THRESHOLD = 0;
	public final int MAX_THRESHOLD = 10;
	public final int MIN_RATIO = 1;
	public final int MAX_RATIO = 8;
	public final int MIN_ATTACK = 1;
	public final int MAX_ATTACK = 1000;
	public final int MIN_DECAY = 1;
	public final int MAX_DECAY = 1000;

	/** The start threshold. */
	public final int START_THRESHOLD = 6;

	/** The start ratio. */
	public final int START_RATIO = 2;

	/** The start attack. */
	public final int START_ATTACK = 500;

	/** The start decay. */
	public final int START_DECAY = 500;
	// -------------------------------------GENERAL------------------------
	/** The ten factor. */
	public final float TEN_FACTOR = 10.0f;

	/** The hundred factor. */
	public final float HUNDRED_FACTOR = 100.0f;

	/** The min volume. */
	private final int MIN_VOLUME = 0;

	/** The max volume. */
	private final int MAX_VOLUME = 100;

	/** The m play. */
	private boolean m_play;

	/** The m reverb on. */
	private boolean m_ReverbOn;

	/** The m compressor on. */
	private boolean m_CompressorOn;

	/**
	 * Instantiates a new settings.
	 */
	protected Settings() {
		m_play = true;
		m_ReverbOn = false;
		m_CompressorOn = false;
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

	/**
	 * Switch reverb on.
	 *
	 * @param reverb
	 *            the reverb
	 * @param gain
	 *            the gain
	 */
	public void switchReverbOn(Reverb reverb, Gain gain) {
		if (!reverb.containsInput(gain) && isReverbOn()) {
			reverb.addInput(gain);
			// pan.addInput(reverb);
		} else if (!isReverbOn()) {
			switchReverbOff(reverb, gain);
		}
	}

	/**
	 * Switch reverb off.
	 *
	 * @param reverb
	 *            the reverb
	 * @param gain
	 *            the gain
	 */
	public void switchReverbOff(Reverb reverb, Gain gain) {
		reverb.removeAllConnections(gain);
	}

	/**
	 * Switch compressor on.
	 *
	 * @param compressor
	 *            the compressor
	 * @param gain
	 *            the gain
	 * @param pan
	 *            the pan
	 */
	public void switchCompressorOn(Compressor compressor, Gain gain, Panner pan) {
		if (!compressor.containsInput(gain) && isCompressorOn()) {
			if (pan.containsInput(gain)) {
				pan.removeAllConnections(gain);
				compressor.addInput(gain);
				// pan.addInput(reverb);
			} else if (!pan.containsInput(gain)) {
				compressor.addInput(gain);
				// pan.addInput(reverb);
			}
		} else if (!isCompressorOn()) {
			switchCompressorOff(compressor, gain, pan);
		}
	}

	/**
	 * Switch compressor off.
	 *
	 * @param compressor
	 *            the compressor
	 * @param gain
	 *            the gain
	 * @param pan
	 *            the pan
	 */
	public void switchCompressorOff(Compressor compressor, Gain gain, Panner pan) {
		compressor.removeAllConnections(gain);
		if (!pan.containsInput(gain)) {
			pan.addInput(gain);
		}
	}

	// ----------------------------------------------------SETTERS-----------------------------------------------------

	/**
	 * Sets the play.
	 *
	 * @param m_play
	 *            the new play
	 */
	public void setPlay(boolean m_play) {
		this.m_play = m_play;
	}

	// -------------------------------------------------GETTERS----------------------------------------------

	/**
	 * Gets the play.
	 *
	 * @return the play
	 */
	public boolean getPlay() {
		return m_play;
	}

	/**
	 * Checks if is reverb on.
	 *
	 * @return true, if is reverb on
	 */
	public boolean isReverbOn() {
		return m_ReverbOn;
	}

	/**
	 * Sets the reverb on.
	 *
	 * @param m_ReverbOn
	 *            the new reverb on
	 */
	public void setReverbOn(boolean m_ReverbOn) {
		this.m_ReverbOn = m_ReverbOn;
	}

	/**
	 * Checks if is compressor on.
	 *
	 * @return true, if is compressor on
	 */
	public boolean isCompressorOn() {
		return m_CompressorOn;
	}

	/**
	 * Sets the compressor on.
	 *
	 * @param m_CompressorOn
	 *            the new compressor on
	 */
	public void setCompressorOn(boolean m_CompressorOn) {
		this.m_CompressorOn = m_CompressorOn;
	}

}
