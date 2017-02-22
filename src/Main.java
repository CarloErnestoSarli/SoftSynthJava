import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Noise;
import net.beadsproject.beads.ugens.WavePlayer;
import views.*;
import source.*;


public class Main {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui = new GUI();
		gui.setVisible(true);
		
		/*
		Settings settings = new Settings();
		Oscillator osc1 = new Oscillator();
		Audio audio = Audio.getAudio();
		Envelope freqEnv = new Envelope(audio.getAudioContext(),500);
		WavePlayer sine = new WavePlayer(audio.getAudioContext(),freqEnv,Buffer.SINE);
		freqEnv.addSegment(settings.getOsc1Freq(), 1000);
		Gain g = new Gain(audio.getAudioContext(), 1, 0.1f);
		*/
		/*
		 * Now things get interesting. You can plug UGens into other UGens,
		 * making chains of audio processing units. Here we're just going to
		 * plug the Noise object into the Gain object, and the Gain object into
		 * the main audio output (ac.out). In this case, the Noise object has
		 * one output, the Gain object has one input and one output, and the
		 * ac.out object has two inputs. The method addInput() does its best to
		 * work out what to do. For example, when connecting the Gain to the out
		 * object, the output of the Gain object gets connected to both channels
		 * of the output object.
		 */
		/*
		g.addInput(sine);
		//ac.out.addInput(wp);
		audio.getAudioContext().out.addInput(g);
		audio.getAudioContext().start();
		// start audio processing
		//ac.start();
		*/
		// create an AudioContext
		AudioContext ac = new AudioContext();
		Settings settings = new Settings();
		// create a sine generator
		WavePlayer carrier = new WavePlayer(ac, 440.0f, Buffer.SINE);

		// create a WavePlayer to control the gain
		WavePlayer modulator = new WavePlayer(ac, 60.0f, Buffer.SINE);
		// create a Gain to control the sine volume
		Gain sineGain = new Gain(ac, 1, modulator);

		// add the sine generator as an input to the Gain
		sineGain.addInput(carrier);

		// add the Gain as an input to the master output, ac.out
		ac.out.addInput(sineGain);

		// begin audio processing
		ac.start();

	}

}
