package com.telstra.codechallenge.git;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GitHottestSearchResponse {
	@JsonProperty("items")
	private List<Item> items;
}
