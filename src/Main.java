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
		
		Oscillator Osc1 = new Oscillator();
		Oscillator Osc2 = new Oscillator();
		
		Glide Osc1Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		Glide Osc2Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		
		WavePlayer Osc1Wave = Osc1.SelectWave(settings.getWaveSel());
		WavePlayer Osc2Wave = Osc2.SelectWave(settings.getWaveSel());
		//WavePlayer square = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SQUARE);
		
		Gain g = new Gain(audio.getAudioContext(), 1, 0.1f);
		
		Osc1Wave.setFrequency(Osc1Glide);
		Osc2Wave.setFrequency(Osc2Glide);
		//square.setFrequency(Osc2Glide);
		
		g.addInput(Osc1Wave);
		g.addInput(Osc2Wave);
		
		audio.getAudioContext().out.addInput(g);
		audio.getAudioContext().start();
		
		while(true){
			
			
			Osc1Glide.setValue(settings.getOsc1Freq());
			Osc2Glide.setValue(settings.getOsc2Freq());
			System.out.println(settings.getOsc1Freq());
		}

	}

}
