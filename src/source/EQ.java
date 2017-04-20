/**
 * @file EQ.java
 * @author Carlo Sarli 
 * 
 * The EQ class sets up a simple parametric EQ using two filters the HighShelf and the LowShelf both built from a biquad filter
 * They both have two parameters: frequency and gain
 * The frequency indicates where the filter starts acting and the gain going from float 0 to 1 indicates the volume of the specified frequency range.
 */
package source;

import net.beadsproject.beads.ugens.BiquadFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class EQ is a singleton class.
 */
public class EQ extends Settings{
	
	
	/** The eq. */
	private static EQ eq = null;
	
	/** Type of biquad filter in this case LowShelf filter */
	BiquadFilter.Type low;
	
	/** Type of biquad filter in this case HighShelf filter */
	BiquadFilter.Type high;
	
	/** The frequencies for the two filters. */
	private float m_lowFreq, m_highFreq;
	
	/** Thegains for the two filters. */
	private float m_lowGain, m_highGain;
	
	/**
	 * Instantiates a new eq.
	 * @TODO eliminate magic numbers
	 * 
	 */
	protected EQ(){	
		high = BiquadFilter.Type.HIGH_SHELF;
		low = BiquadFilter.Type.LOW_SHELF;
		m_lowFreq = EQ_START_FREQ/HUNDRED_FACTOR; 
		m_highFreq = EQ_START_FREQ/HUNDRED_FACTOR;
		m_lowGain = EQ_START_GAIN/TEN_FACTOR;
		m_highGain = EQ_START_GAIN/TEN_FACTOR;
	}
	
	/**
	 * Gets the eq.
	 *
	 * @return the eq
	 */
	public static EQ getEQ(){
		if(eq == null){
			eq = new EQ();
		}
		return eq;
	}
	
	/**
	 * Sets the low freq.
	 *
	 * @param freq the new low freq
	 */
	public void setLowFreq(float freq){
		m_lowFreq = freq;
	}
	
	/**
	 * Sets the high freq.
	 *
	 * @param freq the new high freq
	 */
	public void setHighFreq(float freq){
		m_highFreq = freq;
	}
	
	/**
	 * Sets the low gain.
	 *
	 * @param gain the new low gain
	 */
	public void setLowGain(float gain){
		m_lowGain = gain;
	}
	
	/**
	 * Sets the high gain.
	 *
	 * @param gain the new high gain
	 */
	public void setHighGain(float gain){
		m_highGain = gain;
	}
	
	/**
	 * Gets the low.
	 *
	 * @return the low
	 */
	public BiquadFilter.Type getLow(){
		return low;
	}
	
	/**
	 * Gets the high.
	 *
	 * @return the high
	 */
	public BiquadFilter.Type getHigh(){
		return high;
	}
	
	/**
	 * Gets the low freq.
	 *
	 * @return the low freq
	 */
	public float getLowFreq(){
		return m_lowFreq;
	}
	
	/**
	 * Gets the high freq.
	 *
	 * @return the high freq
	 */
	public float getHighFreq(){
		return m_highFreq;
	}
	
	/**
	 * Gets the low gain.
	 *
	 * @return the low gain
	 */
	public float getLowGain(){
		return m_lowGain;
	}
	
	/**
	 * Gets the high gain.
	 *
	 * @return the high gain
	 */
	public float getHighGain(){
		return m_highGain;
	}
}
