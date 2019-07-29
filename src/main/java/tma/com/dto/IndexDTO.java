package tma.com.dto;

public class IndexDTO {
	
	private int id;
	private String indexName;
	private String displayName;
	private String createAt;
	private String updatedAt;
	
	public IndexDTO() {}
	
	public IndexDTO(int id, String indexName, String displayName, String createAt, String updatedAt) {
		super();
		this.id = id;
		this.indexName = indexName;
		this.displayName = displayName;
		this.createAt = createAt;
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

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}		
}
