package source;

import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.TapIn;
import net.beadsproject.beads.ugens.TapOut;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {

	Settings settings = new Settings();
	Audio audio = Audio.getAudio();

	private WavePlayer Osc1Wave;
	private WavePlayer Osc2Wave;

	private Glide Osc1Glide;
	private Glide Osc2Glide;

	private TapIn delayIn1;
	private TapIn delayIn2;
	private TapOut delayOut1;
	private TapOut delayOut2;

	Buffer sine, square, saw, triangle, noise;

	public Oscillator() {
		sine = Buffer.SINE;
		square = Buffer.SQUARE;
		saw = Buffer.SAW;
		triangle = Buffer.TRIANGLE;
		noise = Buffer.NOISE;

		setOsc1Glide(new Glide(audio.getAudioContext(), settings.START_FREQ));
		setOsc2Glide(new Glide(audio.getAudioContext(), settings.START_FREQ));

		setOsc1Wave(new WavePlayer(audio.getAudioContext(), settings.START_FREQ, sine));
		setOsc2Wave(new WavePlayer(audio.getAudioContext(), settings.START_FREQ, sine));

		setDelayIn1(new TapIn(audio.getAudioContext(), 500.0f));
		setDelayIn2(new TapIn(audio.getAudioContext(), 500.0f));
		setDelayOut1(new TapOut(audio.getAudioContext(), delayIn1, 125.0f));
		setDelayOut2(new TapOut(audio.getAudioContext(), delayIn2, 125.0f));
	}

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

	// might not need all this
	public Buffer getSine() {
		return sine;
	}

	public Buffer getSquare() {
		return square;
	}

	public Buffer getSaw() {
		return saw;
	}

	public Buffer getTriangle() {
		return triangle;
	}

	public Buffer getNoise() {
		return noise;
	}

	public WavePlayer getOsc1Wave() {
		return Osc1Wave;
	}

	public void setOsc1Wave(WavePlayer osc1Wave) {
		Osc1Wave = osc1Wave;
	}

	public WavePlayer getOsc2Wave() {
		return Osc2Wave;
	}

	public void setOsc2Wave(WavePlayer osc2Wave) {
		Osc2Wave = osc2Wave;
	}

	public Glide getOsc1Glide() {
		return Osc1Glide;
	}

	public void setOsc1Glide(Glide osc1Glide) {
		Osc1Glide = osc1Glide;
	}

	public Glide getOsc2Glide() {
		return Osc2Glide;
	}

	public void setOsc2Glide(Glide osc2Glide) {
		Osc2Glide = osc2Glide;
	}

	public TapIn getDelayIn1() {
		return delayIn1;
	}

	public void setDelayIn1(TapIn delayIn1) {
		this.delayIn1 = delayIn1;
	}

	public TapIn getDelayIn2() {
		return delayIn2;
	}

	public void setDelayIn2(TapIn delayIn2) {
		this.delayIn2 = delayIn2;
	}

	public TapOut getDelayOut1() {
		return delayOut1;
	}

	public void setDelayOut1(TapOut delayOut1) {
		this.delayOut1 = delayOut1;
	}

	public TapOut getDelayOut2() {
		return delayOut2;
	}

	public void setDelayOut2(TapOut delayOut2) {
		this.delayOut2 = delayOut2;
	}

}
