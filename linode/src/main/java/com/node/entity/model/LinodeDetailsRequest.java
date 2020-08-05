package com.node.entity.model;

import java.util.List;

import com.node.entity.Linode;

public class LinodeDetailsRequest {

	private List<Linode> linodeDetails;

	private String transactionType;

	public List<Linode> getLinodeDetails() {
		return linodeDetails;
	}

	public void setLinodeDetails(List<Linode> linodeDetails) {
		this.linodeDetails = linodeDetails;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
