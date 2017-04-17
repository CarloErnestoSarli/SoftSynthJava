package source;

public class OscillatorSettings {
	
	/** The settings. */
	private static OscillatorSettings oscillatorSettings = null;
	

	/** The m osc 1 freq. */
	private float m_Osc1Freq;
	
	/** The m osc 2 freq. */
	private float m_Osc2Freq;

	/** The m wave 2 sel. */
	private String m_Wave1Sel, m_Wave2Sel;
	
	private float m_Wave1Phase, m_Wave2Phase;
		
	private float m_delayIn1Time ,m_delayIn2Time, m_delayOutTime;
	
	protected OscillatorSettings() {
		m_Wave1Sel = "sine";
		m_Wave2Sel = "sine";
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public static OscillatorSettings getOscillatorSettings() {
		if (oscillatorSettings == null) {
			oscillatorSettings = new OscillatorSettings();
		}
		return oscillatorSettings;
	}
	
	/**
	 * Sets the osc 1 freq.
	 *
	 * @param freq the new osc 1 freq
	 */
	public void setOsc1Freq(float freq) {
		m_Osc1Freq = freq;
		System.out.println(freq);
	}

	/**
	 * Sets the osc 2 freq.
	 *
	 * @param freq the new osc 2 freq
	 */
	public void setOsc2Freq(float freq) {
		m_Osc2Freq = freq;
	}

	/**
	 * Sets the wave 1 sel.
	 *
	 * @param wave the new wave 1 sel
	 */
	public void setWave1Sel(String wave) {
		m_Wave1Sel = wave;
	}

	/**
	 * Sets the wave 2 sel.
	 *
	 * @param wave the new wave 2 sel
	 */
	public void setWave2Sel(String wave) {
		m_Wave2Sel = wave;
	}
	

	public void setWave1Phase(float phase) {
		m_Wave1Phase = phase;
	}

	public void setWave2Phase(float phase) {
		m_Wave2Phase = phase;
	}
	
	public void setDelayIn1Time(float time){
		m_delayIn1Time = time;
	}
	
	public void setDelayIn2Time(float time){
		m_delayIn2Time = time;
	}
	
	public void setDelayOutTime(float time){
		m_delayOutTime = time;
	}
	
	/**
	 * Gets the osc 1 freq.
	 *
	 * @return the osc 1 freq
	 */
	public float getOsc1Freq() {
		
		return m_Osc1Freq;
		
	}

	/**
	 * Gets the osc 2 freq.
	 *
	 * @return the osc 2 freq
	 */
	public float getOsc2Freq() {

		return m_Osc2Freq;
	}
	
	public float getDelayIn1Time(){
		return m_delayIn1Time;
	}
	
	public float getDelayIn2Time(){
		return m_delayIn2Time;
	}
	
	public float getDelayOutTime(){
		return m_delayOutTime;
	}

	/**
	 * Gets the wave 1 sel.
	 *
	 * @return the wave 1 sel
	 */
	public String getWave1Sel() {

		return m_Wave1Sel;

	}

	/**
	 * Gets the wave 2 sel.
	 *
	 * @return the wave 2 sel
	 */
	public String getWave2Sel() {

		return m_Wave2Sel;

	}

	

	public float getWave1Phase() {
		
		return m_Wave1Phase;
	}

	public float getWave2Phase() {
		
		return m_Wave2Phase;
	}

}
