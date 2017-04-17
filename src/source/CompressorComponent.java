package source;

import net.beadsproject.beads.ugens.Compressor;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.Reverb;

public class CompressorComponent {
	
	private static CompressorComponent comp = null;

	Audio audio = Audio.getAudio();

	Compressor compressor;

	private final float START_THRESHOLD = 0.6f;
	private final float START_RATIO = 2.0f;
	private final float START_ATTACK = 500f;
	private final float START_DECAY = 500f;

	private float m_Threshold;
	private float m_Ratio;
	private float m_Attack;
	private float m_Decay;

	protected CompressorComponent(){
		compressor = new Compressor(audio.getAudioContext(),1);
		setThreshold(START_THRESHOLD);
		setRatio(START_RATIO);
		setAttack(START_ATTACK);
		setDecay(START_DECAY);
	}

	public static CompressorComponent getCompressorComponent() {
		if (comp == null) {
			comp = new CompressorComponent();
		}
		return comp;
	}
	
	

	public Compressor getCompressor() {
		return compressor;
	}

	public float getThreshold() {
		return m_Threshold;
	}

	public void setThreshold(float m_Threshold) {
		this.m_Threshold = m_Threshold;
	}

	public float getRatio() {
		return m_Ratio;
	}

	public void setRatio(float m_Ratio) {
		this.m_Ratio = m_Ratio;
	}

	public float getAttack() {
		return m_Attack;
	}

	public void setAttack(float m_Attack) {
		this.m_Attack = m_Attack;
	}

	public float getDecay() {
		return m_Decay;
	}

	public void setDecay(float m_Decay) {
		this.m_Decay = m_Decay;
	}
}
