package tma.com.dto;

import java.util.List;

public class ResponseBodyDTO {

	private String submitAction;
	private String dataSourceName;
	private int year;
	private List<IndexDTO> listIndex;
	private String satisticType;
	private boolean percentage;
	private String fileName;
	private List<SheetDataDTO> listSheetData;
	private String s3KeyName;
	
	public ResponseBodyDTO() {}

	public ResponseBodyDTO(String submitAction, String dataSourceName, int year, List<IndexDTO> listIndex,
			String satisticType, boolean percentage, String fileName, List<SheetDataDTO> listSheetData,
			String s3KeyName) {
		super();
		this.submitAction = submitAction;
		this.dataSourceName = dataSourceName;
		this.year = year;
		this.listIndex = listIndex;
		this.satisticType = satisticType;
		this.percentage = percentage;
		this.fileName = fileName;
		this.listSheetData = listSheetData;
		this.s3KeyName = s3KeyName;
	}

	public String getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(String submitAction) {
		this.submitAction = submitAction;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<IndexDTO> getListIndex() {
		return listIndex;
	}

	public void setListIndex(List<IndexDTO> listIndex) {
		this.listIndex = listIndex;
	}

	public String getSatisticType() {
		return satisticType;
	}

	public void setSatisticType(String satisticType) {
		this.satisticType = satisticType;
	}

	public boolean isPercentage() {
		return percentage;
	}

	public void setPercentage(boolean percentage) {
		this.percentage = percentage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<SheetDataDTO> getListSheetData() {
		return listSheetData;
	}

	public void setListSheetData(List<SheetDataDTO> listSheetData) {
		this.listSheetData = listSheetData;
	}

	public String getS3KeyName() {
		return s3KeyName;
	}

	public void setS3KeyName(String s3KeyName) {
		this.s3KeyName = s3KeyName;
	}
}
