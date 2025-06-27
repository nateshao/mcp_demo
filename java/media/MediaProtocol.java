import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class MediaProtocol {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static byte[] packCommand(String cmd, Map<String, Object> params) throws Exception {
        Map<String, Object> obj = new HashMap<>();
        obj.put("cmd", cmd);
        if (params != null) obj.put("params", params);
        return mapper.writeValueAsBytes(obj);
    }

    public static Command unpackCommand(byte[] data) throws Exception {
        Map map = mapper.readValue(data, Map.class);
        String cmd = (String) map.get("cmd");
        Map<String, Object> params = (Map<String, Object>) map.getOrDefault("params", new HashMap<>());
        return new Command(cmd, params);
    }

    public static class Command {
        public String cmd;
        public Map<String, Object> params;
        public Command(String cmd, Map<String, Object> params) {
            this.cmd = cmd;
            this.params = params;
        }
    }
} 