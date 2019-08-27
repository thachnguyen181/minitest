package tma.com.dto;

import java.util.Date;

public class IndexDTO {
	
	private int id;
	private String indexName;
	private String displayName;
	private Long createdAt;
	private Long updatedAt;
	
	public IndexDTO() {}
	
	public IndexDTO(int id, String indexName, String displayName, Long createdAt, Long updatedAt) {
		super();
		this.id = id;
		this.indexName = indexName;
		this.displayName = displayName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreateAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}		
}
