package source;

import java.util.prefs.Preferences;

public class UserSettings {

	Preferences userSettings;
	Settings settings = Settings.getSettings();
	Master master = Master.getMaster();
	ADSR adsr = ADSR.getADSR();
	LFO lfo = LFO.getLfo();
	EQ eq = EQ.getEQ();
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();
	FilterSettings filSettings = FilterSettings.getFilterSettings();

	// ---------OSC
	private final String OSC_1_WAVE = "OSC_1_WAVE";
	private final String OSC_2_WAVE = "OSC_2_WAVE";
	private final String OSC_1_PHASE = "OSC_1_PHASE";
	private final String OSC_2_PHASE = "OSC_2_PHASE";
	// ---------FILTER
	private final String ADD_FILTER_1 = "ADD_FILTER_1";
	private final String ADD_FILTER_2 = "ADD_FILTER_2";
	private final String FILTER_1_FREQ = "FILTER_1_FREQ";
	private final String FILTER_2_FREQ = "FILTER_2_FREQ";
	private final String FILTER_1_TYPE = "FILTER_1_TYPE";
	private final String FILTER_2_TYPE = "FILTER_2_TYPE";
	// ---------LFO
	private final String LFO_FREQ = "LFO_FREQ";
	private final String LFO_AMPL = "LFO_AMPL";
	private final String LFO_WAVE = "LFO_WAVE";
	// private final String LFO_ACTION;
	// ---------ADSR
	private final String A_TIME = "A_TIME";
	private final String D_TIME = "D_TIME";
	private final String S_TIME = "S_TIME";
	private final String R_TIME = "R_TIME";
	// ---------EQ
	private final String HIGH_FREQ = "HIGH_FREQ";
	private final String HIGH_GAIN = "HIGH_GAIN";
	private final String LOW_FREQ = "LOW_FREQ";
	private final String LOW_GAIN = "LOW_GAIN";
	// ---------MASTER
	private final String OSC_MIX_VOLUME = "OSC_MIX_VOLUME";
	private final String OSC_1_VOLUME = "OSC_1_VOLUME";
	private final String OSC_2_VOLUME = "OSC_2_VOLUME";
	private final String FILTER_MIX_VOLUME = "FILTER_MIX_VOLUME";
	private final String FILTER_1_VOLUME = "FILTER_1_VOLUME";
	private final String FILTER_2_VOLUME = "FILTER_2_VOLUME";
	private final String MASTER_VOLUME = "MASTER_VOLUME";
	// ---------PANNER
	private final String PANNER_POS = "";
	
	public UserSettings(){
		userSettings = Preferences.userRoot();

	}
	
	public void saveSettings() {

		// ---------OSC
		userSettings.put(OSC_1_WAVE, oscSettings.getWave1Sel());
		userSettings.put(OSC_2_WAVE, oscSettings.getWave2Sel());
		userSettings.putFloat(OSC_1_PHASE, oscSettings.getDelayIn1Time());
		userSettings.putFloat(OSC_2_PHASE, oscSettings.getDelayIn2Time());
		// ---------FILTER
		userSettings.putBoolean(ADD_FILTER_1, filSettings.getFilterWave1());
		userSettings.putBoolean(ADD_FILTER_2, filSettings.getFilterWave2());
		userSettings.putFloat(FILTER_1_FREQ, filSettings.getFilter1Freq());
		userSettings.putFloat(FILTER_2_FREQ, filSettings.getFilter2Freq());
		userSettings.put(FILTER_1_TYPE, filSettings.getFilter1Sel());
		userSettings.put(FILTER_2_TYPE, filSettings.getFilter2Sel());
		// ---------LFO
		userSettings.putFloat(LFO_FREQ, lfo.getLfoFrq());
		userSettings.putFloat(LFO_AMPL, lfo.getLfoAmplitude());
		userSettings.put(LFO_WAVE, lfo.getLfoWaveSel());
		// ---------ADSR
		userSettings.putFloat(A_TIME, adsr.getAttackTime());
		userSettings.putFloat(D_TIME, adsr.getDecayTime());
		userSettings.putFloat(S_TIME, adsr.getSustainTime());
		userSettings.putFloat(R_TIME, adsr.getReleaseTime());
		// ---------EQ
		userSettings.putFloat(HIGH_FREQ, eq.getHighFreq());
		userSettings.putFloat(HIGH_GAIN, eq.getHighGain());
		userSettings.putFloat(LOW_FREQ, eq.getLowFreq());
		userSettings.putFloat(LOW_GAIN, eq.getLowGain());
		// ---------MASTER
		userSettings.putFloat(OSC_MIX_VOLUME, master.getOscMix());
		userSettings.putFloat(OSC_1_VOLUME, master.getOsc1Gain());
		userSettings.putFloat(OSC_2_VOLUME, master.getOsc2Gain());
		userSettings.putFloat(FILTER_MIX_VOLUME, master.getFilMix());
		userSettings.putFloat(FILTER_1_VOLUME, master.getFil1Gain());
		userSettings.putFloat(FILTER_2_VOLUME, master.getFil2Gain());
		userSettings.putFloat(MASTER_VOLUME, master.getMasterVolume());
		// ---------PANNER
		userSettings.putFloat(PANNER_POS, master.getPannerPosition());

	}

	public void loadSettings() {

		// ---------OSC
		oscSettings.setWave1Sel(userSettings.get(OSC_1_WAVE, oscSettings.getWave1Sel()));
		oscSettings.setWave2Sel(userSettings.get(OSC_2_WAVE, oscSettings.getWave2Sel()));
		oscSettings.setDelayIn1Time(userSettings.getFloat(OSC_1_PHASE, oscSettings.getDelayIn1Time()));
		oscSettings.setDelayIn2Time(userSettings.getFloat(OSC_2_PHASE, oscSettings.getDelayIn2Time()));
		// ---------FILTER
		filSettings.setFilterWave1(userSettings.getBoolean(ADD_FILTER_1, filSettings.getFilterWave1()));
		filSettings.setFilterWave2(userSettings.getBoolean(ADD_FILTER_2, filSettings.getFilterWave2()));
		filSettings.setFilter1Freq(userSettings.getFloat(FILTER_1_FREQ, filSettings.getFilter1Freq()));
		filSettings.setFilter2Freq(userSettings.getFloat(FILTER_2_FREQ, filSettings.getFilter2Freq()));
		filSettings.setFilter1Sel(userSettings.get(FILTER_1_TYPE, filSettings.getFilter1Sel()));
		filSettings.setFilter2Sel(userSettings.get(FILTER_2_TYPE, filSettings.getFilter2Sel()));
		// ---------LFO
		lfo.setLfoFreq(userSettings.getFloat(LFO_FREQ, lfo.getLfoFrq()));
		lfo.setLfoAmplitude(userSettings.getFloat(LFO_AMPL, lfo.getLfoAmplitude()));
		lfo.setLfoWaveSel(userSettings.get(LFO_WAVE, lfo.getLfoWaveSel()));
		// ---------ADSR
		adsr.setAttackTime(userSettings.getFloat(A_TIME, adsr.getAttackTime()));
		adsr.setDecayTime(userSettings.getFloat(D_TIME, adsr.getDecayTime()));
		adsr.setSustainTime(userSettings.getFloat(S_TIME, adsr.getSustainTime()));
		adsr.setReleaseTime(userSettings.getFloat(R_TIME, adsr.getReleaseTime()));
		// ---------EQ
		eq.setHighFreq(userSettings.getFloat(HIGH_FREQ, eq.getHighFreq()));
		eq.setHighGain(userSettings.getFloat(HIGH_GAIN, eq.getHighGain()));
		eq.setLowFreq(userSettings.getFloat(LOW_FREQ, eq.getLowFreq()));
		eq.setLowGain(userSettings.getFloat(LOW_GAIN, eq.getLowGain()));
		// ---------MASTER
		master.setOscMix(userSettings.getFloat(OSC_MIX_VOLUME, master.getOscMix()));
		master.setOsc1Gain(userSettings.getFloat(OSC_1_VOLUME, master.getOsc1Gain()));
		master.setOsc2Gain(userSettings.getFloat(OSC_2_VOLUME, master.getOsc2Gain()));
		master.setFilMix(userSettings.getFloat(FILTER_MIX_VOLUME, master.getFilMix()));
		master.setFil1Gain(userSettings.getFloat(FILTER_1_VOLUME, master.getFil1Gain()));
		master.setFil2Gain(userSettings.getFloat(FILTER_2_VOLUME, master.getFil2Gain()));
		master.setMasterVolume(userSettings.getFloat(MASTER_VOLUME, master.getMasterVolume()));
		// ---------PANNER
		master.setPannerPosition(userSettings.getFloat(PANNER_POS, master.getPannerPosition()));
	}
}
