package source;
import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();
	Audio audio = Audio.getAudio();

	WavePlayer sine,square,saw,triangle,noise;
	Envelope freqEnv = new Envelope(audio.getAudioContext());
	
	public Oscillator()
	{
		
		sine = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.SINE);
		square = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.SQUARE);
		saw = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.SAW);
		triangle = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.TRIANGLE);
		noise = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.NOISE);
	}
	

}
