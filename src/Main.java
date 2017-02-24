import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Noise;
import net.beadsproject.beads.ugens.WavePlayer;
import views.*;
import source.*;


public class Main {



	public static void main(String[] args) {
		
		GUI gui = new GUI();
		gui.setVisible(true);
		
		Audio audio = Audio.getAudio();
		Settings settings = Settings.getSettings();
		
		
		Glide glide = new Glide(audio.getAudioContext(),440.0f);
		WavePlayer sine = new WavePlayer(audio.getAudioContext(),glide,Buffer.SINE);
		WavePlayer square = new WavePlayer(audio.getAudioContext(),glide,Buffer.SQUARE);
		Gain g = new Gain(audio.getAudioContext(), 1, 0.1f);
		
		//g.addInput(sine);
		//g.addInput(square);
		
		audio.getAudioContext().out.addInput(sine);
		audio.getAudioContext().start();
		
		while(true){
			
			
			glide.setValue(settings.getOsc1Freq());
			System.out.println(settings.getOsc1Freq());
		}

	}

}
