package th.fight.fit.mpybackoffice.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class JSONUtil {

	public static String transformVOToString(Object obj) {
		if(obj!=null) {
			Gson gsonObject = new Gson();
			return gsonObject.toJson(obj);
			
		}
		
		return null;

	}

	public static Object transformStringToVO(String jsonValue, Class<?> clazz) {
		if(StringUtils.isNotEmptyOrNull(jsonValue)) {
			Gson gsonObject = new Gson();
			return gsonObject.fromJson(jsonValue, clazz);
			
		}
		
		return null;
		
	}

}
