package source;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.TapIn;
import net.beadsproject.beads.ugens.TapOut;
import net.beadsproject.beads.ugens.WavePlayer;
import views.GUI;

public class Synthesizer {
	
	GUI gui;
	
	
	Audio audio;
	Settings settings;
	Master master;
	Filter filter;
	ADSR adsr;
	LFO lfo;
	EQ eq;
	
	Oscillator Osc1;
	Oscillator Osc2;
	
	Glide Osc1Glide;
	Glide Osc2Glide;
	
	Glide lfoGlide;
		
	WavePlayer Osc1Wave;
	WavePlayer Osc2Wave;
	
	WavePlayer lfoWave;
	
	BiquadFilter filter1;
	BiquadFilter filter2;
	
	BiquadFilter low;
	BiquadFilter high;
	
	Envelope gainEnvelope;
	
	WavePlayer modulator;
	
 	private TapIn delayIn1, delayIn2;
    private TapOut delayOut1, delayOut2;
	
	Panner panner;

	Gain masterGain;
	
	Gain oscMix;
	Gain osc1Gain;
	Gain osc2Gain;
	Gain filMix;
	Gain fil1Gain;
	Gain fil2Gain;
	Gain delayGain1;
	Gain delayGain2;
	Gain eqGain;
	
	public void initSynth(){
		
		gui = new GUI();
		gui.setVisible(true);
		
		audio = Audio.getAudio();
		settings = Settings.getSettings();
		master= Master.getMaster();
		lfo = LFO.getLfo();
		eq = EQ.getEQ();
		
		Osc1 = new Oscillator();
		Osc2 = new Oscillator();
		
		filter = new Filter();
		
		adsr = ADSR.getADSR();
		
		Osc1Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		Osc2Glide = new Glide(audio.getAudioContext(),settings.START_FREQ);
		
		lfoGlide = new Glide(audio.getAudioContext(), lfo.MIN_FREQ);
		
		Osc1Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		Osc2Wave = new WavePlayer(audio.getAudioContext(),settings.START_FREQ, Osc1.getSine());
		
		lfoWave = new WavePlayer(audio.getAudioContext(), lfo.MIN_FREQ, lfo.getLfoSine());
		
		filter1 = new BiquadFilter(audio.getAudioContext(), 2);
		filter2 = new BiquadFilter(audio.getAudioContext(), 2);
		
		low = new BiquadFilter(audio.getAudioContext(), 2);
		high = new BiquadFilter(audio.getAudioContext(), 2);
		
		gainEnvelope = new Envelope(audio.getAudioContext(),adsr.START_TIME );
				
	    delayIn1 = new TapIn(audio.getAudioContext(), 500.0f);
	    delayIn2 = new TapIn(audio.getAudioContext(), 500.0f);
	    
	    delayOut1 = new TapOut(audio.getAudioContext(), delayIn1, 125.0f);
	    delayOut2 = new TapOut(audio.getAudioContext(), delayIn2, 125.0f);
	    delayGain1 = new Gain(audio.getAudioContext(), 1, master.getOsc1Gain());
	    delayGain2 = new Gain(audio.getAudioContext(), 1, master.getOsc2Gain());
	    
		
		oscMix = new Gain(audio.getAudioContext(), 1);
		osc1Gain = new Gain(audio.getAudioContext(), 1);
		osc2Gain = new Gain(audio.getAudioContext(), 1);
		filMix = new Gain(audio.getAudioContext(), 1);
		fil1Gain = new Gain(audio.getAudioContext(), 1);
		fil2Gain = new Gain(audio.getAudioContext(), 1);
		eqGain = new Gain(audio.getAudioContext(), 1);
		
		panner = new Panner(audio.getAudioContext());
		
		masterGain = new Gain(audio.getAudioContext(), 1, gainEnvelope);
		
		Osc1Wave.setFrequency(Osc1Glide);
		Osc2Wave.setFrequency(Osc2Glide);
		
		lfoWave.setFrequency(lfoGlide);
		
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
		eqGain.addInput(low);
		eqGain.addInput(high);
		panner.addInput(eqGain);
		
		oscMix.addInput(delayGain1);
		oscMix.addInput(delayGain2);
	    

		delayIn1.addInput(osc1Gain);
		delayIn2.addInput(osc2Gain);
		delayGain1.addInput(delayOut1);
		delayGain2.addInput(delayOut2);
	    delayIn1.addInput(delayGain1);
	    delayIn2.addInput(delayGain2);
	    
	    low.addInput(masterGain);
	    high.addInput(masterGain);
	    
		audio.getAudioContext().out.addInput(panner);
		audio.getAudioContext().start();
		
	}
	
	public void Synthesize(){
		
		while(true){
			
			Osc1Wave.setBuffer(Osc1.SelectWave(settings.getWave1Sel()));
			Osc2Wave.setBuffer(Osc2.SelectWave(settings.getWave2Sel()));
			
			lfoWave.setBuffer(lfo.SelectLfoWave(lfo.getLfoWaveSel()));
			
			filter1.setType(filter.SelectFilter(settings.getFilter1Sel()));
			filter2.setType(filter.SelectFilter(settings.getFilter2Sel()));
			
			high.setType(eq.getHigh());
			low.setType(eq.getLow());
			
			Osc1Glide.setValue(settings.getOsc1Freq());
			Osc2Glide.setValue(settings.getOsc2Freq());
			
			lfoGlide.setValue(lfo.getLfoFrq());
			
			delayOut1.setDelay(settings.getDelayIn1Time());
			delayOut2.setDelay(settings.getDelayIn2Time());
			
			
			// ramp the gain to 0.9f over 500 ms
			//change 0.9 to master volume + something
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getAttackTime());
		    // ramp the gain to 0.0f over 500 ms
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getDecayTime());
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getSustainTime());
		    
		    gainEnvelope.addSegment(0.0f, adsr.getReleaseTime());
		    
		    filter.addToFilter1(settings.getFilterWave1(), filter1.containsInput(Osc1Wave), filter1, Osc1Wave);
		    filter.addToFilter2(settings.getFilterWave2(), filter2.containsInput(Osc2Wave), filter2, Osc2Wave);
		    
			filter1.setFrequency(settings.getFilter1Freq());
			filter2.setFrequency(settings.getFilter2Freq());
			
			high.setFrequency(eq.getHighFreq());
			low.setFrequency(eq.getLowFreq());
			high.setGain(eq.getHighGain());
			low.setGain(eq.getLowGain());
			/*
			//0.02HZ to 20HZ
			lfoWave.setFrequency(arg0);
			lfoWave.setBuffer(arg0);
			
			//key trig
			*/
		
			try {
				Thread.sleep((long) (adsr.getAttackTime()+adsr.getDecayTime()+adsr.getReleaseTime()+adsr.getSustainTime()));
				gainEnvelope.clear();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Osc1Wave.getFrequency());
			System.out.println(lfoWave.getFrequency());
			System.out.println(lfoWave.getPhase());
			System.out.println(lfoGlide.getValue());
			lfo.changeFrequency(lfo.getLfoFrq(), settings.getOsc1Freq());
			
			gui.volumeBars(master.getMasterVolume(), master.getPannerPosition());
			//gui.volumeBarsReset();
			
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
