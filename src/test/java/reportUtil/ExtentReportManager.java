package reportUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {
    static ExtentReports reports;
    static ExtentTest test;
    public static ExtentReports configureReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./ExtentReport.html");
        sparkReporter.config().setReportName("Automation");
        sparkReporter.config().setDocumentTitle("IOS automation");
        sparkReporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        return reports;
    }

    public static ExtentTest createTest(String testname){
        test=reports.createTest(testname).assignAuthor("Nithesh");
        return  test;
    }

    public static void info(String message){
        test.info(message);
    }

    public static void flushReport(){
        reports.flush();
    }

}
