package com.node.entity.service;

import com.node.entity.linodeDetails.exception.DuplicateException;
import com.node.entity.linodeDetails.exception.LinodeDetailsException;
import com.node.entity.model.LinodeDetailsRequest;
import com.node.entity.model.LinodeDetailsResponse;

public interface Linodeservice {

	public LinodeDetailsResponse save(LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException, DuplicateException;

	public LinodeDetailsResponse getAllInstances();

	public LinodeDetailsResponse getAllInstancesById(Long id);

	public LinodeDetailsResponse deleteInBatch(LinodeDetailsRequest linodeDetailsRequest) throws LinodeDetailsException;

	public LinodeDetailsResponse updateById(LinodeDetailsRequest linodeDetailsRequest) throws LinodeDetailsException;

}
