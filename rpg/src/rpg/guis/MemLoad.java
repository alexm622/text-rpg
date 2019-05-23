package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;



import java.awt.Color;
import javax.swing.JPanel;


public class MemLoad {

	private JFrame frmLoading;
	private JLabel loadingAsset;
	private JLabel percent;
	private JProgressBar loadProgress;
	private JLabel loadingText;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemLoad window = new MemLoad();
					window.frmLoading.setVisible(true);
				} catch (Exception e) {
					rpg.game.Handler.debug(e.toString(), true);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemLoad() {
		initialize();

		
		
		frmLoading.setVisible(true);
		

	}

	public void Close() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			rpg.game.Handler.debug(e.toString(), true);
			e.printStackTrace();
		}
		frmLoading.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmLoading = new JFrame();
		frmLoading.setTitle("Loading");
		frmLoading.getContentPane().setBackground(new Color(222, 184, 135));
		
		frmLoading.setResizable(false);
		frmLoading.setBounds(100, 100, 450, 114);
		frmLoading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoading.getContentPane().setLayout(null);
		
		JPanel loadBar = new JPanel();
		loadBar.setBounds(15, 52, 414, 25);
		frmLoading.getContentPane().add(loadBar);
		loadBar.setLayout(null);

		this.loadingAsset = new JLabel();
		loadingAsset.setBounds(12, 0, 386, 25);
		loadBar.add(loadingAsset);
		loadingAsset.setText("Asset Being Loaded");

		this.loadProgress = new JProgressBar();
		loadProgress.setBounds(0, 0, 414, 25);
		loadBar.add(loadProgress);
		loadProgress.setOpaque(true);
		loadProgress.setBackground(new Color(245, 222, 179));
		loadProgress.setForeground(new Color(255, 215, 0));
				
				JPanel loadText = new JPanel();
				loadText.setOpaque(false);
				loadText.setBounds(97, 11, 250, 25);
				frmLoading.getContentPane().add(loadText);
								
										this.loadingText = new JLabel();
										loadText.add(loadingText);
										loadingText.setText("Loading:");
										loadingText.setFont(new Font("Tahoma", Font.BOLD, 15));
						
								this.percent = new JLabel();
								loadText.add(percent);
								percent.setText("percent");
								percent.setFont(new Font("Tahoma", Font.BOLD, 15));
	}

	public void setAsset(String path) {
		rpg.game.Handler.debug("ran the set asset method");
		frmLoading.validate();
	}

	public JLabel getLoadingAsset() {
		return this.loadingAsset;
	}

	public void setLoadingAsset(JLabel loadingAsset) {
		this.loadingAsset = loadingAsset;
	}

	public JLabel getPercent() {
		return this.percent;
	}

	public void setPercent(JLabel percent) {
		this.percent = percent;
	}

	public JProgressBar getLoadProgress() {
		return this.loadProgress;
	}

	public void setLoadProgress(JProgressBar loadProgress) {
		this.loadProgress = loadProgress;
	}

	public JLabel getLoadingText() {
		return this.loadingText;
	}

	public void setLoadingText(JLabel loadingText) {
		this.loadingText = loadingText;
	}

	public JFrame getFrame() {
		return this.frmLoading;
	}

	public void setFrame(JFrame frame) {
		this.frmLoading = frame;
	}

	public void setTempBool(boolean bool) {
	}
}
