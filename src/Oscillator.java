import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();
	Audio audio = new Audio();

	WavePlayer sine,square,saw,triangle,noise;
	public Oscillator(){
	sine = new WavePlayer(audio.getAudioContext(),settings.getOsc1Freq(),Buffer.SINE);
	square = new WavePlayer(audio.getAudioContext(),settings.getOsc1Freq(),Buffer.SQUARE);
	saw = new WavePlayer(audio.getAudioContext(),settings.getOsc1Freq(),Buffer.SAW);
	triangle = new WavePlayer(audio.getAudioContext(),settings.getOsc1Freq(),Buffer.TRIANGLE);
	noise = new WavePlayer(audio.getAudioContext(),settings.getOsc1Freq(),Buffer.NOISE);
	}
}
