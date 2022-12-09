package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListUsersResTO{
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	private List<UserDataResTO> data;
	private int page;
	@JsonProperty("total_pages")
	private int totalPages;
	private SupportResTO support;
}