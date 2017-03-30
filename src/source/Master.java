package source;

public class Master {

	/** The master. */
	private static Master master = null;
	
	private float m_osc1Gain, m_osc2Gain, m_oscMix;
	private float m_fil1Gain, m_fil2Gain, m_filMix;
	private float m_masterVolume;
	private float m_pannerPosition;
	
	private final float START_VOLUME = 0.5f;
	private final float START_PANNER_POSITION = 0.0f;
	
	/**
	 * Instantiates a new Master.
	 */
	protected Master() {
		m_osc1Gain = START_VOLUME;
		m_osc2Gain = START_VOLUME;
		m_oscMix = START_VOLUME;
		m_fil1Gain = START_VOLUME;
		m_fil2Gain = START_VOLUME;
		m_filMix = START_VOLUME;
		m_masterVolume = START_VOLUME;
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
	
	public void setOsc1Gain(float gain) {
		m_osc1Gain = gain;
	}
	
	public void setOsc2Gain(float gain) {
		m_osc2Gain = gain;
	}
	
	public void setOscMix(float gain) {
		m_oscMix = gain;
	}
	
	public void setFil1Gain(float gain) {
		m_fil1Gain = gain;
	}
	
	public void setFil2Gain(float gain) {
		m_fil2Gain = gain;
	}
	
	public void setFilMix(float gain) {
		m_filMix = gain;
	}
	
	public void setMasterVolume(float gain) {
		m_masterVolume = gain;
	}
	
	public void setPannerPosition(float position) {
		m_pannerPosition = position;
	}
	
	public float getOsc1Gain() {
		return m_osc1Gain;
	}
	
	public float getOsc2Gain() {
		return m_osc2Gain;
	}
	
	public float getOscMix() {
		return m_oscMix;
	}
	
	public float getFil1Gain() {
		return m_fil1Gain;
	}
	
	public float getFil2Gain() {
		return m_fil2Gain;
	}
	
	public float getFilMix() {
		return m_filMix;
	}
	
	public float getMasterVolume() {
		return m_masterVolume;
	}
	
	public float getPannerPosition() {
		return m_pannerPosition;
	}

	
}
