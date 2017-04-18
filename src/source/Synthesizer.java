/*
 * @author Carlo Sarli 
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class Synthesizer.
 */
public class Synthesizer {
	
	/** The gui. */
	GUI gui;
	
	/** The audio. */
	Audio audio;
	
	/** The settings. */
	Settings settings;
	
	/** The master. */
	Master master;
	
	/** The filter. */
	Filter filter;
	
	/** The adsr. */
	ADSR adsr;
	
	/** The lfo. */
	LFO lfo;
	
	/** The eq. */
	EQ eq;
	
	/** The rev. */
	ReverbComponent rev;
	
	/** The comp. */
	CompressorComponent comp;
	
	/** The osc. */
	Oscillator osc;
	
	/** The reverb. */
	Reverb reverb;
	
	/** The compressor. */
	Compressor compressor;
	
	/** The osc settings. */
	OscillatorSettings oscSettings;
	
	/** The fil settings. */
	FilterSettings filSettings;
	
	/** The Osc 1 glide. */
	Glide Osc1Glide;
	
	/** The Osc 2 glide. */
	Glide Osc2Glide;
	
	/** The lfo glide. */
	Glide lfoGlide;
		
	/** The Osc 1 wave. */
	WavePlayer Osc1Wave;
	
	/** The Osc 2 wave. */
	WavePlayer Osc2Wave;
	
	/** The lfo wave. */
	WavePlayer lfoWave;
	
	/** The filter 1. */
	BiquadFilter filter1;
	
	/** The filter 2. */
	BiquadFilter filter2;

	/** The low. */
	BiquadFilter low;
	
	/** The high. */
	BiquadFilter high;
	
	/** The gain envelope. */
	Envelope gainEnvelope;
	
	/** The modulator. */
	WavePlayer modulator;
	
 	/** The delay in 2. */
	 TapIn delayIn1, delayIn2;
    
    /** The delay out 2. */
    TapOut delayOut1, delayOut2;

	/** The master gain. */
	Gain masterGain;
	
	/** The osc mix. */
	Gain oscMix;
	
	/** The osc 1 gain. */
	Gain osc1Gain;
	
	/** The osc 2 gain. */
	Gain osc2Gain;
	
	/** The fil mix. */
	Gain filMix;
	
	/** The fil 1 gain. */
	Gain fil1Gain;
	
	/** The fil 2 gain. */
	Gain fil2Gain;
	
	/** The delay gain 1. */
	Gain delayGain1;
	
	/** The delay gain 2. */
	Gain delayGain2;
	
	/** The eq gain. */
	Gain eqGain;
	
	/** The panner. */
	Panner panner;
	
	
	/**
	 * Inits the synth.
	 */
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
		
		gainEnvelope = new Envelope(audio.getAudioContext(),settings.ADSR_START_TIME );
				
	    
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
		
		panner.addInput(eqGain);
		
		//panner.addInput(reverbGain);
		panner.addInput(compressor);
		
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
	    
	    //reverb.addInput(eqGain);
	    //compressor.addInput(eqGain);
	    
	    //--------------------------------------------AC--------------------------------------
		audio.getAudioContext().out.addInput(panner);
		audio.getAudioContext().out.addInput(reverb);
		audio.getAudioContext().start();
		
	}
	
	/**
	 * Synthesize.
	 */
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
			
			settings.switchReverbOn(reverb, eqGain);
			settings.switchCompressorOn(compressor, eqGain, panner);
			//lfo.controlElement(panner);
			
		}

	}
	
	

}
