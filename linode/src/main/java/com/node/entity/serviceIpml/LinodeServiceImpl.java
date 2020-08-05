package com.node.entity.serviceIpml;

import static com.node.entity.linodeDetails.constant.LinodeDetailsConstants.DELETE;
import static com.node.entity.linodeDetails.constant.LinodeDetailsConstants.SAVE;
import static com.node.entity.linodeDetails.constant.LinodeDetailsConstants.UPDATE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.node.entity.Linode;
import com.node.entity.linodeDetails.exception.DuplicateException;
import com.node.entity.linodeDetails.exception.LinodeDetailsException;
import com.node.entity.model.LinodeDetailsRequest;
import com.node.entity.model.LinodeDetailsResponse;
import com.node.entity.repo.Linoderepo;
import com.node.entity.service.Linodeservice;

@Service
public class LinodeServiceImpl implements Linodeservice {
	@Autowired
	private Linoderepo linoderepo;

	LinodeDetailsResponse linodeDetailsResponse = new LinodeDetailsResponse();

	/**
	 * method inserts data into linode table
	 * 
	 * @param Linode
	 * @param linodeDetailsResponse transaction type
	 * @return
	 * @throws LinodeDetailsException
	 * @throws DuplicateException
	 */

	@Override
	public LinodeDetailsResponse save(LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException, DuplicateException {

		if (linodeDetailsRequest.getTransactionType().equalsIgnoreCase(SAVE)) {

			return insertLinodeDetails(linodeDetailsRequest.getLinodeDetails(), linodeDetailsResponse);

		} else if (null == linodeDetailsRequest.getTransactionType()
				|| linodeDetailsRequest.getTransactionType() == "") {
			linodeDetailsResponse.setStatusCode("400");
			linodeDetailsResponse.setStatusMessage("Requested transaction type is wrong");
			return linodeDetailsResponse;
		}

		return linodeDetailsResponse;
	}

	private LinodeDetailsResponse insertLinodeDetails(List<Linode> linodeDetails,
			LinodeDetailsResponse linodeDetailsResponse2) throws DuplicateException {
		try {
			List<Linode> linodeDetailslist = new ArrayList<>();
			List<Linode> saveAllDetails = linoderepo.saveAll(linodeDetails);
			linodeDetailslist.addAll(saveAllDetails);
			linodeDetailsResponse.setLinodeDetailsList(linodeDetailslist);
			linodeDetailsResponse.setStatusCode("200");
			linodeDetailsResponse.setStatusMessage("records saved successfully");
			linodeDetailsResponse.setLinodeDetailsList(linodeDetailslist);
			return linodeDetailsResponse;

		} catch (Exception e) {
			throw new DuplicateException("Duplicates are not allowed");
		}

	}

	/**
	 * method retrieves data from Linode table
	 */
	@Override
	public LinodeDetailsResponse getAllInstances() {

		List<Linode> linodeDetailslist = null;
		linodeDetailslist = linoderepo.getAllInsces();
		linodeDetailsResponse.setStatusCode("200");
		linodeDetailsResponse.setStatusMessage("success");
		linodeDetailsResponse.setLinodeDetailsList(linodeDetailslist);
		return linodeDetailsResponse;
	}

	/**
	 * method retrieves data from Linode table
	 */

	@Override
	public LinodeDetailsResponse getAllInstancesById(Long id) {
		List<Linode> linodeDetailslist = new ArrayList<>();
		Linode linode = linoderepo.getOne(id);

		linodeDetailslist.add(linode);
		linodeDetailsResponse.setLinodeDetailsList(linodeDetailslist);
		linodeDetailsResponse.setStatusCode("200");
		linodeDetailsResponse.setStatusMessage("success");
		linodeDetailsResponse.setLinodeDetailsList(linodeDetailslist);
		return linodeDetailsResponse;
	}

	/**
	 * method deletes data from Linode table
	 * 
	 * @param Linode
	 * @param linodeDetailsResponse
	 * @return
	 * @throws LinodeDetailsException
	 */

	@Override
	public LinodeDetailsResponse deleteInBatch(LinodeDetailsRequest linodeDetailsRequest)
			throws LinodeDetailsException {

		if (linodeDetailsRequest.getTransactionType().equalsIgnoreCase(DELETE)) {
			linoderepo.deleteInBatch(linodeDetailsRequest.getLinodeDetails());
			linodeDetailsResponse.setStatusCode("200");
			linodeDetailsResponse.setStatusMessage("records deleted successfully");
		}
		return linodeDetailsResponse;
	}

	/**
	 * method updates data into Linode table
	 * 
	 * @param Linode
	 * @param linodeDetailsResponse
	 * @return
	 * @throws LinodeDetailsException
	 */

	@Override
	public LinodeDetailsResponse updateById(LinodeDetailsRequest linodeDetailsRequest) throws LinodeDetailsException {
		List<Linode> linodeDetails = linodeDetailsRequest.getLinodeDetails();
		if (linodeDetailsRequest.getTransactionType().equalsIgnoreCase(UPDATE)) {
			linoderepo.saveAll(linodeDetails);
			linodeDetailsResponse.setStatusCode("200");
			linodeDetailsResponse.setStatusMessage("records updated successfully");
		}
		return linodeDetailsResponse;
	}

}
