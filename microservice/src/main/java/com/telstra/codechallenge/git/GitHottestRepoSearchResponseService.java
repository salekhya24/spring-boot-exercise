package com.telstra.codechallenge.git;

import static com.telstra.codechallenge.utils.DateUtil.getLastLocalDate;
import static com.telstra.codechallenge.utils.DateUtil.getYYYYMMDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telstra.codechallenge.Exception.GitServiceConfigurationException;
import com.telstra.codechallenge.Exception.GitServiceConnectionException;
import com.telstra.codechallenge.Exception.GitServiceDataException;

@Service

public class GitHottestRepoSearchResponseService {

	@Value("${git.base.url}")
	private String gitBaseUrl;

	@Autowired
	RestTemplate restTemplate;

	public GitHottestSearchResponse getHottestRepos(int noOfRepos, int noWeekDays) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.ACCEPT, GitConstants.HEADER_VALUE);

			UriComponentsBuilder builder = getUriComponentsBuilder(gitBaseUrl, noOfRepos, noWeekDays);
			builder.build().toString();

			return this.restTemplate.exchange(builder.build().toString(), HttpMethod.GET, new HttpEntity<>(headers),
					GitHottestSearchResponse.class).getBody();

		} catch (RestClientException e) {
			throw new GitServiceConnectionException("Failed to connect to the Git API.", e);
		} catch (HttpMessageNotReadableException e) {
			throw new GitServiceDataException("Error reading data from the Git API.", e);
		} catch (Exception e) {
			throw new GitServiceConfigurationException("Configuration issue in Git service.", e);
		}
	}

	private UriComponentsBuilder getUriComponentsBuilder(String url, int noOfRepos, int lastDays) {
		return UriComponentsBuilder.fromHttpUrl(url)
				.queryParam(GitConstants.QUERY, GitConstants.CREATED_DATE + getYYYYMMDD(getLastLocalDate(lastDays)))
				.queryParam(GitConstants.SORT_KEY, GitConstants.STARS)
				.queryParam(GitConstants.ORDER_KEY, GitConstants.DESC)
				.queryParam(GitConstants.PER_PAGE_LIMIT, noOfRepos);

	}

}
