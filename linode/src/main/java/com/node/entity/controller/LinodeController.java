package com.node.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.node.entity.linodeDetails.exception.DuplicateException;
import com.node.entity.linodeDetails.exception.LinodeDetailsException;
import com.node.entity.model.LinodeDetailsRequest;
import com.node.entity.model.LinodeDetailsResponse;
import com.node.entity.service.Linodeservice;

/**
 * resource class inserts,updates,deletes and retrieves data into/from linode
 * table
 * 
 * @author nsrikanth
 *
 */
@RestController
@RequestMapping("/user")
public class LinodeController {

	@Autowired
	private Linodeservice linodeservice;

	LinodeDetailsResponse linodeDetailsResponse = new LinodeDetailsResponse();

	@PostMapping("/create")
	public ResponseEntity<Object> createInstance(@RequestBody LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException, DuplicateException {

		if (null == linodeDetailsRequest.getLinodeDetails().get(0).getInstanceName()
				|| null == linodeDetailsRequest.getLinodeDetails().get(0).getCpuDetails()
				|| null == linodeDetailsRequest.getLinodeDetails().get(0).getLinodeRam()
				|| null == linodeDetailsRequest.getLinodeDetails().get(0).getLinodeStorage()) {
			throw new LinodeDetailsException("The requested object is null");
		} else {
			linodeDetailsResponse = linodeservice.save(linodeDetailsRequest);
		}
		return new ResponseEntity<>(linodeDetailsResponse, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllInstances() {

		LinodeDetailsResponse linodeDetailsResponse = linodeservice.getAllInstances();
		return new ResponseEntity<>(linodeDetailsResponse, HttpStatus.OK);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getAllInstancesById(@PathVariable Long id) {

		LinodeDetailsResponse linodeDetailsResponse = linodeservice.getAllInstancesById(id);

		return new ResponseEntity<>(linodeDetailsResponse, HttpStatus.OK);

	}

	@PutMapping("/updateById")
	public ResponseEntity<Object> updateById(@RequestBody LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException {
		if (null == linodeDetailsRequest.getLinodeDetails().get(0).getId()) {
			throw new LinodeDetailsException("The requested id's  null");

		} else {
			linodeDetailsResponse = linodeservice.updateById(linodeDetailsRequest);
		}
		return new ResponseEntity<>(linodeDetailsResponse, HttpStatus.OK);

	}

	@PostMapping("/deleteInBatch")
	public ResponseEntity<Object> deleteInBatch(@RequestBody LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException {
		if (linodeDetailsRequest.getLinodeDetails().get(0).getId() == null) {

			throw new LinodeDetailsException("The requested object is null");
		} else {
			linodeDetailsResponse = linodeservice.deleteInBatch(linodeDetailsRequest);
		}
		return new ResponseEntity<>(linodeDetailsResponse, HttpStatus.OK);

	}

}
