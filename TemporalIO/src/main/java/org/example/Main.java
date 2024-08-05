package org.example;

import com.jayway.jsonpath.JsonPath;

public class Main {
    private static final String SAFE_STRING = "=^[.\\\\p{Alnum}\\\\p{Space}]{0,1024}$";
    public static void main(String[] args) {
        String test = "123";
        boolean flag = test.matches(SAFE_STRING);
        System.out.println();
//        JsonPath path = JsonPath.compile("$['windBear']");
//        System.out.println(path.getPath());
//        String json = """
//                {
//                    "windBear": 108.8,
//                    "dataTime": "2024-05-01T03:27:00",
//                    "value1": 0.019,
//                    "statusName": "安全",
//                    "temperature": 10.9,
//                    "humidity": 52,
//                    "pressure": 1010.2,
//                    "windSpeed": 0.3,
//                    "status": "NORMAL"
//                }
//                """;
//        Object value = path.read(json);
//        System.out.println(value);
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .configure(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
//                .configure(READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
//                .configure(REQUIRE_SETTERS_FOR_GETTERS, true)
//                .setTimeZone(TimeZone.getDefault());
//        JsonNode node = mapper.valueToTree(value);
//        System.out.println(node);
//
//        LocalDateTime localDateTime = LocalDateTime.of(2024, 5,8,0,0,0,0);
//        System.out.println(localDateTime.toInstant(ZoneOffset.UTC).getEpochSecond());
    }
}
