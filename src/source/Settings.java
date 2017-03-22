package source;
import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

//singleton pattern
public class Settings {
	
	private static Settings settings = null;
	
	private float m_Osc1Freq;
	private float m_Osc2Freq;
	private float m_FilterFreq;
	private float m_FilterGain;
	
	public String m_Wave1Sel, m_Wave2Sel;
	public String m_FilterSel;
	
	public boolean m_FilterWave1;
	public boolean m_FilterWave2;
	
	public static final float START_FREQ = 440.0f; 
	
	
	protected Settings()
	{
		m_Wave1Sel = "sine";
		m_Wave2Sel = "sine";
		m_FilterSel = "lpf";
	}
	
	public static Settings getSettings()
	{
		if(settings == null){
			settings = new Settings();
		}
		return settings;
	}
	
	public void setOsc1Freq(float freq)
	{
		m_Osc1Freq = freq;
	}
	
	public void setOsc2Freq(float freq)
	{
		m_Osc2Freq = freq;
	}
	
	public void setFilterFreq(float freq)
	{
		m_FilterFreq = freq;
	}
	
	public void setFilterGain(float gain)
	{
		m_FilterGain = gain;
	}
	
	public void setWave1Sel(String wave)
	{
		m_Wave1Sel = wave;
	}
	
	public void setWave2Sel(String wave)
	{
		m_Wave2Sel = wave;
	}

	public void setFilterSel(String filter)
	{
		m_FilterSel = filter;
	}
	
	public void setFilterWave1(boolean on)
	{
		m_FilterWave1 = on;
	}
	
	public void setFilterWave2(boolean on)
	{
		m_FilterWave2 = on;
	}
	
	public float getOsc1Freq()
	{
		
		return m_Osc1Freq;
	}
	
	public float getOsc2Freq()
	{
		
		return m_Osc2Freq;
	}
	
	public float getFilterFreq()
	{
		
		return m_FilterFreq;
	}
	
	public float getFilterGain()
	{
		
		return m_FilterGain;
	}
	
	public String getWave1Sel()
	{
		
		return m_Wave1Sel;
		
	}
	
	public String getWave2Sel()
	{
		
		return m_Wave2Sel;
		
	}
	
	public String getFilterSel()
	{
		
		return m_FilterSel;
		
	}
	
	public boolean getFilterWave1()
	{
		return m_FilterWave1;
	}
	
	public boolean getFilterWave2()
	{
		return m_FilterWave2;
	}
}
