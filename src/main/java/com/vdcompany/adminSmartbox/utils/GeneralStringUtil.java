package com.vdcompany.adminSmartbox.utils;


import java.net.URLEncoder;
import java.util.*;

public class GeneralStringUtil {
    private static final String FOLDER_SEPARATOR = "/";
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    private static final String TOP_PATH = "..";
    private static final String CURRENT_PATH = ".";

    public GeneralStringUtil() {
    }
    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }
    public static boolean isNotNull(String s) {
        return s != null && !"".equals(s);
    }

    public static boolean isNull(String s) {
        return !isNotNull(s);
    }

    public static String mapToString(Map map) {
        try {
            if (map != null && map.size() != 0) {
                StringBuffer result = new StringBuffer();
                String temp = null;
                Object[] keys = map.keySet().toArray();

                for(int i = 0; i < keys.length; ++i) {
                    temp = String.valueOf(map.get(keys[i]));
                    result.append(keys[i]).append("=").append(temp).append("&");
                }

                result.delete(result.length() - 1, result.length());
                return result.toString();
            } else {
                return "";
            }
        } catch (Exception var5) {
            return "";
        }
    }

    public static Map<String, String> stringToMap(String str) {
        Map<String, String> map = new HashMap();
        if (isNull(str)) {
            return map;
        } else {
            String[] colum = str.split("&");

            for(int i = 0; i < colum.length; ++i) {
                int idx = colum[i].indexOf("=");
                int len = colum[i].length();
                if (idx < 0) {
                    break;
                }

                String key = colum[i].substring(0, idx);
                String val = colum[i].substring(idx + 1, len);
                map.put(isNotNull(key) ? key.trim() : "temp", isNotNull(val) ? val.trim() : null);
            }

            return map;
        }
    }

    public static String mapToString(Map<String, String> map, String nvSeparator, String groupSeparator) throws Exception {
        StringBuffer result = new StringBuffer();
        String temp = null;
        if (map != null && map.size() != 0 && !isNull(nvSeparator) && !isNull(groupSeparator)) {
            try {
                Object[] var8;
                int var7 = (var8 = map.keySet().toArray()).length;

                for(int var6 = 0; var6 < var7; ++var6) {
                    Object key = var8[var6];
                    temp = String.valueOf(nullReplace((String)map.get(key), ""));
                    result.append(key).append(nvSeparator).append(temp).append(groupSeparator);
                }

                result.delete(result.length() - 1, result.length());
                return result.toString();
            } catch (Exception var9) {
                throw new Exception("Map to String convert Exception");
            }
        } else {
            throw new Exception("Confirm parameter");
        }
    }

    public static Map<String, String> stringToMap(String str, String nvSeparator, String groupSeparator) throws Exception {
        Map<String, String> resultMap = new LinkedHashMap();
        if (!isNull(str) && !isNull(nvSeparator) && !isNull(groupSeparator)) {
            try {
                String[] colums = str.split(groupSeparator);
                String[] var8 = colums;
                int var7 = colums.length;

                for(int var6 = 0; var6 < var7; ++var6) {
                    String col = var8[var6];
                    int idx = col.indexOf(nvSeparator);
                    int len = col.length();
                    if (len < 0) {
                        break;
                    }

                    String key = col.substring(0, idx).trim();
                    String value = col.substring(idx + 1).trim();
                    resultMap.put((String)defaultIfEmpty(key, "temp"), (String)defaultIfEmpty(value, (CharSequence)null));
                }

                return resultMap;
            } catch (Exception var13) {
                throw new Exception("String to Map convert Exception");
            }
        } else {
            throw new Exception("Confirm parameter");
        }
    }

    public static String nullReplace(String mainStr, String changeStr) {
        return isNull(mainStr) ? changeStr : mainStr;
    }

    public static String nullReplace(Object mainStr, String changeStr) {
        return mainStr == null ? changeStr : mainStr.toString();
    }

    public static String mapToHTTPString(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            Object[] keys = map.keySet().toArray();
            StringBuffer strbuf = new StringBuffer();
            String value = null;

            for(int count = 0; count < keys.length; ++count) {
                value = map.get(keys[count]) == null ? "" : (String)map.get(keys[count]);
                strbuf.append(keys[count]).append("=").append(value).append("&");
            }

            strbuf.delete(strbuf.length() - 1, strbuf.length());
            return strbuf.toString();
        } else {
            return null;
        }
    }

    /** @deprecated */
    public static String HTTPStringToMap(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            Object[] keys = map.keySet().toArray();
            StringBuffer strbuf = new StringBuffer();
            String value = null;

            for(int count = 0; count < keys.length; ++count) {
                value = map.get(keys[count]) == null ? "" : (String)map.get(keys[count]);
                strbuf.append(keys[count]).append("=").append(value).append("&");
            }

            strbuf.delete(strbuf.length() - 1, strbuf.length());
            return strbuf.toString();
        } else {
            return null;
        }
    }

    public static String upperCase(String str) {
        return str == null ? null : str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        return str == null ? null : str.toUpperCase(locale);
    }

    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        return str == null ? null : str.toLowerCase(locale);
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    private static boolean regionMatches(CharSequence cs, boolean ignoreCase, int thisStart, CharSequence substring, int start, int length) {
        return cs instanceof String && substring instanceof String ? ((String)cs).regionMatches(ignoreCase, thisStart, (String)substring, start, length) : cs.toString().regionMatches(ignoreCase, thisStart, substring.toString(), start, length);
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        } else if (cs1 != null && cs2 != null) {
            return cs1 instanceof String && cs2 instanceof String ? cs1.equals(cs2) : regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
        } else {
            return false;
        }
    }

    public static boolean andEquals(CharSequence cs1, CharSequence... cs2) {
        boolean isAndEquals = false;
        CharSequence[] var6 = cs2;
        int var5 = cs2.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            CharSequence csn = var6[var4];
            isAndEquals = equals(cs1, csn);
            if (!isAndEquals) {
                break;
            }
        }

        return isAndEquals;
    }

    public static boolean orEquals(CharSequence cs1, CharSequence... cs2) {
        boolean orEquals = false;
        CharSequence[] var6 = cs2;
        int var5 = cs2.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            CharSequence csn = var6[var4];
            orEquals = equals(cs1, csn);
            if (orEquals) {
                break;
            }
        }

        return orEquals;
    }

    public static <T extends CharSequence> T defaultIfBlank(T str, T defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    public static String masking(String originString, int startIndex, int maskingCount, String masking) throws Exception {
        if (!isNull(originString) && !isNull(masking)) {
            int length = originString.length();
            if (maskingCount <= 0) {
                maskingCount = 1;
            }

            String[] strArray = stringToArray(originString);
            if (startIndex < 0) {
                startIndex += length;
            } else {
                --startIndex;
            }

            int count = 0;
            String changeString = "";

            for(int i = 0; i < strArray.length; ++i) {
                if (i >= startIndex && count < maskingCount) {
                    changeString = changeString + masking;
                    ++count;
                } else {
                    changeString = changeString + strArray[i];
                }
            }

            return changeString;
        } else {
            throw new Exception("parameter is null.");
        }
    }

    public static String urlEncode(String source, String enc) {
        try {
            return URLEncoder.encode(source, enc);
        } catch (Exception var3) {
            var3.printStackTrace();
            return "";
        }
    }

    public static String replace(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        if (!isEmpty(text) && !isEmpty(searchString) && replacement != null && max != 0) {
            int start = 0;
            int end = text.indexOf(searchString, start);
            if (end == -1) {
                return text;
            } else {
                int replLength = searchString.length();
                int increase = replacement.length() - replLength;
                increase = increase < 0 ? 0 : increase;
                increase *= max < 0 ? 16 : (max > 64 ? 64 : max);

                StringBuilder buf;
                for(buf = new StringBuilder(text.length() + increase); end != -1; end = text.indexOf(searchString, start)) {
                    buf.append(text.substring(start, end)).append(replacement);
                    start = end + replLength;
                    --max;
                    if (max == 0) {
                        break;
                    }
                }

                buf.append(text.substring(start));
                return buf.toString();
            }
        } else {
            return text;
        }
    }

    public static String replaceOnce(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, 1);
    }

    public static String cleanPath(String path) {
        if (path == null) {
            return null;
        } else {
            String pathToUse = replace(path, "\\", "/", -1);
            int prefixIndex = pathToUse.indexOf(":");
            String prefix = "";
            if (prefixIndex != -1) {
                prefix = pathToUse.substring(0, prefixIndex + 1);
                if (prefix.contains("/")) {
                    prefix = "";
                } else {
                    pathToUse = pathToUse.substring(prefixIndex + 1);
                }
            }

            if (pathToUse.startsWith("/")) {
                prefix = prefix + "/";
                pathToUse = pathToUse.substring(1);
            }

            String[] pathArray = pathToUse.split("/");
            List<String> pathElements = new LinkedList();
            int tops = 0;

            int i;
            for(i = pathArray.length - 1; i >= 0; --i) {
                String element = pathArray[i];
                if (!".".equals(element)) {
                    if ("..".equals(element)) {
                        ++tops;
                    } else if (tops > 0) {
                        --tops;
                    } else {
                        pathElements.add(0, element);
                    }
                }
            }

            for(i = 0; i < tops; ++i) {
                pathElements.add(0, "..");
            }

            return prefix + collectionToDelimitedString(pathElements, "/", "", "");
        }
    }

    public static String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix) {
        if (coll != null && !coll.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = coll.iterator();

            while(it.hasNext()) {
                sb.append(prefix).append(it.next()).append(suffix);
                if (it.hasNext()) {
                    sb.append(delim);
                }
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    public static String[] stringToArray(String str) {
        String[] arr = new String[str.length()];

        for(int i = 0; i < str.length(); ++i) {
            arr[i] = String.valueOf(str.charAt(i));
        }

        return arr;
    }

    public static String capitalize(String str) {
        if (isNull(str)) {
            return str;
        } else {
            char firstChar = str.charAt(0);
            return Character.isTitleCase(firstChar) ? str : (new StringBuilder(str.length())).append(Character.toTitleCase(firstChar)).append(str.substring(1)).toString();
        }
    }

    public static String uncapitalize(String str) {
        if (isNull(str)) {
            return str;
        } else {
            char firstChar = str.charAt(0);
            return Character.isLowerCase(firstChar) ? str : (new StringBuilder(str.length())).append(Character.toLowerCase(firstChar)).append(str.substring(1)).toString();
        }
    }

    public static String escapeSql(String str) {
        return str == null ? null : str.replace("'", "''");
    }

    public static boolean isArrayEquals(String[] strarr, String search) {
        boolean isContain = false;
        if (strarr != null) {
            String[] var6 = strarr;
            int var5 = strarr.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                String str = var6[var4];
                if (equals(search, str)) {
                    isContain = true;
                    break;
                }
            }
        }

        return isContain;
    }

    public static boolean isArrayEquals(List<String> strarr, String search) {
        boolean isContain = false;
        if (strarr != null) {
            Iterator var4 = strarr.iterator();

            while(var4.hasNext()) {
                String str = (String)var4.next();
                if (equals(search, str)) {
                    isContain = true;
                    break;
                }
            }
        }

        return isContain;
    }

    public static int countMatches(String str, String sub) {
        if (!isEmpty(str) && !isEmpty(sub)) {
            int count = 0;

            for(int idx = 0; (idx = str.indexOf(sub, idx)) != -1; idx += sub.length()) {
                ++count;
            }

            return count;
        } else {
            return 0;
        }
    }

    public static String toStr(Object in) {
        return in == null ? null : String.valueOf(in);
    }

    public static int toInt(Object in) {
        if (in == null) {
            return 0;
        } else {
            try {
                return Integer.parseInt(toStr(in));
            } catch (NumberFormatException var2) {
                return 0;
            }
        }
    }

    public static long toLong(Object in) {
        if (in == null) {
            return 0L;
        } else {
            try {
                return Long.parseLong(toStr(in));
            } catch (NumberFormatException var2) {
                return 0L;
            }
        }
    }

    public static boolean toBoolean(String boolStr) {
        if (boolStr == null||boolStr.equals("")) {
            return false;
        } else {
            return boolStr.toUpperCase().equals("TRUE") || boolStr.toUpperCase().equals("Y");
        }
    }

}
