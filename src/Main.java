import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Noise;
import net.beadsproject.beads.ugens.WavePlayer;
import views.*;
import source.*;


public class Main {
	
	

	public static void main(String[] args) {
		
		Synthesizer synth = new Synthesizer();
		
		synth.initSynth();
		
		synth.Synthesize();
		
		
	}
	
}
