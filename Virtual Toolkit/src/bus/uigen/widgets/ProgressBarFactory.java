package bus.uigen.widgets;

public interface ProgressBarFactory {
	// public VirtualSlider createSlider (String text);
	public VirtualProgressBar createProgressBar(int val);

	public VirtualProgressBar createProgressBar(int val, int min, int max);

	public VirtualProgressBar createProgressBar();
}
