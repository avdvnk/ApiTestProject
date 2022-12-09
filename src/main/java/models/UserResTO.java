package models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResTO{
	private String createdAt;
	private String name;
	private String id;
	private String job;
	private String updatedAt;
}