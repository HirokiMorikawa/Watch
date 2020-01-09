package watchSimulater;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import watchMoniter.TodayDate;
import watchMoniter.TodayTime;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class WatchSimulater extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8626389521708258814L;
	private static final int interval = 180;
	private TodayDate todayDate;
	private TodayTime todayTime;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WatchSimulater frame = new WatchSimulater();
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
	public WatchSimulater() {
		todayDate = new TodayDate();
		todayTime = todayDate.getTodayTime();
		setTitle("新世紀時計くんver 改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		todayTime.setTimeOfNow();
		lblNewLabel = new JLabel(String.format("%3d :%3d :%3d",
				todayTime.getHour(), todayTime.getMinute(),
				todayTime.getSecond()));
		lblNewLabel.setFont(new Font("Brush Script MT", Font.PLAIN, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBackground(new Color(173, 216, 230));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		timer = new Timer(interval, this);
		lblNewLabel_1 = new JLabel("ただいまの時刻は");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		contentPane.add(lblNewLabel_1, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("でございます。");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_2, BorderLayout.SOUTH);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { lblNewLabel_1, lblNewLabel, lblNewLabel_2 }));
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		todayTime.setTimeOfNow();
		lblNewLabel.setText(String.format("%3d :%3d :%3d", todayTime.getHour(),
				todayTime.getMinute(), todayTime.getSecond()));

	}
}
