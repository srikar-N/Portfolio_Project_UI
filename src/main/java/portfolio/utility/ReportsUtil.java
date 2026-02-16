package portfolio.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsUtil {
	public static ExtentReports getExtentReportObject() {

		String path = System.getProperty("user.dir") + "/reports/report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Portfolio report");
		reporter.config().setReportName("UI Autoamtion results");

		ExtentReports reports = new ExtentReports();

		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "Pranav");

		return reports;

	}
}
