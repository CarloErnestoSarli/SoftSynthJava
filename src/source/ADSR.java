package source;

import net.beadsproject.beads.ugens.Envelope;

public class ADSR {

	private static ADSR adsr = null;
	
	public static final float START_TIME = 500.0f;
	
	private float m_AttackTime;
	private float m_DecayTime;
	private float m_SustainTime;
	private float m_ReleaseTime;

	protected ADSR() {
		m_AttackTime = 100.0f;
		m_DecayTime = 100.0f;
		m_SustainTime = 100.0f;
		m_ReleaseTime = 100.0f;
	}

	public static ADSR getADSR() {
		if (adsr == null) {
			adsr = new ADSR();
		}
		return adsr;
	}
	

	// ----ADSR SETTERS------

	public void setAttackTime(float time) {
		m_AttackTime = time;
	}

	public void setDecayTime(float time) {
		m_DecayTime = time;
	}

	public void setSustainTime(float time) {
		m_SustainTime = time;
	}

	public void setReleaseTime(float time) {
		m_ReleaseTime = time;
	}

	// ----ADSR  GETTERS------

	public float getAttackTime() {

		return m_AttackTime;
	}

	public float getDecayTime() {

		return m_DecayTime;
	}

	public float getSustainTime() {

		return m_SustainTime;
	}

	public float getReleaseTime() {

		return m_ReleaseTime;
	}

	
}
