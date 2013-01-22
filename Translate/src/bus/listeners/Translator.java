package bus.listeners;

import java.io.Serializable;

public interface Translator extends Serializable {
	public String translate(String original);
}
