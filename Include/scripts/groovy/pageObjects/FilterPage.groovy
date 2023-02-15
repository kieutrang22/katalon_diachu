package pageObjects
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData

import utils.Companion.SortType


class FilterPage extends AbstractPage {


	def boolean hasNext() {
		def preTitle = getText(findTestObject('/search/txtTitleNews'))
		swipeVertically(0.7, 0.5)
		delay()
		def currentTitle = getText(findTestObject('/search/txtTitleNews'))
		return preTitle != currentTitle
	}


	def boolean checkFilter(HashMap<String, String> filterList) {
		boolean checkArea
		boolean checkPrice
		boolean checknumberOfBedRooms
		if (isVisible(findTestObject('/search/txtNoSearchResult'))) {
			assert true
			return
		}
		//Check number of bed rooms
		def numberOfBedRoomsTest = filterList.get("Số phòng ngủ").replace("+","")
		if(numberOfBedRoomsTest.contains("Tất cả")) {
			checknumberOfBedRooms = true
		} else {
			def objectNumberOfBedRoom = findTestObject('search/txtNumberOfBedRooms')
			if(!isVisible(objectNumberOfBedRoom)) {
				assert false
				return
			} else {
				def numberOfBedRoomsResult = getText(objectNumberOfBedRoom)
				numberOfBedRoomsResult = numberOfBedRoomsResult.replace("+","")
				checknumberOfBedRooms = Integer.parseInt(numberOfBedRoomsResult) >= Integer.parseInt(numberOfBedRoomsTest)
			}
		}

		//Check area
		def areaResult = Float.parseFloat(getText(findTestObject('Object Repository/search/txtArea')).replace("m2",""))
		def areaTest = filterList.get("Diện tích").replaceAll("m2| ","")
		if(areaTest.contains("Tất cả")) {
			checkArea = true
		} else if(areaTest.contains("<=")) {
			checkArea = areaResult <= Float.parseFloat(areaTest.replace("<=",""))
		} else if(areaTest.contains(">=")) {
			checkArea = areaResult >= Float.parseFloat(areaTest.replace(">=",""))
		} else if(areaTest.contains("-")){
			def minAreaTest = Integer.parseInt(areaTest.split("-")[0])
			def maxAreaTest = Integer.parseInt(areaTest.split("-")[1])
			checkArea = (areaResult <= maxAreaTest) & (areaResult >= minAreaTest)
		} else checkArea = true

		//Check price
		def priceResult = getText(findTestObject('Object Repository/search/txtPrice'))
		def priceTest = filterList.get("Mức giá")

		def priceConvertedTest = priceTest.replaceAll("tỉ|triệu| ","")
		def priceConvertedResult = Float.parseFloat(priceResult.replaceAll("tỉ|triệu| ",""))

		if(priceResult.contains("triệu")) {
			priceConvertedResult /= 1000
		}

		if(priceTest.contains("<=")) {
			checkPrice = priceConvertedResult <= convertPrice(priceTest.replace("<=",""))
		} else if(priceTest.contains(">=")) {
			checkPrice = priceConvertedResult >= convertPrice(priceTest.replace(">=",""))
		} else if(priceTest.contains("-")){
			def minPriceTest = convertPrice(priceTest.split("-")[0])
			def maxPriceTest = convertPrice(priceTest.split("-")[1])
			checkPrice = (priceConvertedResult <= maxPriceTest) & (priceConvertedResult >= minPriceTest)
		} else checkPrice = true

		def minpriceTest = Float.parseFloat(areaTest.split("-")[0])
		def maxpriceTest = Float.parseFloat(areaTest.split("-")[1])

		assert checkArea & checknumberOfBedRooms & checkPrice
	}

	def float convertPrice(String price) {
		def priceConverted = Float.parseFloat(price.replaceAll("triệu|tỉ|/tháng| ",""))
		if(price.contains("tỉ")) {
			priceConverted *= 1000
		}
		return priceConverted
	}


	public boolean checkSortByTime(SortType sortType) {
		def result = true
		while(true) {
			tap(findTestObject('/search/txtTitleNews'))
			def timeOfFirstPost = convertTimeSubmitted(getText(findTestObject('/news/txtDateSubmitted')))
			pressBack()

			if(!hasNext()) {
				return result
			}

			tap(findTestObject('/search/txtTitleNews'))
			def timeOfSecondPost = convertTimeSubmitted(getText(findTestObject('/news/txtDateSubmitted')))

			result = (sortType == SortType.OLDEST.value) ? timeOfFirstPost >= timeOfSecondPost
					:  timeOfFirstPost <= timeOfSecondPost
			if (!result) return result 

			pressBack()
			if(!hasNext()) {
				return result 
			}
			return result
		}
	}

	def int convertTimeSubmitted(String time) {
		def timeConverted = Integer.parseInt(time.replaceAll("Ngày đăng:| |trước|tháng|năm|ngày|giờ",""))
		if (time.contains("ngày")){
			timeConverted = timeConverted *24
		} else if (time.contains("tháng")) {
			timeConverted = timeConverted *24*30
		} else if (time.contains("năm")) timeConverted = timeConverted *24*30*365

		return timeConverted
	}

	def boolean checkSortByPrice() {
		def result = true
		while(true) {
			def priceFirstPost = convertPrice(getText(findTestObject('/search/txtPrice')))

			if(!hasNext()) {
				return result
			}

			def priceSecondPost = convertPrice(getText(findTestObject('/search/txtPrice')))

			result = priceFirstPost >= priceSecondPost
			if (!result)  {
				return result
			}
		}
	}


}