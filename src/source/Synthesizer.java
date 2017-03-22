package source;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.WavePlayer;
import views.GUI;

public class Synthesizer {
	
	GUI gui;
	
	
	Audio audio;
	Settings settings;
	
	Oscillator Osc1;
	Oscillator Osc2;
	
	Filter filter;
	
	Glide Osc1Glide;
	Glide Osc2Glide;
	
	WavePlayer Osc1Wave;
	WavePlayer Osc2Wave;
	
	BiquadFilter f;
	
	WavePlayer modulator;

	Gain g;
	
	public void initSynth(){
		
		gui = new GUI();
		gui.setVisible(true);
		
		audio = Audio.getAudio();
		settings = Settings.getSettings();
		
		Osc1 = new Oscillator();
		Osc2 = new Oscillator();
		
		filter = new Filter();
		
		Osc1Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		Osc2Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		
		Osc1Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		Osc2Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		
		f = new BiquadFilter(audio.getAudioContext(), 2);
		//WavePlayer square = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SQUARE);
		modulator = new WavePlayer(audio.getAudioContext(), 60.0f, Buffer.SINE);
		
		g = new Gain(audio.getAudioContext(), 1, 0.1f);
		
		Osc1Wave.setFrequency(Osc1Glide);
		Osc2Wave.setFrequency(Osc2Glide);
		//square.setFrequency(Osc2Glide);
	 
		g.addInput(Osc1Wave);
		g.addInput(Osc2Wave);
		g.addInput(f);
		
		audio.getAudioContext().out.addInput(g);
		audio.getAudioContext().start();
	}
	
	public void Synthesize(){
		
		while(true){
			
			Osc1Wave.setBuffer(Osc1.SelectWave(settings.getWave1Sel()));
			Osc2Wave.setBuffer(Osc2.SelectWave(settings.getWave2Sel()));
			
			f.setType(filter.SelectFilter(settings.getFilterSel()));
			
			Osc1Glide.setValue(settings.getOsc1Freq());
			Osc2Glide.setValue(settings.getOsc2Freq());
			System.out.println(settings.getOsc1Freq());
			
			if(settings.getFilterWave1()){
				f.addInput(Osc1Wave);
			}else{
				f.removeAllConnections(Osc1Wave);
			}
			
			if(settings.getFilterWave2()){
				f.addInput(Osc2Wave);
			}else{
				f.removeAllConnections(Osc2Wave);
			}
			
			f.setFrequency(settings.getFilterFreq());
			System.out.println(f.getFrequency());
			f.setGain(settings.getFilterGain());
			System.out.println(f.getGain());
		}

	}

}
