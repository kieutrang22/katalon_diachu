package utils

class Companion {

	public static final String ADMIN_ACCOUNT = "admin"

	public static final String ADMIN_PASSWORD = "123456"

	public static final String AGENT_ACCOUNT = "ktrang22"
	public static final String AGENT_PASSWORD = "123456"

	public static final int TIME_OUT = 10

	public static final int DELAY_TIME = 2

	public static final String DYNAMIC_TEXT_VIEW_XPATH = "(//android.widget.EditText)[last()]/..//android.widget.TextView"

	public enum Status {
		SUCCESSFUL("successful"),
		UNSUCCESSFUL("unsuccessful")

		private String value

		Status(String value) {
			this.value = value
		}
	}

	public enum HeaderBar {
		POTENTIAL_REAL_ESTATE("Nhà đất bán"),
		RENTAL_REAL_ESTATE("Nhà đất cho thuê"),
		PROJECT("Dự án"),
		INVESTMENT_OPPORTUNITY("Cơ hội đầu tư"),
		CONTACT("Danh bạ")

		private String value

		HeaderBar(String value) {
			this.value = value
		}
	}

	public enum CategoryTitle{
		RENTAL("CHO THUÊ"),
		POTENTIAL("MUA BÁN"),
		PROJECT("DỰ ÁN")
		private String value

		CategoryTitle(String value) {
			this.value = value
		}
	}
	
	public enum SortType{
		OLDEST("Cũ nhất"),
		LASTEST("Mới nhất"),
		HIGHEST_PRICE("Giá cao nhất")
		private String value

		SortType(String value) {
			this.value = value
		}
	}
}