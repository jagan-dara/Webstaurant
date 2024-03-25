package Common

//import Common.BaseUrlHolder
import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j

import static org.openqa.selenium.logging.LogType.BROWSER

//logging
//@Slf4j
class BaseSpec extends GebReportingSpec {

    def setupTest() {
    }

    def setup() {
        def ourNewUrl = "https://www.webstaurantstore.com/"
        browser.go(ourNewUrl)

//        initialBaseFECheck(packageName)

        setupTest()
    }

    void resetTheBrowser() {
        def driver = browser.driver
        driver.close()
        driver.quit()
    }


    def cleanupTest() {
        resetTheBrowser()
    }

    def final cleanup() {
        def logEntries = driver.manage().logs().get(BROWSER).all
        println "START  $BROWSER logs"
        logEntries.each {
            println(it)
        }
        println "END WebDriver $BROWSER logs"
        cleanupTest()
        // make this == null if you don't want to close the browser after each test without setting a sys prop
        if (System.properties['cacheBrowser'] != null) {
            //driver.quit()
            Iterator<String> iterator = driver.getWindowHandles().iterator();
            while (iterator.hasNext()) {
                driver.switchTo().window(iterator.next());
                browser.close()
                browser.quit()
            }

        }

        //  resetBrowser()  TODO:  Figure out why we put this here....
    }
}