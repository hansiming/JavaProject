package com.taoyuan.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @ClassName: XMLUtil
 * @Description: TODO XML工具类
 * @author: Han
 * @date: 2016-3-22 下午3:09:03
 */
public class XMLUtil {
	

	/**
	 * @Title: toEntity
	 * @Description: TODO 将XML文件转换为一个entity
	 * @param xmlPath
	 * @return
	 * @throws Exception
	 * @return: Object
	 */
	public static Object toEntity(String xmlPath) throws Exception{
		
		//初始化，将XML文件读入内存，生成Document
		Document _document = init(xmlPath);
		
		//获取根目录节点
		Element _rootEle = _document.getRootElement();
		String _rootName = "";
		
		if(_rootEle != null){
			
			//根目录节点名字
			_rootName = _rootEle.getName();
		}
		
		if(!_rootName.equals("Entity")){
			
			throw new Exception("请确认根节点名字是否为Entity");
		}
		
		List<Element> elements = _rootEle.elements();
		
		//在Entity节点中无子节点
		if(elements.size() == 0){
			
			return null;
		}
		
		return getEntity(elements.get(0));
	}

	/**
	 * 获取根据节点Element获取对应的Entity
	 * @param element
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("rawtypes")
	private static Object getEntity(Element element)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		
		//获取classPath
		String _classPath = element.attributeValue("classPath");
		
		//获取Class的字节码文件
		Class _clazz = Class.forName(_classPath);
		//根据字节码文件进行实例化
		Object _object = _clazz.newInstance();
		
		Field[] _fields = _clazz.getDeclaredFields();
		
		setMember(_object, element, _fields);
		
		return _object;
	}

	/**
	 * 设置成员变量
	 * @param object
	 * @param element
	 * @param fields 成员变量数组
	 */
	private static void setMember(Object object, Element element, Field[] fields) {
		
		//获取当前Element获得的子节点迭代器
		Iterator<Element> _elements = element.elementIterator();
		while(_elements.hasNext()){
			
			Element _childElement = _elements.next();
			
			
			//当前正在设置的成员变量
			Field _field = null;
			//获取变量类型
			String _type = _childElement.getName();
			
			//获取变量名
			String _name = _childElement.attributeValue("name");
			//获取变量值
			String _value = _childElement.getTextTrim();
			
			//找到当前正在设置的成员变量
			for(int i = 0;i < fields.length;i ++ ){
				
				if(fields[i].getName().equals(_name)){
					
					_field = fields[i];
					break;
				}
			}
			
			if(_field == null){
				
				throw new RuntimeException("没找到该成员变量" + _name);
			}
			
			//此时可以访问私有成员变量
			_field.setAccessible(true);
			
			if(!setBaseTypeMember(object, _field, _type, _value)){
				
				//当前成员变量不是基本类型,则为引用类型成员变量
				setReferenceTypeMember(_childElement, object,  _field);
			}
		}
	}

	/**
	 * 设置引用类型成员变量
	 * @param element
	 * @param object
	 * @param field
	 */
	private static void setReferenceTypeMember(Element element,Object object,  Field field) {
		
		try {
			Object _entity = getEntity(element);
			field.set(object, _entity);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	/**
	 * 设置基本类型成员变量
	 * @param object
	 * @param field
	 * @param type
	 * @param value
	 * @return
	 */
	private static boolean setBaseTypeMember(Object object, Field field,
			String type, String value) {
		
		try {
			if(type.equals("Int")){
				
				//int型成员变量
				field.setInt(object, Integer.parseInt(value));
			}else if(type.equals("Double")){

				//double型成员变量
				field.setDouble(object, Double.parseDouble(value));
			}else if(type.equals("Float")){

				//float型成员变量
				field.setFloat(object, Float.parseFloat(value));
			}else if(type.equals("Long")){

				//long型成员变量
				field.setLong(object, Long.parseLong(value));
			}else if(type.equals("Char")){

				//char型成员变量
				field.setChar(object, value.charAt(0));
			}else if(type.equals("String")){

				//string型成员变量
				field.set(object, value);
			}else{
				
				return false;
			}
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		return true;
	}

	/**
	 * @Title: init
	 * @Description: TODO 初始化，将XML读入内存
	 * @param xmlPath
	 * @return Document节点
	 * @throws FileNotFoundException
	 * @return: Document
	 */
	private static Document init(String xmlPath) throws FileNotFoundException {
		
		//获取XML文件路径.是根据当前classPath去寻找，例如文件a.xml是放在根目录下，则需要输入的路径便是a.xml
		//还有另外一种方法是通过class.getResource("/" + xmlPath)效果是一样的
		//关于java中的路径问题还是没有搞得很清楚，下来还需要多看
		String _filePath = XMLUtil.class.getClassLoader().getResource(xmlPath).getPath();
		
		File _file = new File(_filePath);
		
		//如果文件存在
		if(_file.exists()){
			
			//利用dom4j返回该XML的document
			SAXReader _reader = new SAXReader();
			
			try {
				
				Document _document = _reader.read(_file);
				
				return _document;
				
			} catch (DocumentException e) {
				
				e.printStackTrace();
			}
		}else{
			
			throw new FileNotFoundException("您输入的XML文件地址未查到");
		}
		
		return null;
	}
	
}
