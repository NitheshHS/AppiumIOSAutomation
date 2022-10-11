package cap;

import FileUtility.JsonUtility;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityLib {
    private static CapabilityLib capabilityLib;
    private JsonUtility json;

    private CapabilityLib(){
        json = new JsonUtility();
        if(json!=null) {
            loadJsonFile();
        }else{
            throw new NullPointerException("Capability json file not loaded");
        }
    }

    public static CapabilityLib getInstance(){
        if(capabilityLib==null){
            capabilityLib = new CapabilityLib();
        }
        return capabilityLib;
    }

    @SneakyThrows
    public DesiredCapabilities getDeviceCapability(String deviceName)  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","/Users/Nithesha/Library/Developer/Xcode/DerivedData/UIKitCatalog-gccfiyrajnmwahghgvrvdlfabylh/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,json.getJSONValue(deviceName, "platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,json.getJSONValue(deviceName, "platformVersion"));
        capabilities.setCapability(MobileCapabilityType.UDID,json.getJSONValue(deviceName,"UDID"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,json.getJSONValue(deviceName,"deviceName"));
        return capabilities;
    }

    private void loadJsonFile(){
        json.loadJsonFile("./src/test/java/resources/Capability.json");
    }

}
