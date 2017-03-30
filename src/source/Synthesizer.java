package source;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.WavePlayer;
import views.GUI;

public class Synthesizer {
	
	GUI gui;
	
	
	Audio audio;
	Settings settings;
	Master master;
	Filter filter;
	ADSR adsr;
	
	Oscillator Osc1;
	Oscillator Osc2;
	
	Glide Osc1Glide;
	Glide Osc2Glide;
	
	WavePlayer Osc1Wave;
	WavePlayer Osc2Wave;
	
	BiquadFilter filter1;
	BiquadFilter filter2;
	
	Envelope gainEnvelope;
	
	WavePlayer modulator;
	
	Panner panner;

	Gain masterGain;
	
	Gain oscMix;
	Gain osc1Gain;
	Gain osc2Gain;
	Gain filMix;
	Gain fil1Gain;
	Gain fil2Gain;
	
	public void initSynth(){
		
		gui = new GUI();
		gui.setVisible(true);
		
		audio = Audio.getAudio();
		settings = Settings.getSettings();
		master= Master.getMaster();
		
		Osc1 = new Oscillator();
		Osc2 = new Oscillator();
		
		filter = new Filter();
		
		adsr = adsr.getADSR();
		
		Osc1Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		Osc2Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		
		Osc1Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		Osc2Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		
		filter1 = new BiquadFilter(audio.getAudioContext(), 2);
		filter2 = new BiquadFilter(audio.getAudioContext(), 2);
		//WavePlayer square = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SQUARE);
		gainEnvelope = new Envelope(audio.getAudioContext(),adsr.START_TIME );
				
		modulator = new WavePlayer(audio.getAudioContext(), 60.0f, Buffer.SINE);
		
		oscMix = new Gain(audio.getAudioContext(), 1);
		osc1Gain = new Gain(audio.getAudioContext(), 1);
		osc2Gain = new Gain(audio.getAudioContext(), 1);
		filMix = new Gain(audio.getAudioContext(), 1);
		fil1Gain = new Gain(audio.getAudioContext(), 1);
		fil2Gain = new Gain(audio.getAudioContext(), 1);
		
		panner = new Panner(audio.getAudioContext());
		
		masterGain = new Gain(audio.getAudioContext(), 1, gainEnvelope);
		
		Osc1Wave.setFrequency(Osc1Glide);
		Osc2Wave.setFrequency(Osc2Glide);
		//square.setFrequency(Osc2Glide);
		
		
		osc1Gain.addInput(Osc1Wave);
		osc2Gain.addInput(Osc2Wave);
		oscMix.addInput(osc1Gain);
		oscMix.addInput(osc2Gain);
		fil1Gain.addInput(filter1);
		fil2Gain.addInput(filter2);
		filMix.addInput(fil1Gain);
		filMix.addInput(fil2Gain);
		masterGain.addInput(oscMix);
		masterGain.addInput(filMix);
		panner.addInput(masterGain);
		/*
		masterGain.addInput(Osc1Wave);
		masterGain.addInput(Osc2Wave);
		masterGain.addInput(filter1);
		masterGain.addInput(filter2);
		*/
		audio.getAudioContext().out.addInput(panner);
		audio.getAudioContext().start();
	}
	
	public void Synthesize(){
		
		while(true){
			
			Osc1Wave.setBuffer(Osc1.SelectWave(settings.getWave1Sel()));
			Osc2Wave.setBuffer(Osc2.SelectWave(settings.getWave2Sel()));
			
			filter1.setType(filter.SelectFilter(settings.getFilter1Sel()));
			filter2.setType(filter.SelectFilter(settings.getFilter2Sel()));
			
			Osc1Glide.setValue(settings.getOsc1Freq());
			Osc2Glide.setValue(settings.getOsc2Freq());
			//System.out.println(settings.getOsc1Freq());
			
			Osc1Wave.setPhase(settings.getWave1Phase());
			Osc2Wave.setPhase(settings.getWave2Phase());
			
			// ramp the gain to 0.9f over 500 ms
			//change 0.9 to master volume + something
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getAttackTime());
		    // ramp the gain to 0.0f over 500 ms
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getDecayTime());
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getSustainTime());
		    
		    gainEnvelope.addSegment(0.0f, adsr.getReleaseTime());

			
			if(settings.getFilterWave1() && !filter1.containsInput(Osc1Wave)){
				filter1.addInput(Osc1Wave);
			}else if(settings.getFilterWave1()&& filter1.containsInput(Osc1Wave)){
				//do nothing
			}else{
				filter1.removeAllConnections(Osc1Wave);
			}
			
			if(settings.getFilterWave2()&& !filter2.containsInput(Osc2Wave)){
				filter2.addInput(Osc2Wave);
			}else if(settings.getFilterWave2()&& filter2.containsInput(Osc2Wave)){
				//do nothing
			}else{
				filter2.removeAllConnections(Osc2Wave);
			}
			
			filter1.setFrequency(settings.getFilter1Freq());
			filter2.setFrequency(settings.getFilter2Freq());
			
			try {
				Thread.sleep((long) (adsr.getAttackTime()+adsr.getDecayTime()+adsr.getReleaseTime()+adsr.getSustainTime()));
				gainEnvelope.clear();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			osc1Gain.setGain(master.getOsc1Gain());
			osc2Gain.setGain(master.getOsc2Gain());
			oscMix.setGain(master.getOscMix());
			fil1Gain.setGain(master.getFil1Gain());
			fil2Gain.setGain(master.getFil2Gain());
			filMix.setGain(master.getFilMix());
			panner.setPos(master.getPannerPosition());
			
		}

	}
	
	private float pitchToFrequency(int midiPitch)
	{
		/*
		 *  MIDI pitch number to frequency conversion equation from
		 *  http://newt.phys.unsw.edu.au/jw/notes.html
		 *  fn  =  2^(n/12)*440 Hz.
		 */
		double exponent = (midiPitch - 69.0) / 12.0;
		return (float)(Math.pow(2, exponent) * 440.0f);
	}

}
