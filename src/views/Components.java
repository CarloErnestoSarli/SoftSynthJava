package views;

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

public class Components {

	// private static Components comp = null;

	Settings settings = Settings.getSettings();
	LFO lfo = LFO.getLfo();
	ADSR adsr = ADSR.getADSR();
	Master master = Master.getMaster();
	EQ eq = EQ.getEQ();
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();
	FilterSettings filSettings = FilterSettings.getFilterSettings();

	private final int MIN_OSC_FREQ = 1635;
	private final int MAX_OSC_FREQ = 100000;
	private final int NOTE_A_FREQ = 44000;
	private final int LFO_MIN_FREQ = 2;
	private final int LFO_MAX_FREQ = 2000;
	private final int MIN_VOLUME = 0;
	private final int MAX_VOLUME = 100;
	private final int LEFT = -10;
	private final int RIGHT = 10;
	private final int START_VOLUME = 50;
	private final int START_POSITION = 0;

	private JRadioButton AddOsc1ToFilter;
	private JRadioButton AddOsc2ToFilter;
	private JComboBox Osc1WvSel;
	private JComboBox Osc2WvSel;
	private JComboBox Filter2Combo;
	private JComboBox LfoWaveCombo;
	private JComboBox ApplyLfoCombo;
	private JComboBox Filter1Combo;
	private JProgressBar VolumeLeftBar;
	private JProgressBar VolumeRightBar;
	private JSlider Osc1FreqSlider;
	private JSlider Osc1PhaseSlider;
	private JSlider Osc2FreqSlider;
	private JSlider Osc2PhaseSlider;
	private JSlider Filter1FreqSlider;
	private JSlider Filter2FreqSlider;
	private JSlider LfoFrequencySlider;
	private JSlider LfoAmplitudeSlider;
	private JSlider PanningSlider;
	private JSlider FilterMixSlider;
	private JSlider OscMixSlider;
	private JSlider OscGainSlider;
	private JSlider MasterVolumeSlider;
	private JSlider FilterGainSlider;
	private JSlider AttackSlider;
	private JSlider ReleaseSlider;
	private JSlider SustainSlider;
	private JSlider DecaySlider;
	private JSlider EqHighSlider;
	private JSlider EqHighGainSlider;
	private JSlider EqLowSlider;
	private JSlider EqLowGainSlider;

	public Components() {

		Osc1FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Osc1PhaseSlider = new JSlider(0, 300, 150);
		Osc2FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Osc2PhaseSlider = new JSlider(0, 300, 150);
		Osc1WvSel = new JComboBox();
		Osc2WvSel = new JComboBox();
		Filter1FreqSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		AddOsc2ToFilter = new JRadioButton("AddOsc2ToFilter");
		AddOsc1ToFilter = new JRadioButton("AddOsc1ToFilter");
		Filter2FreqSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Filter1Combo = new JComboBox();
		Filter2Combo = new JComboBox();
		LfoWaveCombo = new JComboBox();
		ApplyLfoCombo = new JComboBox();
		LfoFrequencySlider = new JSlider(LFO_MIN_FREQ, LFO_MAX_FREQ);
		LfoAmplitudeSlider = new JSlider();
		PanningSlider = new JSlider(LEFT, RIGHT, START_POSITION);
		FilterMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		MasterVolumeSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		FilterGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		AttackSlider = new JSlider(0, 1000, 500);
		ReleaseSlider = new JSlider(0, 1000, 500);
		SustainSlider = new JSlider(0, 1000, 500);
		DecaySlider = new JSlider(0, 1000, 500);
		EqHighSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		EqHighGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		EqLowSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		EqLowGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
	}

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

	/*
	 * public static Components getComp() { if (comp == null) { comp = new
	 * Components(); } return comp; }
	 */
	public JRadioButton getAddOsc1ToFilter() {
		return AddOsc1ToFilter;
	}

	public void setAddOsc1ToFilter(JRadioButton addOsc1ToFilter) {
		AddOsc1ToFilter = addOsc1ToFilter;
	}

	public JRadioButton getAddOsc2ToFilter() {
		return AddOsc2ToFilter;
	}

	public void setAddOsc2ToFilter(JRadioButton addOsc2ToFilter) {
		AddOsc2ToFilter = addOsc2ToFilter;
	}

	public JComboBox getOsc1WvSel() {
		return Osc1WvSel;
	}

	public void setOsc1WvSel(JComboBox osc1WvSel) {
		Osc1WvSel = osc1WvSel;
	}

	public JComboBox getOsc2WvSel() {
		return Osc2WvSel;
	}

	public void setOsc2WvSel(JComboBox osc2WvSel) {
		Osc2WvSel = osc2WvSel;
	}

	public JComboBox getFilter2Combo() {
		return Filter2Combo;
	}

	public void setFilter2Combo(JComboBox filter2Combo) {
		Filter2Combo = filter2Combo;
	}

	public JComboBox getLfoWaveCombo() {
		return LfoWaveCombo;
	}

	public void setLfoWaveCombo(JComboBox lfoWaveCombo) {
		LfoWaveCombo = lfoWaveCombo;
	}

	public JComboBox getApplyLfoCombo() {
		return ApplyLfoCombo;
	}

	public void setApplyLfoCombo(JComboBox applyLfoCombo) {
		ApplyLfoCombo = applyLfoCombo;
	}

	public JComboBox getFilter1Combo() {
		return Filter1Combo;
	}

	public void setFilter1Combo(JComboBox filter1Combo) {
		Filter1Combo = filter1Combo;
	}

	public JProgressBar getVolumeLeftBar() {
		return VolumeLeftBar;
	}

	public void setVolumeLeftBar(JProgressBar volumeLeftBar) {
		VolumeLeftBar = volumeLeftBar;
	}

	public JProgressBar getVolumeRightBar() {
		return VolumeRightBar;
	}

	public void setVolumeRightBar(JProgressBar volumeRightBar) {
		VolumeRightBar = volumeRightBar;
	}

	public JSlider getOsc1FreqSlider() {
		return Osc1FreqSlider;
	}

	public void setOsc1FreqSlider(JSlider osc1FreqSlider) {
		Osc1FreqSlider = osc1FreqSlider;
	}

	public JSlider getOsc1PhaseSlider() {
		return Osc1PhaseSlider;
	}

	public void setOsc1PhaseSlider(JSlider osc1PhaseSlider) {
		Osc1PhaseSlider = osc1PhaseSlider;
	}

	public JSlider getOsc2FreqSlider() {
		return Osc2FreqSlider;
	}

	public void setOsc2FreqSlider(JSlider osc2FreqSlider) {
		Osc2FreqSlider = osc2FreqSlider;
	}

	public JSlider getOsc2PhaseSlider() {
		return Osc2PhaseSlider;
	}

	public void setOsc2PhaseSlider(JSlider osc2PhaseSlider) {
		Osc2PhaseSlider = osc2PhaseSlider;
	}

	public JSlider getFilter1FreqSlider() {
		return Filter1FreqSlider;
	}

	public void setFilter1FreqSlider(JSlider filter1FreqSlider) {
		Filter1FreqSlider = filter1FreqSlider;
	}

	public JSlider getFilter2FreqSlider() {
		return Filter2FreqSlider;
	}

	public void setFilter2FreqSlider(JSlider filter2FreqSlider) {
		Filter2FreqSlider = filter2FreqSlider;
	}

	public JSlider getLfoFrequencySlider() {
		return LfoFrequencySlider;
	}

	public void setLfoFrequencySlider(JSlider lfoFrequencySlider) {
		LfoFrequencySlider = lfoFrequencySlider;
	}

	public JSlider getLfoAmplitudeSlider() {
		return LfoAmplitudeSlider;
	}

	public void setLfoAmplitudeSlider(JSlider lfoAmplitudeSlider) {
		LfoAmplitudeSlider = lfoAmplitudeSlider;
	}

	public JSlider getPanningSlider() {
		return PanningSlider;
	}

	public void setPanningSlider(JSlider panningSlider) {
		PanningSlider = panningSlider;
	}

	public JSlider getFilterMixSlider() {
		return FilterMixSlider;
	}

	public void setFilterMixSlider(JSlider filterMixSlider) {
		FilterMixSlider = filterMixSlider;
	}

	public JSlider getOscMixSlider() {
		return OscMixSlider;
	}

	public void setOscMixSlider(JSlider oscMixSlider) {
		OscMixSlider = oscMixSlider;
	}

	public JSlider getOscGainSlider() {
		return OscGainSlider;
	}

	public void setOscGainSlider(JSlider oscGainSlider) {
		OscGainSlider = oscGainSlider;
	}

	public JSlider getMasterVolumeSlider() {
		return MasterVolumeSlider;
	}

	public void setMasterVolumeSlider(JSlider masterVolumeSlider) {
		MasterVolumeSlider = masterVolumeSlider;
	}

	public JSlider getFilterGainSlider() {
		return FilterGainSlider;
	}

	public void setFilterGainSlider(JSlider filterGainSlider) {
		FilterGainSlider = filterGainSlider;
	}

	public JSlider getAttackSlider() {
		return AttackSlider;
	}

	public void setAttackSlider(JSlider attackSlider) {
		AttackSlider = attackSlider;
	}

	public JSlider getReleaseSlider() {
		return ReleaseSlider;
	}

	public void setReleaseSlider(JSlider releaseSlider) {
		ReleaseSlider = releaseSlider;
	}

	public JSlider getSustainSlider() {
		return SustainSlider;
	}

	public void setSustainSlider(JSlider sustainSlider) {
		SustainSlider = sustainSlider;
	}

	public JSlider getDecaySlider() {
		return DecaySlider;
	}

	public void setDecaySlider(JSlider decaySlider) {
		DecaySlider = decaySlider;
	}

	public JSlider getEqHighSlider() {
		return EqHighSlider;
	}

	public void setEqHighSlider(JSlider eqHighSlider) {
		EqHighSlider = eqHighSlider;
	}

	public JSlider getEqHighGainSlider() {
		return EqHighGainSlider;
	}

	public void setEqHighGainSlider(JSlider eqHighGainSlider) {
		EqHighGainSlider = eqHighGainSlider;
	}

	public JSlider getEqLowSlider() {
		return EqLowSlider;
	}

	public void setEqLowSlider(JSlider eqLowSlider) {
		EqLowSlider = eqLowSlider;
	}

	public JSlider getEqLowGainSlider() {
		return EqLowGainSlider;
	}

	public void setEqLowGainSlider(JSlider eqLowGainSlider) {
		EqLowGainSlider = eqLowGainSlider;
	}
}
