package bus.uigen.widgets.distributed;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Command implements Serializable, IsSerializable {
	private static final long serialVersionUID = 1L;

	String commandText;
	String uniqueSrc, replicaID;
	ProgramDescription programDescription;
	boolean initial;
	int sequenceNumber = -1;

	public Command() {

	}

	public Command(String text, String uniqueSrc, String replicaID,
			ProgramDescription programDescription, boolean initial) {
		this.commandText = text;
		this.uniqueSrc = uniqueSrc;
		this.programDescription = programDescription;
		this.initial = initial;
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
		return programDescription.getApp();
	}

	public String getSession() {
		return programDescription.getSession();
	}

	public String getKind() {
		return programDescription.getKind();
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
				&& ((cmd.programDescription == null & programDescription == null) || cmd.programDescription
						.equals(replicaID))
				&& (cmd.initial == initial)
				&& (cmd.sequenceNumber == sequenceNumber);
	}

	public String toString() {
		return commandText;
	}
}