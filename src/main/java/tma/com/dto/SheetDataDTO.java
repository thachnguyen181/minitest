package tma.com.dto;

import java.util.List;

public class SheetDataDTO {
	
	private String sheetName;
	private String geoLevel;
	private List<HeaderDataDTO> listHeaderData;
	private List<String> listRowData;
	
	public SheetDataDTO() {}

	public SheetDataDTO(String sheetName, String geoLevel, List<HeaderDataDTO> listHeaderData,
			List<String> listRowData) {
		super();
		this.sheetName = sheetName;
		this.geoLevel = geoLevel;
		this.listHeaderData = listHeaderData;
		this.listRowData = listRowData;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getGeoLevel() {
		return geoLevel;
	}

	public void setGeoLevel(String geoLevel) {
		this.geoLevel = geoLevel;
	}

	public List<HeaderDataDTO> getListHeaderData() {
		return listHeaderData;
	}

	public void setListHeaderData(List<HeaderDataDTO> listHeaderData) {
		this.listHeaderData = listHeaderData;
	}

	public List<String> getListRowData() {
		return listRowData;
	}

	public void setListRowData(List<String> listRowData) {
		this.listRowData = listRowData;
	}
}
