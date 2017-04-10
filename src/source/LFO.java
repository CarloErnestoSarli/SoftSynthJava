package source;

import net.beadsproject.beads.core.UGen;
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
	private boolean isBusy;

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
	
	public void controlElement(UGen gen, WavePlayer lfo){
		if(isBusy == true){
			removeElement(gen, lfo);
		}
		gen.addInput(lfo);
		isBusy = true;
	}
	
	public void removeElement(UGen gen, WavePlayer lfo){
		gen.removeAllConnections(lfo);
		isBusy = false;
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
	
	public boolean getIsBusy(){
		return isBusy;
	}
}
