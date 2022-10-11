package cap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.Getter;

import java.io.File;
import java.net.URL;


public class AppiumDriverManager {

    private static AppiumDriverLocalService service;
    private static AppiumDriverManager manager;

    private AppiumDriverManager(){}

    public static AppiumDriverManager getInstance(){
        if(manager == null){
            manager = new AppiumDriverManager();
        }
        return manager;
    }
    private static void setUpServer(){
         service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withAppiumJS(new File("/opt/homebrew/bin/appium"))
                        .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                        .usingAnyFreePort());
    }

    public void startAppiumServer(){
        if(service==null){
            setUpServer();
            service.start();
        }
    }

    public void stopAppiumServer(){
        if(service.isRunning()){
            service.stop();
        }
    }

    public URL getUrl(){
        return service.getUrl();
    }


}
