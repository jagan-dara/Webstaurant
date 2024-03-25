gebconfig
/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/


import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.regex.Matcher


import java.time.Duration

// Use different browser and driver per thread
cacheDriverPerThread = true

// If set to `false` screenshots will be created for each test
reportOnTestFailureOnly = true

reportsDir = 'build/geb-spock-reports'
WebDriverManager.chromedriver().setup()
driver = "chrome"
