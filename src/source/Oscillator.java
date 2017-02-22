package source;
import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();
	Audio audio = new Audio();

	WavePlayer sine,square,saw,triangle,noise;
	
	public Oscillator(float freq)
	{
		
		sine = new WavePlayer(audio.getAudioContext(),freq,Buffer.SINE);
		square = new WavePlayer(audio.getAudioContext(),freq,Buffer.SQUARE);
		saw = new WavePlayer(audio.getAudioContext(),freq,Buffer.SAW);
		triangle = new WavePlayer(audio.getAudioContext(),freq,Buffer.TRIANGLE);
		noise = new WavePlayer(audio.getAudioContext(),freq,Buffer.NOISE);
	}
}
