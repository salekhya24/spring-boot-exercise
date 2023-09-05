package com.telstra.codechallenge.git;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class GitHottestRepoSearchController {
	
	public static final int NO_WEEK_DAYS = 7;
	private final GitHottestRepoSearchResponseService gitHottestRepoSearchResponseService;

	@Autowired
	public GitHottestRepoSearchController(GitHottestRepoSearchResponseService gitHottestRepoSearchResponseService) {
		this.gitHottestRepoSearchResponseService = gitHottestRepoSearchResponseService;
	}
	
	@GetMapping(path ="/hottest/{noOfRepos}")
	public ResponseEntity<GitHottestSearchResponse> getHottestRepos(@PathVariable int noOfRepos){
		if(noOfRepos<0)
             throw new IllegalArgumentException("No of Repos cannot be a negative");
		else
		return ResponseEntity.ok(gitHottestRepoSearchResponseService.getHottestRepos(noOfRepos, NO_WEEK_DAYS));
	}
	
}
