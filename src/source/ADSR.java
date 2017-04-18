/**
 * @file ADSR.java
 * @author Carlo Sarli 
 * 
 * This class holds the paramaters for the ADSR envelope of the synth.
 * ADSR stands for ATTACK DECAY SUSTAIN and RELEASE, they all indicate a correlation between time and volume
 * Attack indicates the time to reach peak volume
 * Decay indicates the time to go from peak volume to sustain volume
 * Sustain is the time for which a stable volume is maintained
 * Release is the time to go from sustain to a volume = to 0
 * All values go from 0ms to 1000ms (1s) and are all floats
 */
package source;

import net.beadsproject.beads.ugens.Envelope;


/**
 * The Class ADSR is a singleton class
 */
public class ADSR extends Settings{

	
	
	/** The adsr object initialised to null as for the singleton pattern. */
	private static ADSR adsr = null;
	
	
	/** The attack time. */
	private float m_AttackTime;
	
	/** The decay time. */
	private float m_DecayTime;
	
	/** The sustain time. */
	private float m_SustainTime;
	
	/** The release time. */
	private float m_ReleaseTime;

	/**
	 * Instantiates a new adsr.
	 */
	protected ADSR() {
		m_AttackTime = ADSR_START_TIME;
		m_DecayTime = ADSR_START_TIME;
		m_SustainTime = ADSR_START_TIME;
		m_ReleaseTime = ADSR_START_TIME;
	}

	/**
	 * Gets the adsr.
	 * creates a new instance only if it hasn't been created before
	 * @return the adsr 
	 */
	public static ADSR getADSR() {
		if (adsr == null) {
			adsr = new ADSR();
		}
		return adsr;
	}
	

	// ----ADSR SETTERS------

	/**
	 * Sets the attack time.
	 *
	 * @param time the new attack time
	 */
	public void setAttackTime(float time) {
		m_AttackTime = time;
	}

	/**
	 * Sets the decay time.
	 *
	 * @param time the new decay time
	 */
	public void setDecayTime(float time) {
		m_DecayTime = time;
	}

	/**
	 * Sets the sustain time.
	 *
	 * @param time the new sustain time
	 */
	public void setSustainTime(float time) {
		m_SustainTime = time;
	}

	/**
	 * Sets the release time.
	 *
	 * @param time the new release time
	 */
	public void setReleaseTime(float time) {
		m_ReleaseTime = time;
	}

	// ----ADSR  GETTERS------

	/**
	 * Gets the attack time.
	 *
	 * @return the attack time
	 */
	public float getAttackTime() {

		return m_AttackTime;
	}

	/**
	 * Gets the decay time.
	 *
	 * @return the decay time
	 */
	public float getDecayTime() {

		return m_DecayTime;
	}

	/**
	 * Gets the sustain time.
	 *
	 * @return the sustain time
	 */
	public float getSustainTime() {

		return m_SustainTime;
	}

	/**
	 * Gets the release time.
	 *
	 * @return the release time
	 */
	public float getReleaseTime() {

		return m_ReleaseTime;
	}

	
}
