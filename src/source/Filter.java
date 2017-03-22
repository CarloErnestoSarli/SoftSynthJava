package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.AllpassFilter;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.LPRezFilter;

public class Filter {
	
	Audio audio =  Audio.getAudio();
	
	Glide filterFrequencyGlide  = new Glide(audio.getAudioContext(), 0.0f, 500.0f);
	Glide filterResonanceGlide = new Glide(audio.getAudioContext(), 0.0F, 500.0f);
	
	LPRezFilter lprf;
	BiquadFilter.Type lpf,hpf,apf;
	
	//AllpassFilter allPass;
	
	
	
	public Filter(){
		
		 lprf = new LPRezFilter(audio.getAudioContext(), filterFrequencyGlide, 0.95f);
		 hpf =  BiquadFilter.HP;
		 lpf =  BiquadFilter.LP;
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
