package source;

import java.util.prefs.Preferences;

public class UserSettings {

	Preferences userSettings;
	Settings settings = Settings.getSettings();
	Master master = Master.getMaster();
	ADSR adsr = ADSR.getADSR();
	LFO lfo = LFO.getLfo();
	EQ eq = EQ.getEQ();

	// ---------OSC
	private final String OSC_1_WAVE = "Osc1Wave";
	private final String OSC_2_WAVE = "";
	private final String OSC_1_PHASE = "";
	private final String OSC_2_PHASE = "";
	// ---------FILTER
	private final String ADD_FILTER_1 = "";
	private final String ADD_FILTER_2 = "";
	private final String FILTER_1_FREQ = "";
	private final String FILTER_2_FREQ = "";
	private final String FILTER_1_TYPE = "";
	private final String FILTER_2_TYPE = "";
	// ---------LFO
	private final String LFO_FREQ = "";
	private final String LFO_AMPL = "";
	private final String LFO_WAVE = "";
	// private final String LFO_ACTION;
	// ---------ADSR
	private final String A_TIME = "";
	private final String D_TIME = "";
	private final String S_TIME = "";
	private final String R_TIME = "";
	// ---------EQ
	private final String HIGH_FREQ = "";
	private final String HIGH_GAIN = "";
	private final String LOW_FREQ = "";
	private final String LOW_GAIN = "";
	// ---------MASTER
	private final String OSC_MIX_VOLUME = "";
	private final String OSC_1_VOLUME = "";
	private final String OSC_2_VOLUME = "";
	private final String FILTER_MIX_VOLUME = "";
	private final String FILTER_1_VOLUME = "";
	private final String FILTER_2_VOLUME = "";
	private final String MASTER_VOLUME = "";
	// ---------PANNER
	private final String PANNER_POS = "";
	
	public UserSettings(){
		userSettings = Preferences.userRoot();

	}
	
	public void saveSettings() {

		// ---------OSC
		userSettings.put(OSC_1_WAVE, settings.getWave1Sel());
		userSettings.put(OSC_2_WAVE, settings.getWave2Sel());
		userSettings.putFloat(OSC_1_PHASE, settings.getWave1Phase());
		userSettings.putFloat(OSC_2_PHASE, settings.getWave2Phase());
		// ---------FILTER
		userSettings.putBoolean(ADD_FILTER_1, settings.getFilterWave1());
		userSettings.putBoolean(ADD_FILTER_2, settings.getFilterWave2());
		userSettings.putFloat(FILTER_1_FREQ, settings.getFilter1Freq());
		userSettings.putFloat(FILTER_2_FREQ, settings.getFilter2Freq());
		userSettings.put(FILTER_1_TYPE, settings.getFilter1Sel());
		userSettings.put(FILTER_2_TYPE, settings.getFilter2Sel());
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
		settings.setWave1Sel(userSettings.get(OSC_1_WAVE, settings.getWave1Sel()));
		settings.setWave2Sel(userSettings.get(OSC_2_WAVE, settings.getWave2Sel()));
		settings.setWave1Phase(userSettings.getFloat(OSC_1_PHASE, settings.getWave1Phase()));
		settings.setWave2Phase(userSettings.getFloat(OSC_2_PHASE, settings.getWave2Phase()));
		// ---------FILTER
		userSettings.getBoolean(ADD_FILTER_1, settings.getFilterWave1());
		userSettings.getBoolean(ADD_FILTER_2, settings.getFilterWave2());
		userSettings.getFloat(FILTER_1_FREQ, settings.getFilter1Freq());
		userSettings.getFloat(FILTER_2_FREQ, settings.getFilter2Freq());
		userSettings.get(FILTER_1_TYPE, settings.getFilter1Sel());
		userSettings.get(FILTER_2_TYPE, settings.getFilter2Sel());
		// ---------LFO
		userSettings.getFloat(LFO_FREQ, lfo.getLfoFrq());
		userSettings.getFloat(LFO_AMPL, lfo.getLfoAmplitude());
		userSettings.get(LFO_WAVE, lfo.getLfoWaveSel());
		// ---------ADSR
		userSettings.getFloat(A_TIME, adsr.getAttackTime());
		userSettings.getFloat(D_TIME, adsr.getDecayTime());
		userSettings.getFloat(S_TIME, adsr.getSustainTime());
		userSettings.getFloat(R_TIME, adsr.getReleaseTime());
		// ---------EQ
		userSettings.getFloat(HIGH_FREQ, eq.getHighFreq());
		userSettings.getFloat(HIGH_GAIN, eq.getHighGain());
		userSettings.getFloat(LOW_FREQ, eq.getLowFreq());
		userSettings.getFloat(LOW_GAIN, eq.getLowGain());
		// ---------MASTER
		userSettings.getFloat(OSC_MIX_VOLUME, master.getOscMix());
		userSettings.getFloat(OSC_1_VOLUME, master.getOsc1Gain());
		userSettings.getFloat(OSC_2_VOLUME, master.getOsc2Gain());
		userSettings.getFloat(FILTER_MIX_VOLUME, master.getFilMix());
		userSettings.getFloat(FILTER_1_VOLUME, master.getFil1Gain());
		userSettings.getFloat(FILTER_2_VOLUME, master.getFil2Gain());
		userSettings.getFloat(MASTER_VOLUME, master.getMasterVolume());
		// ---------PANNER
		userSettings.getFloat(PANNER_POS, master.getPannerPosition());
	}
}
