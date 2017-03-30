/*
 * @author Carlo Sarli 
 * 
 */

package source;

import net.beadsproject.beads.ugens.Envelope;

// TODO: Auto-generated Javadoc
/**
 * The Class ADSR.
 */
public class ADSR {

	/** The adsr. */
	private static ADSR adsr = null;
	
	/** The Constant START_TIME. */
	public static final float START_TIME = 500.0f;
	
	/** The m attack time. */
	private float m_AttackTime;
	
	/** The m decay time. */
	private float m_DecayTime;
	
	/** The m sustain time. */
	private float m_SustainTime;
	
	/** The m release time. */
	private float m_ReleaseTime;

	/**
	 * Instantiates a new adsr.
	 */
	protected ADSR() {
		m_AttackTime = 100.0f;
		m_DecayTime = 100.0f;
		m_SustainTime = 100.0f;
		m_ReleaseTime = 100.0f;
	}

	/**
	 * Gets the adsr.
	 *
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
