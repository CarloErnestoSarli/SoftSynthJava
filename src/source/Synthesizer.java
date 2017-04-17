package source;


import net.beadsproject.beads.ugens.Function;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Compressor;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Panner;
import net.beadsproject.beads.ugens.Reverb;
import net.beadsproject.beads.ugens.TapIn;
import net.beadsproject.beads.ugens.TapOut;
import net.beadsproject.beads.ugens.WavePlayer;
import views.GUI;
import views.VirtualKeyboard;

public class Synthesizer {
	
	GUI gui;
	
	Audio audio;
	Settings settings;
	Master master;
	Filter filter;
	ADSR adsr;
	LFO lfo;
	EQ eq;
	ReverbComponent rev;
	CompressorComponent comp;
	Oscillator osc;
	Reverb reverb;
	Compressor compressor;
	OscillatorSettings oscSettings;
	FilterSettings filSettings;
	
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
	
 	TapIn delayIn1, delayIn2;
    TapOut delayOut1, delayOut2;

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
	Gain reverbGain;
	Gain compressorGain;
	Panner panner;
	
	
	public void initSynth(){
		
		gui = new GUI();
		gui.setVisible(true);
		
		audio = Audio.getAudio();
		settings = Settings.getSettings();
		master= Master.getMaster();
		lfo = LFO.getLfo();
		eq = EQ.getEQ();
		rev = ReverbComponent.getReverbComponent();
		comp = CompressorComponent.getCompressorComponent();
		osc = new Oscillator();
		filter = new Filter();	
		adsr = ADSR.getADSR();
		oscSettings = OscillatorSettings.getOscillatorSettings();
		filSettings = FilterSettings.getFilterSettings();
		 
		
		//--------------------------------------------OSC-------------------------------------
		Osc1Glide = osc.getOsc1Glide();
		Osc2Glide = osc.getOsc2Glide();
		Osc1Wave = osc.getOsc1Wave();
		Osc2Wave = osc.getOsc2Wave();
		delayIn1 = osc.getDelayIn1();
	    delayIn2 = osc.getDelayIn2();  
	    delayOut1 = osc.getDelayOut1();
	    delayOut2 = osc.getDelayOut2();
	    Osc1Wave.setFrequency(Osc1Glide);
		Osc2Wave.setFrequency(Osc2Glide);
		
		//--------------------------------------------FIL-------------------------------------
		filter1 = new BiquadFilter(audio.getAudioContext(), 2);
		filter2 = new BiquadFilter(audio.getAudioContext(), 2);
		low = new BiquadFilter(audio.getAudioContext(), 2);
		high = new BiquadFilter(audio.getAudioContext(), 2);
		
		gainEnvelope = new Envelope(audio.getAudioContext(),adsr.START_TIME );
				
	    
		//--------------------------------------------LFO-------------------------------------
	    lfoGlide = lfo.getLfoGlide();
		lfoWave = lfo.getLfoWave();
		lfoWave.setFrequency(lfoGlide);
		
		//--------------------------------------------REV-------------------------------------
		reverb = rev.getReverb();
		
		//--------------------------------------------COM-------------------------------------
		compressor = comp.getCompressor();
	    
		//--------------------------------------------GAIN------------------------------------
		oscMix = new Gain(audio.getAudioContext(), 1);
		osc1Gain = new Gain(audio.getAudioContext(), 1);
		osc2Gain = new Gain(audio.getAudioContext(), 1);
		filMix = new Gain(audio.getAudioContext(), 1);
		fil1Gain = new Gain(audio.getAudioContext(), 1);
		fil2Gain = new Gain(audio.getAudioContext(), 1);
		eqGain = new Gain(audio.getAudioContext(), 1);
		reverbGain = new Gain(audio.getAudioContext(), 1);
		compressorGain = new Gain(audio.getAudioContext(), 1);
		masterGain = new Gain(audio.getAudioContext(), 1, gainEnvelope);
		delayGain1 = new Gain(audio.getAudioContext(), 1, master.getOsc1Gain());
	    delayGain2 = new Gain(audio.getAudioContext(), 1, master.getOsc2Gain());
		
		//--------------------------------------------PAN-------------------------------------
		panner = new Panner(audio.getAudioContext());
		
		
		
		//--------------------------------------------I/O-------------------------------------
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
		reverbGain.addInput(reverb);
		compressorGain.addInput(compressor);
		
		panner.addInput(compressorGain);
		
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
	    
	    reverb.addInput(eqGain);
	    compressor.addInput(reverbGain);
	    
	  //--------------------------------------------AC--------------------------------------
		audio.getAudioContext().out.addInput(panner);
		audio.getAudioContext().start();
		
	}
	
	public void Synthesize(){
		
		while(true){
			
			Osc1Wave.setBuffer(osc.SelectWave(oscSettings.getWave1Sel()));
			Osc2Wave.setBuffer(osc.SelectWave(oscSettings.getWave2Sel()));
			
			lfoWave.setBuffer(lfo.SelectLfoWave(lfo.getLfoWaveSel()));
			
			filter1.setType(filter.SelectFilter(filSettings.getFilter1Sel()));
			filter2.setType(filter.SelectFilter(filSettings.getFilter2Sel()));
			
			high.setType(eq.getHigh());
			low.setType(eq.getLow());
			
			Osc1Glide.setValue(oscSettings.getOsc1Freq());
			Osc2Glide.setValue(oscSettings.getOsc2Freq());
			
			lfoGlide.setValue(lfo.getLfoFrq());
			
			delayOut1.setDelay(oscSettings.getDelayIn1Time());
			delayOut2.setDelay(oscSettings.getDelayIn2Time());
			
			
			// ramp the gain to 0.9f over 500 ms
			//change 0.9 to master volume + something
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getAttackTime());
		    // ramp the gain to 0.0f over 500 ms
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getDecayTime());
		    //change 0.0 to master volume 
		    gainEnvelope.addSegment(master.getMasterVolume(), adsr.getSustainTime());
		    
		    gainEnvelope.addSegment(0.0f, adsr.getReleaseTime());
		    
		    filter.addToFilter1(filSettings.getFilterWave1(), filter1.containsInput(Osc1Wave), filter1, Osc1Wave);
		    filter.addToFilter2(filSettings.getFilterWave2(), filter2.containsInput(Osc2Wave), filter2, Osc2Wave);
		    
			filter1.setFrequency(filSettings.getFilter1Freq());
			filter2.setFrequency(filSettings.getFilter2Freq());
			
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

			
			gui.volumeBars(master.getMasterVolume(), master.getPannerPosition());
			//gui.volumeBarsReset();
			
			osc1Gain.setGain(master.getOsc1Gain());
			osc2Gain.setGain(master.getOsc2Gain());
			oscMix.setGain(master.getOscMix());
			fil1Gain.setGain(master.getFil1Gain());
			fil2Gain.setGain(master.getFil2Gain());
			filMix.setGain(master.getFilMix());
			panner.setPos(master.getPannerPosition());
			
			reverb.setDamping(rev.getDamping());
			reverb.setSize(rev.getSize());
			reverb.setEarlyReflectionsLevel(rev.getEarlyReflection()/10);
			reverb.setLateReverbLevel(rev.getLateReflection()/10);
			
			compressor.setThreshold(comp.getThreshold());
			compressor.setRatio(comp.getRatio());
			compressor.setAttack(comp.getAttack());
			compressor.setDecay(comp.getDecay());
			
			//lfo.controlElement(panner);
			
		}

	}
	
	

}
