package tma.com.dto;

import java.util.List;

public class SheetDataDTO {
	
	private String sheetName;
	private String geoLevel;
	private List<SheetDataDTO> listSheetDataDto;
	private List<String> listRowData;
	
	public SheetDataDTO() {}

	public SheetDataDTO(String sheetName, String geoLevel, List<SheetDataDTO> listSheetDataDto,
			List<String> listRowData) {
		super();
		this.sheetName = sheetName;
		this.geoLevel = geoLevel;
		this.listSheetDataDto = listSheetDataDto;
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

	public List<SheetDataDTO> getListSheetDataDto() {
		return listSheetDataDto;
	}

	public void setListSheetDataDto(List<SheetDataDTO> listSheetDataDto) {
		this.listSheetDataDto = listSheetDataDto;
	}

	public List<String> getListRowData() {
		return listRowData;
	}

	public void setListRowData(List<String> listRowData) {
		this.listRowData = listRowData;
	}
}
