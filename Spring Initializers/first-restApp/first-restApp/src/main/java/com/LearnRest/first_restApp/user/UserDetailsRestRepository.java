package com.LearnRest.first_restApp.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//@RepositoryRestResource(path="MyUserDetails")
public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails,Long> {
	List<UserDetails> findByRole(String string);
}
