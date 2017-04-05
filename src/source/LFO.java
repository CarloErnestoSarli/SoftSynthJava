package source;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.WavePlayer;

public class LFO {
	
	Audio audio = Audio.getAudio();

	private static LFO lfo = null;

	public static final float MIN_FREQ = 0.02f;
	private final float MAX_FREQ = 20.0f;

	private Buffer lfoSine, lfoSquare, lfoTriangle, lfoSaw;
	private float m_lfoFrequency;
	private String m_lfoWaveSel;

	Glide lfoGlide;

	WavePlayer lfoWave;

	protected LFO() {

		lfoSine = Buffer.SINE;
		lfoSquare = Buffer.SQUARE;
		lfoSaw = Buffer.SAW;
		lfoTriangle = Buffer.TRIANGLE;
		
		m_lfoWaveSel = "sine";
		//m_lfoFrequency = MIN_FREQ;
		
		lfoGlide = new Glide(audio.getAudioContext(), m_lfoFrequency);
		//lfoWave = new WavePlayer(audio.getAudioContext(), MIN_FREQ, lfoSine);

	}

	public static LFO getLfo() {
		if (lfo == null) {
			lfo = new LFO();
		}
		return lfo;
	}

	public Buffer SelectLfoWave(String wave) {

		if (wave.equals("Sine")) {
			return lfoSine;
		} else if (wave.equals("Square")) {
			return lfoSquare;
		} else if (wave.equals("Saw")) {
			return lfoSaw;
		} else if (wave.equals("Triangle")) {
			return lfoTriangle;
		} else {
			return lfoSine;
		}
	}
	
	public void changeFrequency(float l, float freq){
		
		float addFreq = l;
		System.out.println("lfo freq" + addFreq);
		float newFreq = addFreq + freq;
	}

	public WavePlayer getLfoWave() {
		return lfoWave;
	}
	
	public Glide getLfoGlide(){
		return lfoGlide;
	}

	public void setLfoFreq(float freq) {
		m_lfoFrequency = freq;
	}
	
	public void setLfoWaveSel(String wave) {
		m_lfoWaveSel = wave;
	}

	public float getLfoFrq() {
		return m_lfoFrequency;
	}
	
	public String getLfoWaveSel() {
		return m_lfoWaveSel;
	}
	
	public Buffer getLfoSine(){
		return lfoSine;
	}
}
