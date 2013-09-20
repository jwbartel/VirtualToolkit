package bus.uigen.widgets;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Command implements Serializable, IsSerializable {
	private static final long serialVersionUID = 1L;

	String commandText;
	String uniqueSrc, replicaID, application, session, program;
	boolean initial;
	int sequenceNumber = -1;

	public Command() {

	}

	public Command(String text, String uniqueSrc, String replicaID,
			String application, String session, String program, boolean initial) {
		this.commandText = text;
		this.uniqueSrc = uniqueSrc;
		this.application = application;
		this.session = session;
		this.program = program;
		this.initial = initial;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setText(String text) {
		this.commandText = text;
	}

	public void setSource(String source) {
		this.uniqueSrc = source;
	}

	public String getText() {
		return commandText;
	}

	public String getSource() {
		return uniqueSrc;
	}

	public String getApplication() {
		return application;
	}

	public String getSession() {
		return session;
	}

	public String getProgram() {
		return program;
	}

	public String getReplicaID() {
		return replicaID;
	}

	public void setReplicaID(String replicaID) {
		this.replicaID = replicaID;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public boolean isInitial() {
		return initial;
	}

	public void setInitial(boolean initial) {
		this.initial = initial;
	}

	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (!(object instanceof Command)) {
			return false;
		}

		Command cmd = (Command) object;
		return ((cmd.commandText == null & commandText == null) || cmd.commandText
				.equals(commandText))
				&& ((cmd.uniqueSrc == null & uniqueSrc == null) || cmd.uniqueSrc
						.equals(uniqueSrc))
				&& ((cmd.replicaID == null & replicaID == null) || cmd.replicaID
						.equals(replicaID))
				&& ((cmd.application == null & application == null) || cmd.application
						.equals(application))
				&& ((cmd.session == null & session == null) || cmd.session
						.equals(session))
				&& ((cmd.program == null & program == null) || cmd.program
						.equals(program))
				&& (cmd.initial == initial)
				&& (cmd.sequenceNumber == sequenceNumber);
	}

	public String toString() {
		return commandText;
	}
}