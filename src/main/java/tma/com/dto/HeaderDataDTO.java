package tma.com.dto;

public class HeaderDataDTO {
	
	private String nameInExcelFile;
	private String nameForUI;
	private String category;
	
	public HeaderDataDTO() {}

	public HeaderDataDTO(String nameInExcelFile, String nameForUI, String category) {
		super();
		this.nameInExcelFile = nameInExcelFile;
		this.nameForUI = nameForUI;
		this.category = category;
	}

	public String getNameInExcelFile() {
		return nameInExcelFile;
	}

	public void setNameInExcelFile(String nameInExcelFile) {
		this.nameInExcelFile = nameInExcelFile;
	}

	public String getNameForUI() {
		return nameForUI;
	}

	public void setNameForUI(String nameForUI) {
		this.nameForUI = nameForUI;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
