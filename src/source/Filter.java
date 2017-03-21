package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.ugens.AllpassFilter;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.LPRezFilter;

public class Filter {
	
	Audio audio =  Audio.getAudio();
	
	Glide filterFrequencyGlide  = new Glide(audio.getAudioContext(), 0.0f, 500.0f);
	Glide filterResonanceGlide = new Glide(audio.getAudioContext(), 0.0F, 500.0f);
	
	LPRezFilter lprf;
	BiquadFilter hpf;
	BiquadFilter lpf;
	BiquadFilter apf;
	//AllpassFilter allPass;
	
	
	
	public Filter(){
		 lprf = new LPRezFilter(audio.getAudioContext(), filterFrequencyGlide, 0.95f);
		 hpf =  new BiquadFilter(audio.getAudioContext(), 2, BiquadFilter.HP);
		 lpf =  new BiquadFilter(audio.getAudioContext(), 2, BiquadFilter.LP);
		 apf =  new BiquadFilter(audio.getAudioContext(), 2, BiquadFilter.AP);
	}
	

	
	
	public LPRezFilter getLowRezPass(){
		return lprf;
	}
	
	public BiquadFilter getLowPass(){
		return lpf;
	}
	
	public BiquadFilter getHighPass(){
		return hpf;
	}
	
	public BiquadFilter getAllPass(){
		return apf;
	}
	
	
	
	public void addToLowRezPass(UGen gen){
		lprf.addInput(gen);
	}
	
	public void addToLowPass(UGen gen){
		lpf.addInput(gen);
	}
	
	public void addToHighPass(UGen gen){
		hpf.addInput(gen);
	}
	
	public void addToAllPass(UGen gen){
		apf.addInput(gen);
	}
	
	
	
	
	public void removeFromLowRezPass(UGen gen){
		lprf.clearInputConnections();
	}
	
	public void removeFromLowPass(UGen gen){
		lpf.clearInputConnections();
	}
	
	public void removeFromHighPass(UGen gen){
		hpf.clearInputConnections();
	}
	
	public void removeFromAllPass(UGen gen){
		apf.clearInputConnections();
	}
	
	
	
	public void setLpfFrequency(float freq){
		lpf.setFreq(freq);
	}
	
	public void setLpfGain(float gain){
		lpf.setGain(gain);
	}
	
}
