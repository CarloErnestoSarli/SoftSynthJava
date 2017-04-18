/**
 * @file FilterSettings.java
 * @author Carlo Sarli 
 * 
 */
package source;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterSettings.
 */
public class FilterSettings {
	
	/** The filter settings. */
	private static FilterSettings filterSettings = null;
	
	/** The m filter sel. */
	private String m_Filter1Sel;
	
	/** The m filter sel. */
	private String m_Filter2Sel;

	/** The m filter wave 1. */
	private boolean m_FilterWave1;
	
	/** The m filter wave 2. */
	private boolean m_FilterWave2;
	
	/** The m filter freq. */
	private float m_Filter1Freq;
	
	/** The m filter freq. */
	private float m_Filter2Freq;
	
	/** The m filter gain. */
	private float m_FilterGain;
	
	/**
	 * Instantiates a new filter settings.
	 */
	protected FilterSettings() {
		
		m_Filter1Sel = "lpf";
		m_Filter2Sel = "lpf";
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public static FilterSettings getFilterSettings() {
		if (filterSettings == null) {
			filterSettings = new FilterSettings();
		}
		return filterSettings;
	}
	
	/**
	 * Sets the filter freq.
	 *
	 * @param freq the new filter freq
	 */
	public void setFilter1Freq(float freq) {
		m_Filter1Freq = freq;
	}
	
	/**
	 * Sets the filter freq.
	 *
	 * @param freq the new filter freq
	 */
	public void setFilter2Freq(float freq) {
		m_Filter2Freq = freq;
	}

	/**
	 * Sets the filter gain.
	 *
	 * @param gain the new filter gain
	 */
	public void setFilterGain(float gain) {
		m_FilterGain = gain;
	}

	/**
	 * Sets the filter sel.
	 *
	 * @param filter the new filter sel
	 */
	public void setFilter1Sel(String filter) {
		m_Filter1Sel = filter;
	}
	
	/**
	 * Sets the filter sel.
	 *
	 * @param filter the new filter sel
	 */
	public void setFilter2Sel(String filter) {
		m_Filter2Sel = filter;
	}

	/**
	 * Sets the filter wave 1.
	 *
	 * @param on the new filter wave 1
	 */
	public void setFilterWave1(boolean on) {
		m_FilterWave1 = on;
	}

	/**
	 * Sets the filter wave 2.
	 *
	 * @param on the new filter wave 2
	 */
	public void setFilterWave2(boolean on) {
		m_FilterWave2 = on;
	}
	
	/**
	 * Gets the filter freq.
	 *
	 * @return the filter freq
	 */
	public float getFilter1Freq() {

		return m_Filter1Freq;
	}
	
	/**
	 * Gets the filter freq.
	 *
	 * @return the filter freq
	 */
	public float getFilter2Freq() {

		return m_Filter2Freq;
	}

	/**
	 * Gets the filter gain.
	 *
	 * @return the filter gain
	 */
	public float getFilterGain() {

		return m_FilterGain;
	}
	
	/**
	 * Gets the filter sel.
	 *
	 * @return the filter sel
	 */
	public String getFilter1Sel() {

		return m_Filter1Sel;

	}
	
	/**
	 * Gets the filter sel.
	 *
	 * @return the filter sel
	 */
	public String getFilter2Sel() {

		return m_Filter2Sel;

	}

	/**
	 * Gets the filter wave 1.
	 *
	 * @return the filter wave 1
	 */
	public boolean getFilterWave1() {
		
		return m_FilterWave1;
	}

	/**
	 * Gets the filter wave 2.
	 *
	 * @return the filter wave 2
	 */
	public boolean getFilterWave2() {
		
		return m_FilterWave2;
	}

}
