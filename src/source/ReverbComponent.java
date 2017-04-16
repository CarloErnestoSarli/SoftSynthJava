package source;

import net.beadsproject.beads.ugens.Reverb;

public class ReverbComponent {
	
	private static ReverbComponent rev = null;
	
	Audio audio = Audio.getAudio();
	
	Reverb reverb;
	
	private final float START_DAMP = 0.5f;
	private final float START_SIZE = 0.5f;
	private final float START_EARLY = 1.0f;
	private final float START_LATE = 1.0f;
	
	private float m_Damping;
	private float m_Size;
	private float m_EarlyReflection;
	private float m_LateReflection;
	
	protected ReverbComponent(){
		reverb = new Reverb(audio.getAudioContext(),1);
		m_Damping = START_DAMP;
		m_Size = START_SIZE;
		m_EarlyReflection = START_EARLY;
		m_LateReflection = START_LATE;
	}
	
	public static ReverbComponent getReverbComponent(){
		if(rev == null){
			rev = new ReverbComponent();
		}
		return rev;
	}
	
	public Reverb getReverb(){
		return reverb;
	}

	public float getDamping() {
		return m_Damping;
	}

	public void setDamping(float m_Damping) {
		this.m_Damping = m_Damping;
	}

	public float getSize() {
		return m_Size;
	}

	public void setSize(float m_Size) {
		this.m_Size = m_Size;
	}

	public float getEarlyReflection() {
		return m_EarlyReflection;
		
		
	}

	public void setEarlyReflection(float earlyReflection) {
		m_EarlyReflection = earlyReflection;
		System.out.println("EARLY:  " + earlyReflection);
	}

	public float getLateReflection() {
		return m_LateReflection;
	}

	public void setLateReflection(float lateReflection) {
		m_LateReflection = lateReflection;
		System.out.println("LATE:  " + lateReflection);
	}

}
