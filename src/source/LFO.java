/**
 * @file LFO.java
 * @author Carlo Sarli 
 * @brief The lfo class initialises the LFO and handles which module it controls and contains functions that adapt the LFO frequency to the appropriate range
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class LFO.
 */
public class LFO extends Settings {

	/** The audio. */
	Audio audio = Audio.getAudio();
	

	/** The lfo. */
	private static LFO lfo = null;

	/** The lfo saw. */
	private Buffer lfoSine, lfoSquare, lfoTriangle, lfoSaw;
	
	/** The m lfo frequency. */
	private float m_lfoFrequency;
	
	/** The m lfo amplitude. */
	private float m_lfoAmplitude;
	
	/** The m lfo wave sel. */
	private String m_lfoWaveSel;
	
	/** The is busy. */
	private boolean isBusy;
	
	/** The lfo controlled. */
	HashMap<UGen, Boolean> lfoControlled = new HashMap<UGen, Boolean>();

	/** The lfo glide. */
	Glide lfoGlide;

	/** The lfo wave. */
	WavePlayer lfoWave; // = new WavePlayer(audio.getAudioContext(), MIN_FREQ, lfoSine);;

	/**
	 * Instantiates a new lfo.
	 */
	protected LFO() {
		
		lfoSine = Buffer.SINE;
		lfoSquare = Buffer.SQUARE;
		lfoSaw = Buffer.SAW;
		lfoTriangle = Buffer.TRIANGLE;

		m_lfoWaveSel = "sine";
		m_lfoFrequency = START_LFO_FREQ/HUNDRED_FACTOR;

		lfoGlide = new Glide(audio.getAudioContext(), m_lfoFrequency);
		// lfoWave = new WavePlayer(audio.getAudioContext(), MIN_FREQ, lfoSine);
		
		lfoWave = new WavePlayer(audio.getAudioContext(), m_lfoFrequency, lfoSine);

	}

	/**
	 * Gets the lfo.
	 *
	 * @return the lfo
	 */
	public static LFO getLfo() {
		if (lfo == null) {
			lfo = new LFO();
		}
		return lfo;
	}

	/**
	 * Select lfo wave.
	 *
	 * @param wave the wave
	 * @return the buffer
	 */
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
	
	/**
	 * Control element.
	 *
	 * @param gen the gen
	 */
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
	*/
	/**
	 * Removes the element.
	 *
	 * @param gen the gen
	 * @param lfo the lfo
	 */
	public void removeElement(UGen gen, WavePlayer lfo) {
		gen.removeAllConnections(lfo);
		isBusy = false;
		lfoControlled.put(gen, isBusy);
	}

	/**
	 * Gets the lfo wave.
	 *
	 * @return the lfo wave
	 */
	public WavePlayer getLfoWave() {
		return lfoWave;
	}

	/**
	 * Gets the lfo glide.
	 *
	 * @return the lfo glide
	 */
	public Glide getLfoGlide() {
		return lfoGlide;
	}

	/**
	 * Sets the lfo freq.
	 *
	 * @param freq the new lfo freq
	 */
	public void setLfoFreq(float freq) {
		m_lfoFrequency = freq;
	}

	/**
	 * Sets the lfo wave sel.
	 *
	 * @param wave the new lfo wave sel
	 */
	public void setLfoWaveSel(String wave) {
		m_lfoWaveSel = wave;
	}
	
	/**
	 * Sets the lfo amplitude.
	 *
	 * @param ampl the new lfo amplitude
	 */
	public void setLfoAmplitude(float ampl){
		m_lfoAmplitude = ampl;
	}

	/**
	 * Gets the lfo frq.
	 *
	 * @return the lfo frq
	 */
	public float getLfoFrq() {
		return m_lfoFrequency;
	}

	/**
	 * Gets the lfo wave sel.
	 *
	 * @return the lfo wave sel
	 */
	public String getLfoWaveSel() {
		return m_lfoWaveSel;
	}

	/**
	 * Gets the lfo sine.
	 *
	 * @return the lfo sine
	 */
	public Buffer getLfoSine() {
		return lfoSine;
	}

	/**
	 * Gets the checks if is busy.
	 *
	 * @return the checks if is busy
	 */
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

	/**
	 * Gets the lfo amplitude.
	 *
	 * @return the lfo amplitude
	 */
	public float getLfoAmplitude() {
		// TODO Auto-generated method stub
		return m_lfoAmplitude;
	}
	 
}
