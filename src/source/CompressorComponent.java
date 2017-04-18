/**
 * @file CompressorComponent.java
 * @author Carlo Sarli 
 * 
 * The compressor components class creates a compressor for the synth
 * A compressor is a tool to eliminate peak frequencies and normalise the signal
 * It removes peak frequencies and raises the volume of lower volume frequencies
 * Makes the sound more potent and punchier
 * 
 * It has 4 parameters: THRESHOLD,RATIO,ATTACK and DECAY
 * Threshold indicates the frequency at which start to compress
 * Ratio is the compressing ratio
 * Attack the time it takes for the compressor to have its effect on the sound
 * Decay the time it takes for the compressor to release the sound
 * 
 * All values range from float 0 to 1 except threshold that goes from 1 to 10
 */
package source;

import net.beadsproject.beads.ugens.Compressor;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.Reverb;


/**
 * The Class CompressorComponent is a singleton class
 */
public class CompressorComponent extends Settings {
	
	/** The comp. */
	private static CompressorComponent comp = null;

	/** Instantiate the Audio class  */
	Audio audio = Audio.getAudio();
	

	/** The compressor. */
	Compressor compressor;

	/** The threshold. */
	private float m_Threshold;
	
	/** The ratio. */
	private float m_Ratio;
	
	/** The attack. */
	private float m_Attack;
	
	/** The decay. */
	private float m_Decay;

	/**
	 * Instantiates a new compressor component.
	 * sets start values for all parameters
	 */
	protected CompressorComponent(){
		compressor = new Compressor(audio.getAudioContext(),1);
		setThreshold(START_THRESHOLD/TEN_FACTOR);
		setRatio(START_RATIO);
		setAttack(START_ATTACK);
		setDecay(START_DECAY);
	}

	/**
	 * Gets the compressor component.
	 *
	 * @return the compressor component
	 */
	public static CompressorComponent getCompressorComponent() {
		if (comp == null) {
			comp = new CompressorComponent();
		}
		return comp;
	}
	
	

	/**
	 * Gets the compressor.
	 *
	 * @return the compressor
	 */
	public Compressor getCompressor() {
		return compressor;
	}

	/**
	 * Gets the threshold.
	 *
	 * @return the threshold
	 */
	public float getThreshold() {
		return m_Threshold;
	}

	/**
	 * Sets the threshold.
	 *
	 * @param m_Threshold the new threshold
	 */
	public void setThreshold(float m_Threshold) {
		this.m_Threshold = m_Threshold;
	}

	/**
	 * Gets the ratio.
	 *
	 * @return the ratio
	 */
	public float getRatio() {
		return m_Ratio;
	}

	/**
	 * Sets the ratio.
	 *
	 * @param m_Ratio the new ratio
	 */
	public void setRatio(float m_Ratio) {
		this.m_Ratio = m_Ratio;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public float getAttack() {
		return m_Attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param m_Attack the new attack
	 */
	public void setAttack(float m_Attack) {
		this.m_Attack = m_Attack;
	}

	/**
	 * Gets the decay.
	 *
	 * @return the decay
	 */
	public float getDecay() {
		return m_Decay;
	}

	/**
	 * Sets the decay.
	 *
	 * @param m_Decay the new decay
	 */
	public void setDecay(float m_Decay) {
		this.m_Decay = m_Decay;
	}
}
