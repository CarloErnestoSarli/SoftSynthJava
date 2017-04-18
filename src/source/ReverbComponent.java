/*
 * @author Carlo Sarli 
 * 
 */
package source;

import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.Reverb;

// TODO: Auto-generated Javadoc
/**
 * The Class ReverbComponent.
 */
public class ReverbComponent extends Settings {
	
	/** The rev. */
	private static ReverbComponent rev = null;
	
	/** The audio. */
	Audio audio = Audio.getAudio();
	
	/** The reverb. */
	Reverb reverb;
	
	
	/** The m damping. */
	private float m_Damping;
	
	/** The m size. */
	private float m_Size;
	
	/** The m early reflection. */
	private float m_EarlyReflection;
	
	/** The m late reflection. */
	private float m_LateReflection;
	
	/**
	 * Instantiates a new reverb component.
	 */
	protected ReverbComponent(){
		reverb = new Reverb(audio.getAudioContext(),1);
		m_Damping = START_DAMP/TEN_FACTOR;
		m_Size = START_SIZE/TEN_FACTOR;
		m_EarlyReflection = START_EARLY/TEN_FACTOR;
		m_LateReflection = START_LATE/TEN_FACTOR;
	}
	
	/**
	 * Gets the reverb component.
	 *
	 * @return the reverb component
	 */
	public static ReverbComponent getReverbComponent(){
		if(rev == null){
			rev = new ReverbComponent();
		}
		return rev;
	}
	
	
	/**
	 * Gets the reverb.
	 *
	 * @return the reverb
	 */
	public Reverb getReverb(){
		return reverb;
	}

	/**
	 * Gets the damping.
	 *
	 * @return the damping
	 */
	public float getDamping() {
		return m_Damping;
	}

	/**
	 * Sets the damping.
	 *
	 * @param m_Damping the new damping
	 */
	public void setDamping(float m_Damping) {
		this.m_Damping = m_Damping;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public float getSize() {
		return m_Size;
	}

	/**
	 * Sets the size.
	 *
	 * @param m_Size the new size
	 */
	public void setSize(float m_Size) {
		this.m_Size = m_Size;
	}

	/**
	 * Gets the early reflection.
	 *
	 * @return the early reflection
	 */
	public float getEarlyReflection() {
		return m_EarlyReflection;
		
		
	}

	/**
	 * Sets the early reflection.
	 *
	 * @param earlyReflection the new early reflection
	 */
	public void setEarlyReflection(float earlyReflection) {
		m_EarlyReflection = earlyReflection;
		System.out.println("EARLY:  " + earlyReflection);
	}

	/**
	 * Gets the late reflection.
	 *
	 * @return the late reflection
	 */
	public float getLateReflection() {
		return m_LateReflection;
	}

	/**
	 * Sets the late reflection.
	 *
	 * @param lateReflection the new late reflection
	 */
	public void setLateReflection(float lateReflection) {
		m_LateReflection = lateReflection;
		System.out.println("LATE:  " + lateReflection);
	}

}
