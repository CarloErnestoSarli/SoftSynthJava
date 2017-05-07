/**
 * @file OscillatorSettings.java
 * @author Carlo Sarli 
 * @brief Handles the settings and parameters of the oscillator
 */
package source;

// TODO: Auto-generated Javadoc
/**
 * The Class OscillatorSettings.
 */
public class OscillatorSettings {
	
	/** The settings. */
	private static OscillatorSettings oscillatorSettings = null;
	

	/** The m osc 1 freq. */
	private float m_Osc1Freq;
	
	/** The m osc 2 freq. */
	private float m_Osc2Freq;

	/** The m wave 2 sel. */
	private String m_Wave1Sel, m_Wave2Sel;
	
	/** The m wave 2 phase. */
	private float m_Wave1Phase, m_Wave2Phase;
		
	/** The m delay out time. */
	private float m_delayIn1Time ,m_delayIn2Time, m_delayOutTime;
	
	private int m_transpose1;
	private int m_fineTuning1;
	private int m_transpose2;
	private int m_fineTuning2;
	
	/**
	 * Instantiates a new oscillator settings.
	 */
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
	

	/**
	 * Sets the wave 1 phase.
	 *
	 * @param phase the new wave 1 phase
	 */
	public void setWave1Phase(float phase) {
		m_Wave1Phase = phase;
	}

	/**
	 * Sets the wave 2 phase.
	 *
	 * @param phase the new wave 2 phase
	 */
	public void setWave2Phase(float phase) {
		m_Wave2Phase = phase;
	}
	
	/**
	 * Sets the delay in 1 time.
	 *
	 * @param time the new delay in 1 time
	 */
	public void setDelayIn1Time(float time){
		m_delayIn1Time = time;
	}
	
	/**
	 * Sets the delay in 2 time.
	 *
	 * @param time the new delay in 2 time
	 */
	public void setDelayIn2Time(float time){
		m_delayIn2Time = time;
	}
	
	/**
	 * Sets the delay out time.
	 *
	 * @param time the new delay out time
	 */
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
	
	/**
	 * Gets the delay in 1 time.
	 *
	 * @return the delay in 1 time
	 */
	public float getDelayIn1Time(){
		return m_delayIn1Time;
	}
	
	/**
	 * Gets the delay in 2 time.
	 *
	 * @return the delay in 2 time
	 */
	public float getDelayIn2Time(){
		return m_delayIn2Time;
	}
	
	/**
	 * Gets the delay out time.
	 *
	 * @return the delay out time
	 */
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

	

	/**
	 * Gets the wave 1 phase.
	 *
	 * @return the wave 1 phase
	 */
	public float getWave1Phase() {
		
		return m_Wave1Phase;
	}

	/**
	 * Gets the wave 2 phase.
	 *
	 * @return the wave 2 phase
	 */
	public float getWave2Phase() {
		
		return m_Wave2Phase;
	}

	public int getTranspose1() {
		return m_transpose1;
	}

	public void setTranspose1(int m_transpose) {
		this.m_transpose1 = m_transpose;
	}

	public int getFineTuning1() {
		return m_fineTuning1;
	}

	public void setFineTuning1(int m_fineTuning) {
		this.m_fineTuning1 = m_fineTuning;
	}

	public int getTranspose2() {
		return m_transpose2;
	}

	public void setTranspose2(int m_transpose2) {
		this.m_transpose2 = m_transpose2;
	}

	public int getFineTuning2() {
		return m_fineTuning2;
	}

	public void setFineTuning2(int m_fineTuning2) {
		this.m_fineTuning2 = m_fineTuning2;
	}

}
