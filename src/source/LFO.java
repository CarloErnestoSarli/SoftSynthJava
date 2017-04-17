package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Function;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.WavePlayer;
import java.util.HashMap;

public class LFO {

	Audio audio = Audio.getAudio();

	private static LFO lfo = null;

	public static final float MIN_FREQ = 0.02f;
	private final float MAX_FREQ = 20.0f;

	private Buffer lfoSine, lfoSquare, lfoTriangle, lfoSaw;
	private float m_lfoFrequency;
	private float m_lfoAmplitude;
	private String m_lfoWaveSel;
	private boolean isBusy;
	
	HashMap<UGen, Boolean> lfoControlled = new HashMap<UGen, Boolean>();

	Glide lfoGlide;

	WavePlayer lfoWave; // = new WavePlayer(audio.getAudioContext(), MIN_FREQ, lfoSine);;

	protected LFO() {
		
		lfoSine = Buffer.SINE;
		lfoSquare = Buffer.SQUARE;
		lfoSaw = Buffer.SAW;
		lfoTriangle = Buffer.TRIANGLE;

		m_lfoWaveSel = "sine";
		m_lfoFrequency = MIN_FREQ;

		lfoGlide = new Glide(audio.getAudioContext(), m_lfoFrequency);
		// lfoWave = new WavePlayer(audio.getAudioContext(), MIN_FREQ, lfoSine);
		
		lfoWave = new WavePlayer(audio.getAudioContext(), m_lfoFrequency, lfoSine);

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
	/*
	Function oscFrequencyLfo = new Function(lfoWave) { 
		
		 public float calculate() { // set the filter cutoff to oscillate between 1500Hz // and 2500Hz 
		 return ((x[0] * 985.0f) + 15.0f); 
		 }
	};
	
	Function filterFrequencyLfo = new Function(lfoWave) { 
		
		 public float calculate() { // set the filter cutoff to oscillate between 1500Hz // and 2500Hz 
		 return ((x[0] * 985.0f) + 15.0f); 
		 }
	};
	
	Function volumeGainLfo = new Function(lfoWave) { 
		
		 public float calculate() { // set the filter cutoff to oscillate between 1500Hz // and 2500Hz 
		 return ((x[0] * 0.9f) + 0.1f); 
		 }
	};
	
	Function pannerPosLfo = new Function(lfoWave) { 

		 public float calculate() { // set the filter cutoff to oscillate between 1500Hz // and 2500Hz 
			 return (x[0] * 1.0f) + (-1.0f);
		 }
	};
	*/
	public void controlElement(UGen gen) {
		//if (lfoControlled.get(gen)) {
			//removeElement(gen, lfoWave);
		//}
		if(gen instanceof WavePlayer){
			((WavePlayer) gen).setFrequency(oscFrequencyLfo);		
		}else if(gen instanceof BiquadFilter){
			((BiquadFilter) gen).setFrequency(filterFrequencyLfo);
		}else if(gen instanceof Gain){
			((Gain) gen).setGain(volumeGainLfo);
		}else if (gen instanceof Panner){
			((Panner) gen).setPos(lfoWave);
		}
		//isBusy = true;
		//lfoControlled.put(gen, isBusy);
	}

	public void removeElement(UGen gen, WavePlayer lfo) {
		gen.removeAllConnections(lfo);
		isBusy = false;
		lfoControlled.put(gen, isBusy);
	}

	public WavePlayer getLfoWave() {
		return lfoWave;
	}

	public Glide getLfoGlide() {
		return lfoGlide;
	}

	public void setLfoFreq(float freq) {
		m_lfoFrequency = freq;
	}

	public void setLfoWaveSel(String wave) {
		m_lfoWaveSel = wave;
	}
	public void setLfoAmplitude(float ampl){
		m_lfoAmplitude = ampl;
	}

	public float getLfoFrq() {
		return m_lfoFrequency;
	}

	public String getLfoWaveSel() {
		return m_lfoWaveSel;
	}

	public Buffer getLfoSine() {
		return lfoSine;
	}

	public boolean getIsBusy() {
		return isBusy;
	}
	/*
	Function filterEnvelope = new Function(lfoWave) {
		public float calculate() {
			// x[0] = envelope
			// 5000.0f = maximum frequency
			// 20.0f = minimum frequency
			return (x[0] * 5000.0f) + 2.0f;
		}
	};
	*/

	public float getLfoAmplitude() {
		// TODO Auto-generated method stub
		return m_lfoAmplitude;
	}
	 
}
