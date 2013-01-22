package bus.uigen.widgets.distributed.nongwt;

public class DirectCommunicator {
	String replicaID;
	String uniqueReplicaID;

	public String getReplicaID() {
		return replicaID;
	}

	public void setReplicaID(String replicaID) {
		this.replicaID = replicaID;
	}

	public String getUniqueReplicaID() {
		return uniqueReplicaID;
	}

	public void setUniqueReplicaID(String rmiUniqueReplicaID) {
		this.uniqueReplicaID = rmiUniqueReplicaID;
	}

	public DirectCommunicator(String replicaID, String uniqueReplicaID) {
		this.replicaID = replicaID;
		this.uniqueReplicaID = uniqueReplicaID;
	}

}
