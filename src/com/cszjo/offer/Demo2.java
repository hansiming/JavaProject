package com.cszjo.offer;

/**
 * Created by hansiming on 2017/9/14.
 */
public class Demo2 {

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {

        if (str == null || str.length() < 1) {
            return "";
        }

        return str.toString().replace(" ", "%20");
    }
}
