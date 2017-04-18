/*
 * @author Carlo Sarli 
 * 
 */
package source;

// TODO: Auto-generated Javadoc
/**
 * The Class Master.
 */
public class Master extends Settings {
	
	Settings settings = Settings.getSettings();

	/** The master. */
	private static Master master = null;
	
	/** The m osc mix. */
	private float m_osc1Gain, m_osc2Gain, m_oscMix;
	
	/** The m fil mix. */
	private float m_fil1Gain, m_fil2Gain, m_filMix;
	
	/** The m master volume. */
	private float m_masterVolume;
	
	/** The m panner position. */
	private float m_pannerPosition;
	
	
	/**
	 * Instantiates a new Master.
	 */
	protected Master() {
		m_osc1Gain = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_osc2Gain = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_oscMix = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_fil1Gain = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_fil2Gain = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_filMix = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_masterVolume = START_VOLUME_MASTER/HUNDRED_FACTOR;
		m_pannerPosition = START_PANNER_POSITION;
	}

	/**
	 * Gets the master.
	 *
	 * @return the master
	 */
	public static Master getMaster() {
		if (master == null) {
			master = new Master();
		}
		return master;
	}
	
	/**
	 * Sets the osc 1 gain.
	 *
	 * @param gain the new osc 1 gain
	 */
	public void setOsc1Gain(float gain) {
		m_osc1Gain = gain;
	}
	
	/**
	 * Sets the osc 2 gain.
	 *
	 * @param gain the new osc 2 gain
	 */
	public void setOsc2Gain(float gain) {
		m_osc2Gain = gain;
	}
	
	/**
	 * Sets the osc mix.
	 *
	 * @param gain the new osc mix
	 */
	public void setOscMix(float gain) {
		m_oscMix = gain;
	}
	
	/**
	 * Sets the fil 1 gain.
	 *
	 * @param gain the new fil 1 gain
	 */
	public void setFil1Gain(float gain) {
		m_fil1Gain = gain;
	}
	
	/**
	 * Sets the fil 2 gain.
	 *
	 * @param gain the new fil 2 gain
	 */
	public void setFil2Gain(float gain) {
		m_fil2Gain = gain;
	}
	
	/**
	 * Sets the fil mix.
	 *
	 * @param gain the new fil mix
	 */
	public void setFilMix(float gain) {
		m_filMix = gain;
	}
	
	/**
	 * Sets the master volume.
	 *
	 * @param gain the new master volume
	 */
	public void setMasterVolume(float gain) {
		m_masterVolume = gain;
	}
	
	/**
	 * Sets the panner position.
	 *
	 * @param position the new panner position
	 */
	public void setPannerPosition(float position) {
		m_pannerPosition = position;
	}
	
	/**
	 * Gets the osc 1 gain.
	 *
	 * @return the osc 1 gain
	 */
	public float getOsc1Gain() {
		return m_osc1Gain;
	}
	
	/**
	 * Gets the osc 2 gain.
	 *
	 * @return the osc 2 gain
	 */
	public float getOsc2Gain() {
		return m_osc2Gain;
	}
	
	/**
	 * Gets the osc mix.
	 *
	 * @return the osc mix
	 */
	public float getOscMix() {
		return m_oscMix;
	}
	
	/**
	 * Gets the fil 1 gain.
	 *
	 * @return the fil 1 gain
	 */
	public float getFil1Gain() {
		return m_fil1Gain;
	}
	
	/**
	 * Gets the fil 2 gain.
	 *
	 * @return the fil 2 gain
	 */
	public float getFil2Gain() {
		return m_fil2Gain;
	}
	
	/**
	 * Gets the fil mix.
	 *
	 * @return the fil mix
	 */
	public float getFilMix() {
		return m_filMix;
	}
	
	/**
	 * Gets the master volume.
	 *
	 * @return the master volume
	 */
	public float getMasterVolume() {
		return m_masterVolume;
	}
	
	/**
	 * Gets the panner position.
	 *
	 * @return the panner position
	 */
	public float getPannerPosition() {
		return m_pannerPosition;
	}

	
}
