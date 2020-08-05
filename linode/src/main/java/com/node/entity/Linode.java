package com.node.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "LinodeDetails")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Linode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String instanceName;
	private String cpuDetails;
	private String linodeStorage;
	private String linodeRam;

	public Linode() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getCpuDetails() {
		return cpuDetails;
	}

	public void setCpuDetails(String cpuDetails) {
		this.cpuDetails = cpuDetails;
	}

	public String getLinodeStorage() {
		return linodeStorage;
	}

	public void setLinodeStorage(String linodeStorage) {
		this.linodeStorage = linodeStorage;
	}

	public String getLinodeRam() {
		return linodeRam;
	}

	public void setLinodeRam(String linodeRam) {
		this.linodeRam = linodeRam;
	}

	@Override
	public String toString() {
		return "Linode [id=" + id + ", instanceName=" + instanceName + ", cpuDetails=" + cpuDetails + ", linodeStorage="
				+ linodeStorage + ", linodeRam=" + linodeRam + "]";
	}

	

	
}
