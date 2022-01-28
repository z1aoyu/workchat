package com.b1aoyu.wechat.isv.utils;

import java.io.Writer;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * @author z1aoyu 2021-12-31
 *         xml/document 对象转换工具
 *
 *         支持String类型的xml文本转换为Document/JsonObject
 *         支持Document转换为JsonObject
 **/
public class XmlTool {

    private static final String DEFAULT_XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

    private XmlTool() {
    }

    /**
     * String转Document对象
     * 可以通过Document构建自己想要的String字符  例：
     * String testStr = document.getElementsByTagName("testStr").item(0).getTextContent();
     * getElementsByTagName获取的tag指的是XML中的tag标签的值
     */
    private static Document strToDocument(String xml) throws DocumentException {
        return DocumentHelper.parseText(xml);
    }

    /**
     * xml 转 JSONObject
     * xml转换为糊涂工具类中封装的json对象（具体内容封装为阿里的fastJson）
     */
    public static JSONObject documentToJSONObject(String xml) {
        JSONObject jsonObject = null;
        try {
            jsonObject = elementToJSONObject(strToDocument(xml).getRootElement());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * Element 转 JSONObject
     * Element转换为糊涂工具类中封装的json对象（具体内容封装为阿里的fastJson）
     */
    public static JSONObject elementToJSONObject(Element node) {
        JSONObject result = new JSONObject();
        // 当前节点的名称、文本内容和属性
        List<Attribute> listAttr = node.attributes();// 当前节点的所有属性的list
        for (Attribute attr : listAttr) {// 遍历当前节点的所有属性
            result.put(attr.getName(), attr.getValue());
        }
        // 递归遍历当前节点所有的子节点
        List<Element> listElement = node.elements();// 所有一级子节点的list
        if (!listElement.isEmpty()) {
            for (Element e : listElement) {// 遍历所有一级子节点
                if (e.attributes().isEmpty() && e.elements().isEmpty()) // 判断一级节点是否有属性和子节点
                {
                    result.set(e.getName(), e.getTextTrim());// 沒有则将当前节点作为上级节点的属性对待
                } else {
                    if (!result.containsKey(e.getName())) // 判断父节点是否存在该一级节点名称的属性
                    {
                        result.set(e.getName(), new JSONArray());// 没有则创建
                    }
                    ((JSONArray) result.get(e.getName())).add(elementToJSONObject(e));// 将该一级节点放入该节点名称的属性对应的值中
                }
            }
        }
        return result;
    }

    /**
     * 创建XStream
     */
    private static XStream createXstream() {
        XStream xstream = new XStream(new MyXppDriver(false));
        xstream.autodetectAnnotations(true);
        return xstream;
    }

    /**
     * 支持注解转化XML
     */
    public static String toXML(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        XStream xstream = createXstream();
        xstream.processAnnotations(cls);
        return DEFAULT_XML_HEADER + xstream.toXML(obj);
    }

    /**
     * Object 转化 XML
     */
    public static String toXML(Object obj) {
        if (obj == null) {
            return null;
        }
        XStream xstream = createXstream();
        return DEFAULT_XML_HEADER + xstream.toXML(obj);
    }

    /**
     * XML转化为JAVA对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T xml2Obj(String xml, Class<?> cls) {
        if (StringUtils.isBlank(xml)) {
            return null;
        }
        XStream xstream = createXstream();
        if (cls != null) {
            xstream.processAnnotations(cls);
        }
        return (T) xstream.fromXML(xml);
    }

    /**
     * XML转化为JAVA对象
     */
    public static <T> T xml2Obj(String xml) {
        return xml2Obj(xml, null);
    }

    public static class MyXppDriver extends XppDriver {

        boolean useCDATA = false;

        MyXppDriver(boolean useCDATA) {
            super(new XmlFriendlyNameCoder("__", "_"));
            this.useCDATA = useCDATA;
        }

        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            if (!useCDATA) {
                return super.createWriter(out);
            }
            return new PrettyPrintWriter(out) {
                static final boolean DATA = true;

                @Override
                public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (DATA) {
                        writer.write(cDATA(text));
                    } else {
                        writer.write(text);
                    }
                }

                private String cDATA(String text) {
                    return "<![CDATA[" + text + "]]>";
                }
            };
        }

    }

}
