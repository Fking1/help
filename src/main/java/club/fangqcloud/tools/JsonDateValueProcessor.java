package club.fangqcloud.tools;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format ="yyyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor() {
        super();
    }

    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object paramObject,
                                    JsonConfig paramJsonConfig) {
        return process(paramObject);
    }

    @Override
    public Object processObjectValue(String paramString, Object paramObject,
                                     JsonConfig paramJsonConfig) {
        return process(paramObject);
    }


    private Object process(Object value){
        if(value instanceof Timestamp){
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}
