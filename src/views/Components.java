/*
 * @author Carlo Sarli 
 * 
 */
package views;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import source.ADSR;
import source.EQ;
import source.FilterSettings;
import source.LFO;
import source.Master;
import source.OscillatorSettings;
import source.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class Components.
 */
public class Components extends Settings {

	// private static Components comp = null;

	
	/** The lfo. */
	LFO lfo = LFO.getLfo();
	
	/** The adsr. */
	ADSR adsr = ADSR.getADSR();
	
	/** The master. */
	Master master = Master.getMaster();
	
	/** The eq. */
	EQ eq = EQ.getEQ();
	
	/** The osc  */
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();
	
	/** The fil  */
	FilterSettings filSettings = FilterSettings.getFilterSettings();



	/** The Add osc 1 to filter. */
	private JRadioButton AddOsc1ToFilter;
	
	/** The Add osc 2 to filter. */
	private JRadioButton AddOsc2ToFilter;
	
	/** The Osc 1 wv sel. */
	private JComboBox Osc1WvSel;
	
	/** The Osc 2 wv sel. */
	private JComboBox Osc2WvSel;
	
	/** The Filter 2 combo. */
	private JComboBox Filter2Combo;
	
	/** The Lfo wave combo. */
	private JComboBox LfoWaveCombo;
	
	/** The Apply lfo combo. */
	private JComboBox ApplyLfoCombo;
	
	/** The Filter 1 combo. */
	private JComboBox Filter1Combo;
	
	/** The Volume left bar. */
	private JProgressBar VolumeLeftBar;
	
	/** The Volume right bar. */
	private JProgressBar VolumeRightBar;
	
	/** The Osc 1 freq slider. */
	private JSlider Osc1FreqSlider;
	
	/** The Osc 1 phase slider. */
	private JSlider Osc1PhaseSlider;
	
	/** The Osc 2 freq slider. */
	private JSlider Osc2FreqSlider;
	
	/** The Osc 2 phase slider. */
	private JSlider Osc2PhaseSlider;
	
	/** The Filter 1 freq slider. */
	private JSlider Filter1FreqSlider;
	
	/** The Filter 2 freq slider. */
	private JSlider Filter2FreqSlider;
	
	/** The Lfo frequency slider. */
	private JSlider LfoFrequencySlider;
	
	/** The Lfo amplitude slider. */
	private JSlider LfoAmplitudeSlider;
	
	/** The Panning slider. */
	private JSlider PanningSlider;
	
	/** The Filter mix slider. */
	private JSlider FilterMixSlider;
	
	/** The Osc mix slider. */
	private JSlider OscMixSlider;
	
	/** The Osc gain slider. */
	private JSlider OscGainSlider;
	
	/** The Master volume slider. */
	private JSlider MasterVolumeSlider;
	
	/** The Filter gain slider. */
	private JSlider FilterGainSlider;
	
	/** The Attack slider. */
	private JSlider AttackSlider;
	
	/** The Release slider. */
	private JSlider ReleaseSlider;
	
	/** The Sustain slider. */
	private JSlider SustainSlider;
	
	/** The Decay slider. */
	private JSlider DecaySlider;
	
	/** The Eq high slider. */
	private JSlider EqHighSlider;
	
	/** The Eq high gain slider. */
	private JSlider EqHighGainSlider;
	
	/** The Eq low slider. */
	private JSlider EqLowSlider;
	
	/** The Eq low gain slider. */
	private JSlider EqLowGainSlider;

	/**
	 * Instantiates a new components.
	 */
	public Components() {

		Osc1FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_TRANSPOSE, MAX_TRANSPOSE, TRANSPOSE_START);
		Osc1PhaseSlider = new JSlider(MIN_PHASE_SHIFT,MAX_PHASE_SHIFT,PHASE_START_SHIFT);
		Osc2FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_TRANSPOSE, MAX_TRANSPOSE, TRANSPOSE_START);
		Osc2PhaseSlider = new JSlider(MIN_PHASE_SHIFT,MAX_PHASE_SHIFT,PHASE_START_SHIFT);
		Osc1WvSel = new JComboBox();
		Osc2WvSel = new JComboBox();
		Filter1FreqSlider = new JSlider(MIN_FIL_FREQ, MAX_FIL_FREQ, FIL_START_FREQ);
		AddOsc2ToFilter = new JRadioButton("AddOsc2ToFilter");
		AddOsc2ToFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		AddOsc1ToFilter = new JRadioButton("AddOsc1ToFilter");
		AddOsc1ToFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		Filter2FreqSlider = new JSlider(MIN_FIL_FREQ, MAX_FIL_FREQ, FIL_START_FREQ);
		Filter1Combo = new JComboBox();
		Filter2Combo = new JComboBox();
		LfoWaveCombo = new JComboBox();
		ApplyLfoCombo = new JComboBox();
		LfoFrequencySlider = new JSlider(MIN_LFO_FREQ, MAX_LFO_FREQ, START_LFO_FREQ);
		LfoAmplitudeSlider = new JSlider(MIN_LFO_AMPL, MAX_LFO_AMPL, START_LFO_AMPL);
		PanningSlider = new JSlider(LEFT_PAN, RIGHT_PAN, START_PANNER_POSITION);
		FilterMixSlider = new JSlider(MIN_VOLUME_MASTER, MAX_VOLUME_MASTER, START_VOLUME_MASTER);
		OscMixSlider = new JSlider(MIN_VOLUME_MASTER, MAX_VOLUME_MASTER, START_VOLUME_MASTER);
		OscGainSlider = new JSlider(MIN_VOLUME_MASTER, MAX_VOLUME_MASTER, START_VOLUME_MASTER);
		MasterVolumeSlider = new JSlider(MIN_VOLUME_MASTER, MAX_VOLUME_MASTER, START_VOLUME_MASTER);
		FilterGainSlider = new JSlider(MIN_VOLUME_MASTER, MAX_VOLUME_MASTER, START_VOLUME_MASTER);
		AttackSlider = new JSlider(MIN_ADSR_TIME, MAX_ADSR_TIME, ADSR_START_TIME);
		ReleaseSlider = new JSlider(MIN_ADSR_TIME, MAX_ADSR_TIME, ADSR_START_TIME);
		SustainSlider = new JSlider(MIN_ADSR_TIME, MAX_ADSR_TIME, ADSR_START_TIME);
		DecaySlider = new JSlider(MIN_ADSR_TIME, MAX_ADSR_TIME, ADSR_START_TIME);
		EqHighSlider = new JSlider(MIN_EQ_FREQ,MAX_EQ_FREQ, EQ_START_FREQ);
		EqHighGainSlider = new JSlider(MIN_EQ_GAIN, MAX_EQ_GAIN,EQ_START_GAIN);
		EqLowSlider = new JSlider(MIN_EQ_FREQ,MAX_EQ_FREQ, EQ_START_FREQ);
		EqLowGainSlider = new JSlider(MIN_EQ_GAIN, MAX_EQ_GAIN,EQ_START_GAIN);
	}

	/**
	 * Update components.
	 */
	public void updateComponents() {

		Osc1WvSel.setSelectedItem(oscSettings.getWave1Sel());
		Osc2WvSel.setSelectedItem(oscSettings.getWave2Sel());
		Osc1PhaseSlider.setValue((int) oscSettings.getDelayIn1Time());
		Osc2PhaseSlider.setValue((int) oscSettings.getDelayIn2Time());
		AddOsc1ToFilter.setSelected(filSettings.getFilterWave1());
		AddOsc2ToFilter.setSelected(filSettings.getFilterWave2());
		Filter1Combo.setSelectedItem(filSettings.getFilter1Sel());
		Filter2Combo.setSelectedItem(filSettings.getFilter2Sel());
		LfoWaveCombo.setSelectedItem(lfo.getLfoWaveSel());
		// ApplyLfoCombo.setSelectedItem(lfo.get);;
		Filter1FreqSlider.setValue((int) filSettings.getFilter1Freq());
		Filter2FreqSlider.setValue((int) filSettings.getFilter2Freq());
		LfoFrequencySlider.setValue((int) lfo.getLfoFrq());
		LfoAmplitudeSlider.setValue((int) lfo.getLfoAmplitude());
		PanningSlider.setValue((int) master.getPannerPosition());
		FilterMixSlider.setValue((int) master.getFil1Gain());
		OscMixSlider.setValue((int) master.getOsc1Gain());
		OscGainSlider.setValue((int) master.getOscMix());
		MasterVolumeSlider.setValue((int) master.getMasterVolume());
		FilterGainSlider.setValue((int) master.getFilMix());
		AttackSlider.setValue((int) adsr.getAttackTime());
		ReleaseSlider.setValue((int) adsr.getReleaseTime());
		SustainSlider.setValue((int) adsr.getSustainTime());
		DecaySlider.setValue((int) adsr.getDecayTime());
		EqHighSlider.setValue((int) eq.getHighFreq());
		EqHighGainSlider.setValue((int) eq.getHighGain());
		EqLowSlider.setValue((int) eq.getLowFreq());
		EqLowGainSlider.setValue((int) eq.getLowGain());

	}

	/**
	 * Gets the adds the osc 1 to filter.
	 *
	 * @return the adds the osc 1 to filter
	 */
	/*
	 * public static Components getComp() { if (comp == null) { comp = new
	 * Components(); } return comp; }
	 */
	public JRadioButton getAddOsc1ToFilter() {
		return AddOsc1ToFilter;
	}

	/**
	 * Sets the adds the osc 1 to filter.
	 *
	 * @param addOsc1ToFilter the new adds the osc 1 to filter
	 */
	public void setAddOsc1ToFilter(JRadioButton addOsc1ToFilter) {
		AddOsc1ToFilter = addOsc1ToFilter;
	}

	/**
	 * Gets the adds the osc 2 to filter.
	 *
	 * @return the adds the osc 2 to filter
	 */
	public JRadioButton getAddOsc2ToFilter() {
		return AddOsc2ToFilter;
	}

	/**
	 * Sets the adds the osc 2 to filter.
	 *
	 * @param addOsc2ToFilter the new adds the osc 2 to filter
	 */
	public void setAddOsc2ToFilter(JRadioButton addOsc2ToFilter) {
		AddOsc2ToFilter = addOsc2ToFilter;
	}

	/**
	 * Gets the osc 1 wv sel.
	 *
	 * @return the osc 1 wv sel
	 */
	public JComboBox getOsc1WvSel() {
		return Osc1WvSel;
	}

	/**
	 * Sets the osc 1 wv sel.
	 *
	 * @param osc1WvSel the new osc 1 wv sel
	 */
	public void setOsc1WvSel(JComboBox osc1WvSel) {
		Osc1WvSel = osc1WvSel;
	}

	/**
	 * Gets the osc 2 wv sel.
	 *
	 * @return the osc 2 wv sel
	 */
	public JComboBox getOsc2WvSel() {
		return Osc2WvSel;
	}

	/**
	 * Sets the osc 2 wv sel.
	 *
	 * @param osc2WvSel the new osc 2 wv sel
	 */
	public void setOsc2WvSel(JComboBox osc2WvSel) {
		Osc2WvSel = osc2WvSel;
	}

	/**
	 * Gets the filter 2 combo.
	 *
	 * @return the filter 2 combo
	 */
	public JComboBox getFilter2Combo() {
		return Filter2Combo;
	}

	/**
	 * Sets the filter 2 combo.
	 *
	 * @param filter2Combo the new filter 2 combo
	 */
	public void setFilter2Combo(JComboBox filter2Combo) {
		Filter2Combo = filter2Combo;
	}

	/**
	 * Gets the lfo wave combo.
	 *
	 * @return the lfo wave combo
	 */
	public JComboBox getLfoWaveCombo() {
		return LfoWaveCombo;
	}

	/**
	 * Sets the lfo wave combo.
	 *
	 * @param lfoWaveCombo the new lfo wave combo
	 */
	public void setLfoWaveCombo(JComboBox lfoWaveCombo) {
		LfoWaveCombo = lfoWaveCombo;
	}

	/**
	 * Gets the apply lfo combo.
	 *
	 * @return the apply lfo combo
	 */
	public JComboBox getApplyLfoCombo() {
		return ApplyLfoCombo;
	}

	/**
	 * Sets the apply lfo combo.
	 *
	 * @param applyLfoCombo the new apply lfo combo
	 */
	public void setApplyLfoCombo(JComboBox applyLfoCombo) {
		ApplyLfoCombo = applyLfoCombo;
	}

	/**
	 * Gets the filter 1 combo.
	 *
	 * @return the filter 1 combo
	 */
	public JComboBox getFilter1Combo() {
		return Filter1Combo;
	}

	/**
	 * Sets the filter 1 combo.
	 *
	 * @param filter1Combo the new filter 1 combo
	 */
	public void setFilter1Combo(JComboBox filter1Combo) {
		Filter1Combo = filter1Combo;
	}

	/**
	 * Gets the volume left bar.
	 *
	 * @return the volume left bar
	 */
	public JProgressBar getVolumeLeftBar() {
		return VolumeLeftBar;
	}

	/**
	 * Sets the volume left bar.
	 *
	 * @param volumeLeftBar the new volume left bar
	 */
	public void setVolumeLeftBar(JProgressBar volumeLeftBar) {
		VolumeLeftBar = volumeLeftBar;
	}

	/**
	 * Gets the volume right bar.
	 *
	 * @return the volume right bar
	 */
	public JProgressBar getVolumeRightBar() {
		return VolumeRightBar;
	}

	/**
	 * Sets the volume right bar.
	 *
	 * @param volumeRightBar the new volume right bar
	 */
	public void setVolumeRightBar(JProgressBar volumeRightBar) {
		VolumeRightBar = volumeRightBar;
	}

	/**
	 * Gets the osc 1 freq slider.
	 *
	 * @return the osc 1 freq slider
	 */
	public JSlider getOsc1FreqSlider() {
		return Osc1FreqSlider;
	}

	/**
	 * Sets the osc 1 freq slider.
	 *
	 * @param osc1FreqSlider the new osc 1 freq slider
	 */
	public void setOsc1FreqSlider(JSlider osc1FreqSlider) {
		Osc1FreqSlider = osc1FreqSlider;
	}

	/**
	 * Gets the osc 1 phase slider.
	 *
	 * @return the osc 1 phase slider
	 */
	public JSlider getOsc1PhaseSlider() {
		return Osc1PhaseSlider;
	}

	/**
	 * Sets the osc 1 phase slider.
	 *
	 * @param osc1PhaseSlider the new osc 1 phase slider
	 */
	public void setOsc1PhaseSlider(JSlider osc1PhaseSlider) {
		Osc1PhaseSlider = osc1PhaseSlider;
	}

	/**
	 * Gets the osc 2 freq slider.
	 *
	 * @return the osc 2 freq slider
	 */
	public JSlider getOsc2FreqSlider() {
		return Osc2FreqSlider;
	}

	/**
	 * Sets the osc 2 freq slider.
	 *
	 * @param osc2FreqSlider the new osc 2 freq slider
	 */
	public void setOsc2FreqSlider(JSlider osc2FreqSlider) {
		Osc2FreqSlider = osc2FreqSlider;
	}

	/**
	 * Gets the osc 2 phase slider.
	 *
	 * @return the osc 2 phase slider
	 */
	public JSlider getOsc2PhaseSlider() {
		return Osc2PhaseSlider;
	}

	/**
	 * Sets the osc 2 phase slider.
	 *
	 * @param osc2PhaseSlider the new osc 2 phase slider
	 */
	public void setOsc2PhaseSlider(JSlider osc2PhaseSlider) {
		Osc2PhaseSlider = osc2PhaseSlider;
	}

	/**
	 * Gets the filter 1 freq slider.
	 *
	 * @return the filter 1 freq slider
	 */
	public JSlider getFilter1FreqSlider() {
		return Filter1FreqSlider;
	}

	/**
	 * Sets the filter 1 freq slider.
	 *
	 * @param filter1FreqSlider the new filter 1 freq slider
	 */
	public void setFilter1FreqSlider(JSlider filter1FreqSlider) {
		Filter1FreqSlider = filter1FreqSlider;
	}

	/**
	 * Gets the filter 2 freq slider.
	 *
	 * @return the filter 2 freq slider
	 */
	public JSlider getFilter2FreqSlider() {
		return Filter2FreqSlider;
	}

	/**
	 * Sets the filter 2 freq slider.
	 *
	 * @param filter2FreqSlider the new filter 2 freq slider
	 */
	public void setFilter2FreqSlider(JSlider filter2FreqSlider) {
		Filter2FreqSlider = filter2FreqSlider;
	}

	/**
	 * Gets the lfo frequency slider.
	 *
	 * @return the lfo frequency slider
	 */
	public JSlider getLfoFrequencySlider() {
		return LfoFrequencySlider;
	}

	/**
	 * Sets the lfo frequency slider.
	 *
	 * @param lfoFrequencySlider the new lfo frequency slider
	 */
	public void setLfoFrequencySlider(JSlider lfoFrequencySlider) {
		LfoFrequencySlider = lfoFrequencySlider;
	}

	/**
	 * Gets the lfo amplitude slider.
	 *
	 * @return the lfo amplitude slider
	 */
	public JSlider getLfoAmplitudeSlider() {
		return LfoAmplitudeSlider;
	}

	/**
	 * Sets the lfo amplitude slider.
	 *
	 * @param lfoAmplitudeSlider the new lfo amplitude slider
	 */
	public void setLfoAmplitudeSlider(JSlider lfoAmplitudeSlider) {
		LfoAmplitudeSlider = lfoAmplitudeSlider;
	}

	/**
	 * Gets the panning slider.
	 *
	 * @return the panning slider
	 */
	public JSlider getPanningSlider() {
		return PanningSlider;
	}

	/**
	 * Sets the panning slider.
	 *
	 * @param panningSlider the new panning slider
	 */
	public void setPanningSlider(JSlider panningSlider) {
		PanningSlider = panningSlider;
	}

	/**
	 * Gets the filter mix slider.
	 *
	 * @return the filter mix slider
	 */
	public JSlider getFilterMixSlider() {
		return FilterMixSlider;
	}

	/**
	 * Sets the filter mix slider.
	 *
	 * @param filterMixSlider the new filter mix slider
	 */
	public void setFilterMixSlider(JSlider filterMixSlider) {
		FilterMixSlider = filterMixSlider;
	}

	/**
	 * Gets the osc mix slider.
	 *
	 * @return the osc mix slider
	 */
	public JSlider getOscMixSlider() {
		return OscMixSlider;
	}

	/**
	 * Sets the osc mix slider.
	 *
	 * @param oscMixSlider the new osc mix slider
	 */
	public void setOscMixSlider(JSlider oscMixSlider) {
		OscMixSlider = oscMixSlider;
	}

	/**
	 * Gets the osc gain slider.
	 *
	 * @return the osc gain slider
	 */
	public JSlider getOscGainSlider() {
		return OscGainSlider;
	}

	/**
	 * Sets the osc gain slider.
	 *
	 * @param oscGainSlider the new osc gain slider
	 */
	public void setOscGainSlider(JSlider oscGainSlider) {
		OscGainSlider = oscGainSlider;
	}

	/**
	 * Gets the master volume slider.
	 *
	 * @return the master volume slider
	 */
	public JSlider getMasterVolumeSlider() {
		return MasterVolumeSlider;
	}

	/**
	 * Sets the master volume slider.
	 *
	 * @param masterVolumeSlider the new master volume slider
	 */
	public void setMasterVolumeSlider(JSlider masterVolumeSlider) {
		MasterVolumeSlider = masterVolumeSlider;
	}

	/**
	 * Gets the filter gain slider.
	 *
	 * @return the filter gain slider
	 */
	public JSlider getFilterGainSlider() {
		return FilterGainSlider;
	}

	/**
	 * Sets the filter gain slider.
	 *
	 * @param filterGainSlider the new filter gain slider
	 */
	public void setFilterGainSlider(JSlider filterGainSlider) {
		FilterGainSlider = filterGainSlider;
	}

	/**
	 * Gets the attack slider.
	 *
	 * @return the attack slider
	 */
	public JSlider getAttackSlider() {
		return AttackSlider;
	}

	/**
	 * Sets the attack slider.
	 *
	 * @param attackSlider the new attack slider
	 */
	public void setAttackSlider(JSlider attackSlider) {
		AttackSlider = attackSlider;
	}

	/**
	 * Gets the release slider.
	 *
	 * @return the release slider
	 */
	public JSlider getReleaseSlider() {
		return ReleaseSlider;
	}

	/**
	 * Sets the release slider.
	 *
	 * @param releaseSlider the new release slider
	 */
	public void setReleaseSlider(JSlider releaseSlider) {
		ReleaseSlider = releaseSlider;
	}

	/**
	 * Gets the sustain slider.
	 *
	 * @return the sustain slider
	 */
	public JSlider getSustainSlider() {
		return SustainSlider;
	}

	/**
	 * Sets the sustain slider.
	 *
	 * @param sustainSlider the new sustain slider
	 */
	public void setSustainSlider(JSlider sustainSlider) {
		SustainSlider = sustainSlider;
	}

	/**
	 * Gets the decay slider.
	 *
	 * @return the decay slider
	 */
	public JSlider getDecaySlider() {
		return DecaySlider;
	}

	/**
	 * Sets the decay slider.
	 *
	 * @param decaySlider the new decay slider
	 */
	public void setDecaySlider(JSlider decaySlider) {
		DecaySlider = decaySlider;
	}

	/**
	 * Gets the eq high slider.
	 *
	 * @return the eq high slider
	 */
	public JSlider getEqHighSlider() {
		return EqHighSlider;
	}

	/**
	 * Sets the eq high slider.
	 *
	 * @param eqHighSlider the new eq high slider
	 */
	public void setEqHighSlider(JSlider eqHighSlider) {
		EqHighSlider = eqHighSlider;
	}

	/**
	 * Gets the eq high gain slider.
	 *
	 * @return the eq high gain slider
	 */
	public JSlider getEqHighGainSlider() {
		return EqHighGainSlider;
	}

	/**
	 * Sets the eq high gain slider.
	 *
	 * @param eqHighGainSlider the new eq high gain slider
	 */
	public void setEqHighGainSlider(JSlider eqHighGainSlider) {
		EqHighGainSlider = eqHighGainSlider;
	}

	/**
	 * Gets the eq low slider.
	 *
	 * @return the eq low slider
	 */
	public JSlider getEqLowSlider() {
		return EqLowSlider;
	}

	/**
	 * Sets the eq low slider.
	 *
	 * @param eqLowSlider the new eq low slider
	 */
	public void setEqLowSlider(JSlider eqLowSlider) {
		EqLowSlider = eqLowSlider;
	}

	/**
	 * Gets the eq low gain slider.
	 *
	 * @return the eq low gain slider
	 */
	public JSlider getEqLowGainSlider() {
		return EqLowGainSlider;
	}

	/**
	 * Sets the eq low gain slider.
	 *
	 * @param eqLowGainSlider the new eq low gain slider
	 */
	public void setEqLowGainSlider(JSlider eqLowGainSlider) {
		EqLowGainSlider = eqLowGainSlider;
	}
}
