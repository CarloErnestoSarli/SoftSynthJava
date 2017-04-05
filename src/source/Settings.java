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

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
//singleton pattern
public class Settings {

	/** The settings. */
	private static Settings settings = null;

	/** The m osc 1 freq. */
	private float m_Osc1Freq;
	
	/** The m osc 2 freq. */
	private float m_Osc2Freq;

	/** The m filter freq. */
	private float m_Filter1Freq;
	
	/** The m filter freq. */
	private float m_Filter2Freq;
	
	/** The m filter gain. */
	private float m_FilterGain;

	/** The m wave 2 sel. */
	private String m_Wave1Sel, m_Wave2Sel;
	
	private float m_Wave1Phase, m_Wave2Phase;
	
	/** The m filter sel. */
	private String m_Filter1Sel;
	
	/** The m filter sel. */
	private String m_Filter2Sel;

	/** The m filter wave 1. */
	private boolean m_FilterWave1;
	
	/** The m filter wave 2. */
	private boolean m_FilterWave2;
	
	private float m_delayIn1Time ,m_delayIn2Time, m_delayOutTime;

	/** The Constant START_FREQ. */
	public static final float START_FREQ = 0.0f;

	/**
	 * Instantiates a new settings.
	 */
	protected Settings() {
		m_Wave1Sel = "sine";
		m_Wave2Sel = "sine";
		m_Filter1Sel = "lpf";
		m_Filter2Sel = "lpf";
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

	// -----OSCILLATOR-------

	/**
	 * Sets the osc 1 freq.
	 *
	 * @param freq the new osc 1 freq
	 */
	public void setOsc1Freq(float freq) {
		m_Osc1Freq = freq;
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

	// -----FILTER-----

	/**
	 * Sets the filter freq.
	 *
	 * @param freq the new filter freq
	 */
	public void setFilter1Freq(float freq) {
		m_Filter1Freq = freq;
	}
	
	/**
	 * Sets the filter freq.
	 *
	 * @param freq the new filter freq
	 */
	public void setFilter2Freq(float freq) {
		m_Filter2Freq = freq;
	}

	/**
	 * Sets the filter gain.
	 *
	 * @param gain the new filter gain
	 */
	public void setFilterGain(float gain) {
		m_FilterGain = gain;
	}

	/**
	 * Sets the filter sel.
	 *
	 * @param filter the new filter sel
	 */
	public void setFilter1Sel(String filter) {
		m_Filter1Sel = filter;
	}
	
	/**
	 * Sets the filter sel.
	 *
	 * @param filter the new filter sel
	 */
	public void setFilter2Sel(String filter) {
		m_Filter2Sel = filter;
	}

	/**
	 * Sets the filter wave 1.
	 *
	 * @param on the new filter wave 1
	 */
	public void setFilterWave1(boolean on) {
		m_FilterWave1 = on;
	}

	/**
	 * Sets the filter wave 2.
	 *
	 * @param on the new filter wave 2
	 */
	public void setFilterWave2(boolean on) {
		m_FilterWave2 = on;
	}


	// -------------------------------------------------GETTERS----------------------------------------------

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
	 * Gets the filter freq.
	 *
	 * @return the filter freq
	 */
	public float getFilter1Freq() {

		return m_Filter1Freq;
	}
	
	/**
	 * Gets the filter freq.
	 *
	 * @return the filter freq
	 */
	public float getFilter2Freq() {

		return m_Filter2Freq;
	}

	/**
	 * Gets the filter gain.
	 *
	 * @return the filter gain
	 */
	public float getFilterGain() {

		return m_FilterGain;
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
	 * Gets the filter sel.
	 *
	 * @return the filter sel
	 */
	public String getFilter1Sel() {

		return m_Filter1Sel;

	}
	
	/**
	 * Gets the filter sel.
	 *
	 * @return the filter sel
	 */
	public String getFilter2Sel() {

		return m_Filter2Sel;

	}

	/**
	 * Gets the filter wave 1.
	 *
	 * @return the filter wave 1
	 */
	public boolean getFilterWave1() {
		
		return m_FilterWave1;
	}

	/**
	 * Gets the filter wave 2.
	 *
	 * @return the filter wave 2
	 */
	public boolean getFilterWave2() {
		
		return m_FilterWave2;
	}

	public float getWave1Phase() {
		
		return m_Wave1Phase;
	}

	public float getWave2Phase() {
		
		return m_Wave2Phase;
	}

	

}
