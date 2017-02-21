import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();

	WavePlayer sine,square,saw,triangle,noise;
	
	sine = new WavePlayer(ac,settings.getOsc1Freq(),Buffer.SINE);
	square = new WavePlayer(ac,settings.getOsc1Freq(),Buffer.SQUARE);
	saw = new WavePlayer(ac,settings.getOsc1Freq(),Buffer.SAW);
	triangle = new WavePlayer(ac,settings.getOsc1Freq(),Buffer.TRIANGLE);
	noise = new WavePlayer(ac,settings.getOsc1Freq(),Buffer.NOISE);
	
}
