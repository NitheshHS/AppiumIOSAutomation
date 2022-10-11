package FileUtility;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import reportUtil.ExtentReportManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonUtility {

    public JSONObject jsonObject;
    public JsonUtility loadJsonFile(){
        try {
            jsonObject = (JSONObject) new JSONParser()
                    .parse(new FileReader("./src/test/java/resources/TestData.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public String getJSONValue(String module, String data) throws Exception {
        ExtentReportManager.info("Module name: "+module+" data: "+data);
        String value = "";
        if(jsonObject!=null) {
            JSONObject object = (JSONObject) jsonObject.get(module);
            value = (String)object.get(data);
        }else{
            throw new Exception("Json object is null");
        }
        return value;
    }

}
