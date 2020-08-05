package com.node.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.node.entity.Linode;

public interface Linoderepo extends JpaRepository<Linode,Long >{

	@Query(value="select * from Linode",nativeQuery =true)
	List<Linode>getAllInsces();
	


}

