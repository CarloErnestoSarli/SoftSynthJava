/**
 * @file VirtualKeyboard.java
 * @author Carlo Sarli 
 * @brief THe virtual keyboard class generates a gui for the virtual keyboard with all the necessary actions listeners
 */
package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import source.FilterSettings;
import source.Keyboard;
import source.OscillatorSettings;
import source.Settings;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class VirtualKeyboard.
 */
public class VirtualKeyboard extends JFrame {
	
	/** The keyboard. */
	Keyboard keyboard = new Keyboard();
	
	/** The settings. */
	Settings settings = Settings.getSettings();
	
	/** The osc settings. */
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();
	
	/** The content pane. */
	private JPanel contentPane;
	
	
	/** The rdbtn octaves. */
	JRadioButton rdbtnOctaves;
	
	/** The rdbtn octaves 1. */
	JRadioButton rdbtnOctaves_1;
	
	/** The rdbtn octaves 2. */
	JRadioButton rdbtnOctaves_2;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirtualKeyboard frame = new VirtualKeyboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VirtualKeyboard() {
		setTitle("Keyboard");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton CsKey = new JButton("");
		CsKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int assignedNote1 = 1 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 1 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		CsKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		CsKey.setContentAreaFilled(false);
		CsKey.setActionCommand("");
		CsKey.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		CsKey.setBackground(Color.BLACK);
		CsKey.setBounds(35, 11, 45, 100);
		contentPane.add(CsKey);
		
		JButton DsKey = new JButton("");
		DsKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 3 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 3 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		DsKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		DsKey.setActionCommand("");
		DsKey.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		DsKey.setContentAreaFilled(false);
		DsKey.setBackground(Color.BLACK);
		DsKey.setBounds(90, 11, 45, 100);
		contentPane.add(DsKey);
		
		JButton FsKey = new JButton("");
		FsKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 6 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 6 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		FsKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		FsKey.setActionCommand("");
		FsKey.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		FsKey.setContentAreaFilled(false);
		FsKey.setBackground(Color.BLACK);
		FsKey.setBounds(201, 11, 45, 100);
		contentPane.add(FsKey);
		
		JButton GsKey = new JButton("");
		GsKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 8 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 8 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		GsKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		GsKey.setActionCommand("");
		GsKey.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		GsKey.setContentAreaFilled(false);
		GsKey.setBackground(Color.BLACK);
		GsKey.setBounds(256, 11, 45, 100);
		contentPane.add(GsKey);
		
		JButton AsKey = new JButton("");
		AsKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 10 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 10 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		AsKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		AsKey.setActionCommand("");
		AsKey.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		AsKey.setContentAreaFilled(false);
		AsKey.setBackground(Color.BLACK);
		AsKey.setBounds(311, 11, 45, 100);
		contentPane.add(AsKey);
		
		JButton CKey = new JButton("");
		CKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				settings.setPlay(true);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				settings.setPlay(false);
			}
		});
		CKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 0 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 0 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		CKey.setContentAreaFilled(false);
		CKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		CKey.setBackground(Color.BLACK);
		CKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		CKey.setBackground(Color.BLACK);
		CKey.setBounds(10, 11, 45, 170);
		contentPane.add(CKey);
		
		JButton Cs1Key = new JButton("");
		Cs1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 13 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 13 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Cs1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Cs1Key.setActionCommand("");
		Cs1Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Cs1Key.setContentAreaFilled(false);
		Cs1Key.setBackground(Color.BLACK);
		Cs1Key.setBounds(417, 11, 45, 100);
		contentPane.add(Cs1Key);
		
		JButton Ds1Key = new JButton("");
		Ds1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 15 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 15 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Ds1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Ds1Key.setActionCommand("");
		Ds1Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Ds1Key.setContentAreaFilled(false);
		Ds1Key.setBackground(Color.BLACK);
		Ds1Key.setBounds(472, 11, 45, 100);
		contentPane.add(Ds1Key);
		
		JButton Fs1Key = new JButton("");
		Fs1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 18 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 18 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Fs1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Fs1Key.setActionCommand("");
		Fs1Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Fs1Key.setContentAreaFilled(false);
		Fs1Key.setBackground(Color.BLACK);
		Fs1Key.setBounds(583, 11, 45, 100);
		contentPane.add(Fs1Key);
		
		JButton Gs1Key = new JButton("");
		Gs1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 20 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 20 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Gs1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Gs1Key.setActionCommand("");
		Gs1Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Gs1Key.setContentAreaFilled(false);
		Gs1Key.setBackground(Color.BLACK);
		Gs1Key.setBounds(638, 11, 45, 100);
		contentPane.add(Gs1Key);
		
		JButton As1Key = new JButton("");
		As1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 22 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 22 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		As1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		As1Key.setActionCommand("");
		As1Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		As1Key.setContentAreaFilled(false);
		As1Key.setBackground(Color.BLACK);
		As1Key.setBounds(693, 11, 45, 100);
		contentPane.add(As1Key);
		
		JButton Cs2Key = new JButton("");
		Cs2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 25 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 25 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Cs2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Cs2Key.setActionCommand("");
		Cs2Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Cs2Key.setContentAreaFilled(false);
		Cs2Key.setBackground(Color.BLACK);
		Cs2Key.setBounds(802, 11, 45, 100);
		contentPane.add(Cs2Key);
		
		JButton Ds2Key = new JButton("");
		Ds2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 27 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 27 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Ds2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Ds2Key.setActionCommand("");
		Ds2Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Ds2Key.setContentAreaFilled(false);
		Ds2Key.setBackground(Color.BLACK);
		Ds2Key.setBounds(857, 11, 45, 100);
		contentPane.add(Ds2Key);
		
		JButton Fs2Key = new JButton("");
		Fs2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 30 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 30 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Fs2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Fs2Key.setActionCommand("");
		Fs2Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Fs2Key.setContentAreaFilled(false);
		Fs2Key.setBackground(Color.BLACK);
		Fs2Key.setBounds(968, 11, 45, 100);
		contentPane.add(Fs2Key);
		
		JButton Gs2Key = new JButton("");
		Gs2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 32 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 32 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		Gs2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		Gs2Key.setActionCommand("");
		Gs2Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		Gs2Key.setContentAreaFilled(false);
		Gs2Key.setBackground(Color.BLACK);
		Gs2Key.setBounds(1023, 11, 45, 100);
		contentPane.add(Gs2Key);
		
		JButton As2Key = new JButton("");
		As2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 34 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 34 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		As2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/BlackKey.jpg")));
		As2Key.setActionCommand("");
		As2Key.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new LineBorder(new Color(255, 255, 255))));
		As2Key.setContentAreaFilled(false);
		As2Key.setBackground(Color.BLACK);
		As2Key.setBounds(1078, 11, 45, 100);
		contentPane.add(As2Key);
		
		JButton DKey = new JButton("");
		DKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 2 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 2 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		DKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		DKey.setContentAreaFilled(false);
		DKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		DKey.setBackground(Color.BLACK);
		DKey.setBounds(65, 11, 45, 170);
		contentPane.add(DKey);
		
		JButton FKey = new JButton("");
		FKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 5 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 5 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		FKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		FKey.setContentAreaFilled(false);
		FKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FKey.setBackground(Color.BLACK);
		FKey.setBounds(175, 11, 45, 170);
		contentPane.add(FKey);
		
		JButton EKey = new JButton("");
		EKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 4 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 4 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		EKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		EKey.setContentAreaFilled(false);
		EKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		EKey.setBackground(Color.BLACK);
		EKey.setBounds(120, 11, 45, 170);
		contentPane.add(EKey);
		
		JButton AKey = new JButton("");
		AKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 9 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 9 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		AKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		AKey.setContentAreaFilled(false);
		AKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		AKey.setBackground(Color.BLACK);
		AKey.setBounds(285, 11, 45, 170);
		contentPane.add(AKey);
		
		JButton GKey = new JButton("");
		GKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 7 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 7 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		GKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		GKey.setContentAreaFilled(false);
		GKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GKey.setBackground(Color.BLACK);
		GKey.setBounds(230, 11, 45, 170);
		contentPane.add(GKey);
		
		JButton C1Key = new JButton("");
		C1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 12 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 12 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		C1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		C1Key.setContentAreaFilled(false);
		C1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		C1Key.setBackground(Color.BLACK);
		C1Key.setBounds(395, 11, 45, 170);
		contentPane.add(C1Key);
		
		JButton BKey = new JButton("");
		BKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 11 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 11 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		BKey.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		BKey.setContentAreaFilled(false);
		BKey.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		BKey.setBackground(Color.BLACK);
		BKey.setBounds(340, 11, 45, 170);
		contentPane.add(BKey);
		
		JButton E1Key = new JButton("");
		E1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 16 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 16 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		E1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		E1Key.setContentAreaFilled(false);
		E1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		E1Key.setBackground(Color.BLACK);
		E1Key.setBounds(505, 11, 45, 170);
		contentPane.add(E1Key);
		
		JButton D1Key = new JButton("");
		D1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 14 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 14 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		D1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		D1Key.setContentAreaFilled(false);
		D1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		D1Key.setBackground(Color.BLACK);
		D1Key.setBounds(450, 11, 45, 170);
		contentPane.add(D1Key);
		
		JButton G1Key = new JButton("");
		G1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 19 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 19 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		G1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		G1Key.setContentAreaFilled(false);
		G1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		G1Key.setBackground(Color.BLACK);
		G1Key.setBounds(615, 11, 45, 170);
		contentPane.add(G1Key);
		
		JButton F1Key = new JButton("");
		F1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 17 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 17 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		F1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		F1Key.setContentAreaFilled(false);
		F1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		F1Key.setBackground(Color.BLACK);
		F1Key.setBounds(560, 11, 45, 170);
		contentPane.add(F1Key);
		
		JButton B1Key = new JButton("");
		B1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 23 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 23 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		B1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		B1Key.setContentAreaFilled(false);
		B1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		B1Key.setBackground(Color.BLACK);
		B1Key.setBounds(725, 11, 45, 170);
		contentPane.add(B1Key);
		
		JButton A1Key = new JButton("");
		A1Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 21 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 21 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		A1Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		A1Key.setContentAreaFilled(false);
		A1Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		A1Key.setBackground(Color.BLACK);
		A1Key.setBounds(670, 11, 45, 170);
		contentPane.add(A1Key);
		
		JButton D2Key = new JButton("");
		D2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 26 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 26 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		D2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		D2Key.setContentAreaFilled(false);
		D2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		D2Key.setBackground(Color.BLACK);
		D2Key.setBounds(835, 11, 45, 170);
		contentPane.add(D2Key);
		
		JButton C2Key = new JButton("");
		C2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 24 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 24 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		C2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		C2Key.setContentAreaFilled(false);
		C2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		C2Key.setBackground(Color.BLACK);
		C2Key.setBounds(780, 11, 45, 170);
		contentPane.add(C2Key);
		
		JButton F2Key = new JButton("");
		F2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 29 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 29 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		F2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		F2Key.setContentAreaFilled(false);
		F2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		F2Key.setBackground(Color.BLACK);
		F2Key.setBounds(945, 11, 45, 170);
		contentPane.add(F2Key);
		
		JButton E2Key = new JButton("");
		E2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 28 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 28 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		E2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		E2Key.setContentAreaFilled(false);
		E2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		E2Key.setBackground(Color.BLACK);
		E2Key.setBounds(890, 11, 45, 170);
		contentPane.add(E2Key);
		
		JButton A2Key = new JButton("");
		A2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 33 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 33 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		A2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		A2Key.setContentAreaFilled(false);
		A2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		A2Key.setBackground(Color.BLACK);
		A2Key.setBounds(1055, 11, 45, 170);
		contentPane.add(A2Key);
		
		JButton G2Key = new JButton("");
		G2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignedNote1 = 31 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 31 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2 + oscSettings.getFineTuning2()))));
			}
		});
		G2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		G2Key.setContentAreaFilled(false);
		G2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		G2Key.setBackground(Color.BLACK);
		G2Key.setBounds(1000, 11, 45, 170);
		contentPane.add(G2Key);
		
		JButton B2Key = new JButton("");
		B2Key.setIcon(new ImageIcon(VirtualKeyboard.class.getResource("/Pics/WhiteKey.jpg")));
		B2Key.setContentAreaFilled(false);
		B2Key.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		B2Key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int assignedNote1 = 35 + (12* (selectRightOctave() + oscSettings.getTranspose1()));
				int assignedNote2 = 35 + (12* (selectRightOctave() + oscSettings.getTranspose2()));
				oscSettings.setOsc1Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote1 + oscSettings.getFineTuning1()))));
				oscSettings.setOsc2Freq(keyboard.pitchToFrequency(keyboard.getMidifromNote(keyboard.getNote(assignedNote2+ oscSettings.getFineTuning2()))));
			}
		});
		B2Key.setBackground(Color.BLACK);
		B2Key.setBounds(1110, 11, 45, 170);
		contentPane.add(B2Key);
		
		rdbtnOctaves = new JRadioButton("Octaves 1-3");
		rdbtnOctaves.setBounds(1161, 11, 109, 23);
		contentPane.add(rdbtnOctaves);
		
		rdbtnOctaves_1 = new JRadioButton("Octaves 4-6");
		rdbtnOctaves_1.setSelected(true);
		rdbtnOctaves_1.setBounds(1161, 37, 109, 23);
		contentPane.add(rdbtnOctaves_1);
		
		rdbtnOctaves_2 = new JRadioButton("Octaves 7-9");
		rdbtnOctaves_2.setBounds(1161, 63, 109, 23);
		contentPane.add(rdbtnOctaves_2);
		
		ButtonGroup OctavesGroup = new ButtonGroup();
		OctavesGroup.add(rdbtnOctaves);
		OctavesGroup.add(rdbtnOctaves_1);
		OctavesGroup.add(rdbtnOctaves_2);
	}
	
	/**
	 * Select right octave.
	 *
	 * @return the int
	 */
	public int selectRightOctave(){
		int factor = 0;
		if(rdbtnOctaves.isSelected()){
			//do nothing
		}else if(rdbtnOctaves_1.isSelected()){
			factor = 3;
		}else if(rdbtnOctaves_2.isSelected()){
			factor = 6;
		}
		return factor;
	}
}
