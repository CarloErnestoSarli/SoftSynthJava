/*
 * @author Carlo Sarli 
 * 
 */
package source;

import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.TapIn;
import net.beadsproject.beads.ugens.TapOut;
import net.beadsproject.beads.ugens.WavePlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class Oscillator.
 */
public class Oscillator extends Settings{

	/** The settings. */
	Settings settings = Settings.getSettings();
	
	/** The audio. */
	Audio audio = Audio.getAudio();

	/** The Osc 1 wave. */
	private WavePlayer Osc1Wave;
	
	/** The Osc 2 wave. */
	private WavePlayer Osc2Wave;

	/** The Osc 1 glide. */
	private Glide Osc1Glide;
	
	/** The Osc 2 glide. */
	private Glide Osc2Glide;

	/** The delay in 1. */
	private TapIn delayIn1;
	
	/** The delay in 2. */
	private TapIn delayIn2;
	
	/** The delay out 1. */
	private TapOut delayOut1;
	
	/** The delay out 2. */
	private TapOut delayOut2;

	/** The noise. */
	Buffer sine, square, saw, triangle, noise;

	/**
	 * Instantiates a new oscillator.
	 */
	public Oscillator() {
		sine = Buffer.SINE;
		square = Buffer.SQUARE;
		saw = Buffer.SAW;
		triangle = Buffer.TRIANGLE;
		noise = Buffer.NOISE;

		setOsc1Glide(new Glide(audio.getAudioContext()));
		setOsc2Glide(new Glide(audio.getAudioContext()));

		setOsc1Wave(new WavePlayer(audio.getAudioContext(), OSC_START_FREQ/HUNDRED_FACTOR, sine));
		setOsc2Wave(new WavePlayer(audio.getAudioContext(), OSC_START_FREQ/HUNDRED_FACTOR, sine));

		setDelayIn1(new TapIn(audio.getAudioContext(), 500.0f));
		setDelayIn2(new TapIn(audio.getAudioContext(), 500.0f));
		setDelayOut1(new TapOut(audio.getAudioContext(), delayIn1, 125.0f));
		setDelayOut2(new TapOut(audio.getAudioContext(), delayIn2, 125.0f));
	}

	/**
	 * Select wave.
	 *
	 * @param wave the wave
	 * @return the buffer
	 */
	public Buffer SelectWave(String wave) {

		if (wave.equals("Sine")) {
			return sine;
		} else if (wave.equals("Square")) {
			return square;
		} else if (wave.equals("Saw")) {
			return saw;
		} else if (wave.equals("Triangle")) {
			return triangle;
		} else if (wave.equals("Noise")) {
			return noise;
		} else {
			return sine;
		}
	}

	/**
	 * Gets the sine.
	 *
	 * @return the sine
	 */
	// might not need all this
	public Buffer getSine() {
		return sine;
	}

	/**
	 * Gets the square.
	 *
	 * @return the square
	 */
	public Buffer getSquare() {
		return square;
	}

	/**
	 * Gets the saw.
	 *
	 * @return the saw
	 */
	public Buffer getSaw() {
		return saw;
	}

	/**
	 * Gets the triangle.
	 *
	 * @return the triangle
	 */
	public Buffer getTriangle() {
		return triangle;
	}

	/**
	 * Gets the noise.
	 *
	 * @return the noise
	 */
	public Buffer getNoise() {
		return noise;
	}

	/**
	 * Gets the osc 1 wave.
	 *
	 * @return the osc 1 wave
	 */
	public WavePlayer getOsc1Wave() {
		return Osc1Wave;
	}

	/**
	 * Sets the osc 1 wave.
	 *
	 * @param osc1Wave the new osc 1 wave
	 */
	public void setOsc1Wave(WavePlayer osc1Wave) {
		Osc1Wave = osc1Wave;
	}

	/**
	 * Gets the osc 2 wave.
	 *
	 * @return the osc 2 wave
	 */
	public WavePlayer getOsc2Wave() {
		return Osc2Wave;
	}

	/**
	 * Sets the osc 2 wave.
	 *
	 * @param osc2Wave the new osc 2 wave
	 */
	public void setOsc2Wave(WavePlayer osc2Wave) {
		Osc2Wave = osc2Wave;
	}

	/**
	 * Gets the osc 1 glide.
	 *
	 * @return the osc 1 glide
	 */
	public Glide getOsc1Glide() {
		return Osc1Glide;
	}

	/**
	 * Sets the osc 1 glide.
	 *
	 * @param osc1Glide the new osc 1 glide
	 */
	public void setOsc1Glide(Glide osc1Glide) {
		Osc1Glide = osc1Glide;
	}

	/**
	 * Gets the osc 2 glide.
	 *
	 * @return the osc 2 glide
	 */
	public Glide getOsc2Glide() {
		return Osc2Glide;
	}

	/**
	 * Sets the osc 2 glide.
	 *
	 * @param osc2Glide the new osc 2 glide
	 */
	public void setOsc2Glide(Glide osc2Glide) {
		Osc2Glide = osc2Glide;
	}

	/**
	 * Gets the delay in 1.
	 *
	 * @return the delay in 1
	 */
	public TapIn getDelayIn1() {
		return delayIn1;
	}

	/**
	 * Sets the delay in 1.
	 *
	 * @param delayIn1 the new delay in 1
	 */
	public void setDelayIn1(TapIn delayIn1) {
		this.delayIn1 = delayIn1;
	}

	/**
	 * Gets the delay in 2.
	 *
	 * @return the delay in 2
	 */
	public TapIn getDelayIn2() {
		return delayIn2;
	}

	/**
	 * Sets the delay in 2.
	 *
	 * @param delayIn2 the new delay in 2
	 */
	public void setDelayIn2(TapIn delayIn2) {
		this.delayIn2 = delayIn2;
	}

	/**
	 * Gets the delay out 1.
	 *
	 * @return the delay out 1
	 */
	public TapOut getDelayOut1() {
		return delayOut1;
	}

	/**
	 * Sets the delay out 1.
	 *
	 * @param delayOut1 the new delay out 1
	 */
	public void setDelayOut1(TapOut delayOut1) {
		this.delayOut1 = delayOut1;
	}

	/**
	 * Gets the delay out 2.
	 *
	 * @return the delay out 2
	 */
	public TapOut getDelayOut2() {
		return delayOut2;
	}

	/**
	 * Sets the delay out 2.
	 *
	 * @param delayOut2 the new delay out 2
	 */
	public void setDelayOut2(TapOut delayOut2) {
		this.delayOut2 = delayOut2;
	}

}
