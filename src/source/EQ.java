package source;

import net.beadsproject.beads.ugens.BiquadFilter;

public class EQ {
	
	private static EQ eq = null;
	BiquadFilter.Type low;
	BiquadFilter.Type high;
	private float m_lowFreq, m_highFreq;
	private float m_lowGain, m_highGain;
	
	protected EQ(){	
		high = BiquadFilter.Type.HIGH_SHELF;
		low = BiquadFilter.Type.LOW_SHELF;
		m_lowFreq = 0.33f; 
		m_highFreq = 0.33f;
		m_lowGain = 0.5f;
		m_highGain = 0.5f;
	}
	
	public static EQ getEQ(){
		if(eq == null){
			eq = new EQ();
		}
		return eq;
	}
	
	public void setLowFreq(float freq){
		m_lowFreq = freq;
	}
	
	public void setHighFreq(float freq){
		m_highFreq = freq;
	}
	
	public void setLowGain(float gain){
		m_lowGain = gain;
	}
	
	public void setHighGain(float gain){
		m_highGain = gain;
	}
	
	public BiquadFilter.Type getLow(){
		return low;
	}
	
	public BiquadFilter.Type getHigh(){
		return high;
	}
	
	public float getLowFreq(){
		return m_lowFreq;
	}
	
	public float getHighFreq(){
		return m_highFreq;
	}
	
	public float getLowGain(){
		return m_lowGain;
	}
	
	public float getHighGain(){
		return m_highGain;
	}
}
