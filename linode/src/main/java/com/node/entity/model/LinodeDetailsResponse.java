package com.node.entity.model;

import java.util.List;

import com.node.entity.Linode;

public class LinodeDetailsResponse {

	private List<Linode> linodeDetailsList;

	private String statusCode;

	private String statusMessage;

	public List<Linode> getLinodeDetailsList() {
		return linodeDetailsList;
	}

	public void setLinodeDetailsList(List<Linode> linodeDetailsList) {
		this.linodeDetailsList = linodeDetailsList;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
