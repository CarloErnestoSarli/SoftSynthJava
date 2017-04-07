package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.AllpassFilter;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.LPRezFilter;
import net.beadsproject.beads.ugens.WavePlayer;

public class Filter {
	
	Audio audio =  Audio.getAudio();
	
	Glide filterFrequencyGlide  = new Glide(audio.getAudioContext(), 0.0f, 500.0f);
	Glide filterResonanceGlide = new Glide(audio.getAudioContext(), 0.0F, 500.0f);
	
	LPRezFilter lprf;
	BiquadFilter.Type lpf,hpf,apf;
	
	//AllpassFilter allPass;
	
	
	
	public Filter(){
		
		 lprf = new LPRezFilter(audio.getAudioContext(), filterFrequencyGlide, 0.95f);
		 hpf =  BiquadFilter.BUTTERWORTH_HP;
		 lpf =  BiquadFilter.BUTTERWORTH_LP;
		 apf =  BiquadFilter.AP;
	
	}
	
	
	public BiquadFilter.Type SelectFilter(String filter){
		
		if(filter.equals("LowPass")){
			return lpf;
		}else if(filter.equals("HighPass")){
			return hpf;
		}else if(filter.equals("AllPass")){
			return apf;
		}else{
			return lpf;
		}
	}
	
	public void addToFilter1(boolean filterWave1, boolean containsWave, BiquadFilter filter1, WavePlayer osc1Wave){
		
		if(filterWave1 && !containsWave){
			filter1.addInput(osc1Wave);
		}else if(filterWave1 && containsWave){
			//do nothing
		}else{
			filter1.removeAllConnections(osc1Wave);
		}
	}
	
	public void addToFilter2(boolean filterWave2, boolean containsWave, BiquadFilter filter2, WavePlayer osc2Wave){
		
		if(filterWave2 && !containsWave){
			filter2.addInput(osc2Wave);
		}else if(filterWave2 && containsWave){
			//do nothing
		}else{
			filter2.removeAllConnections(osc2Wave);
		}
	}
	
	public LPRezFilter getLowRezPass(){
		return lprf;
	}
	
	
	public void addToFilter(BiquadFilter filter, UGen gen){
		filter.addInput(gen);
		
	}

	
	public void removeFromLowRezPass(UGen gen){
		lprf.clearInputConnections();
	}
	
	public void removeFromFilter(BiquadFilter filter, UGen gen){
		filter.clearInputConnections();
	}
	
	
	
}
