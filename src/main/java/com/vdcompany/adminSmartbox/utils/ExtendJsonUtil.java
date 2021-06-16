package com.vdcompany.adminSmartbox.utils;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Namgyu Park
 * @since 2020.11.20
 * @version 1.0
 */
public class ExtendJsonUtil{
	private static Logger logger = LoggerFactory.getLogger(ExtendJsonUtil.class);
	
	private static GsonBuilder getGsonDefault() {
		return new GsonBuilder()
			//.setPrettyPrinting()
			.registerTypeAdapter(AtomicInteger.class, new AtomicIntegerSerializer())
			.registerTypeAdapter(AtomicBoolean.class, new AtomicBooleanSerializer())
			.registerTypeAdapter(AtomicLong.class, new AtomicLongSerializer())
			.registerTypeAdapter(LinkedHashMap.class, new MapDeserializerDoubleAsIntFix())
			.excludeFieldsWithoutExposeAnnotation().serializeNulls();
		
	}
	
	/**
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		String jsonString = null;
		
		try {
			Gson gson = getGsonDefault().create();
			jsonString = gson.toJson(object);
		} catch(Exception e) {
			logger.error("create Json string fail - " + e.getClass().getSimpleName(), e);
			throw e;
		}
		
		return jsonString;
	}
	
	
	/**
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(String json) {
		Map<String, Object> result = null;

		try {
			Gson gson = getGsonDefault().create();
			result = gson.fromJson(json, new TypeToken<LinkedHashMap<String, Object>>(){}.getType());
		} catch (NullPointerException e) {
			logger.error("parameter is null.");
			throw e;
		} catch(JsonSyntaxException e) {
			logger.error("Json Parse fail");
			throw e;
		} catch(IllegalStateException e) {
			logger.error("Json structure is array. do use toList method");
			throw e;
		}
		
		return result;
		
	}
	
	
	
	private static class AtomicIntegerSerializer implements JsonSerializer<AtomicInteger> {

		@Override
		public JsonElement serialize(AtomicInteger src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.get());
			
		}
		
	}
	
	private static class AtomicBooleanSerializer implements JsonSerializer<AtomicBoolean> {

		@Override
		public JsonElement serialize(AtomicBoolean src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.get());
			
		}
		
	}
	
	private static class AtomicLongSerializer implements JsonSerializer<AtomicLong> {

		@Override
		public JsonElement serialize(AtomicLong src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.get());
			
		}
		
	}
	
	
	
	public static class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
	    @Override  @SuppressWarnings("unchecked")
	    public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
	    	return (Map<String, Object>) read(json);
	    }

	    public Object read(JsonElement in) {
	        if(in.isJsonArray()){
	            List<Object> list = new ArrayList<Object>();
	            JsonArray arr = in.getAsJsonArray();
	            for (JsonElement anArr : arr) {
	                list.add(read(anArr));
	            }
	            return list;
	        }else if(in.isJsonObject()){
	            Map<String, Object> map = new LinkedTreeMap<String, Object>();
	            JsonObject obj = in.getAsJsonObject();
	            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
	            for(Map.Entry<String, JsonElement> entry: entitySet){
	                map.put(entry.getKey(), read(entry.getValue()));
	            }
	            return map;
	        }else if( in.isJsonPrimitive()){
	            JsonPrimitive prim = in.getAsJsonPrimitive();
	            if(prim.isBoolean()){
	                return prim.getAsBoolean();
	            }else if(prim.isString()){
	                return prim.getAsString();
	            }else if(prim.isNumber()){
	                Number num = prim.getAsNumber();
	                // here you can handle double int/long values
	                // and return any type you want
	                // this solution will transform 3.0 float to long values
	                if(Math.ceil(num.doubleValue()) == num.longValue())
	                   return num.longValue();
	                else{
	                    return num.doubleValue();
	                }
	            }
	        }
	        return null;
	    }
	}
	
	
}
