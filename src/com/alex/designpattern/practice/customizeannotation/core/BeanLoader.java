package com.alex.designpattern.practice.customizeannotation.core;

import com.alex.designpattern.practice.customizeannotation.annotation.Component;
import com.alex.designpattern.practice.customizeannotation.annotation.Prototype;
import com.alex.designpattern.util.ConfigUtil;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean加载器
 */
public class BeanLoader {
	private volatile static BeanLoader Instance = null;

	private Map<Class<?>, Object> beanMap = new HashMap<>();
	private Map<String, Class<?>> beanIdMap = new HashMap<>();

	private String basePackage = null;

	private BeanLoader(){
		basePackage = ConfigUtil.getProperty("bean-config.properties", "base-package");
		scanPackage();
	}

	public static BeanLoader getInstance(){
		if (Instance == null){
			synchronized (BeanLoader.class){
				if (Instance == null){
					Instance = new BeanLoader();
				}
			}
		}
		return Instance;
	}

	/**
	 * 扫描basePackage下的类
	 */
	private void scanPackage(){
		try {
			if (basePackage == null || basePackage.length() == 0) {
				throw new Exception("包名为空");
			}
			// 获取classpath路径下的resource下的包
			URL url = Thread.currentThread().getContextClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
			String classDirPath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
			File classDir = new File(classDirPath);    // 包路径，包对应的文件夹
			String[] classes = classDir.list();
			for (String s : classes) {
				String className = s.split("\\.")[0];
				String classFullName = basePackage + "." + className;
				Class<?> beanClass = Class.forName(classFullName);
				Component component = beanClass.getAnnotation(Component.class);
				if(component != null){
					// 存在component注解
					String beanId = component.value();
					beanIdMap.put(beanId, beanClass);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 加载Bean实例，单例或原型
	 * @param beanClass
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<?> beanClass){
		try {
			Annotation prototype = beanClass.getAnnotation(Prototype.class);
			if (prototype != null){
				return (T) beanClass.getDeclaredConstructor().newInstance();
			}

			T bean = (T)beanMap.get(beanClass);
			if (bean == null){
				Object obj = beanClass.getDeclaredConstructor().newInstance();
				beanMap.put(beanClass, obj);
				bean = (T)obj;
			}
			return bean;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据beanId加载实例
	 * @param beanId
	 * @param <T>
	 * @return
	 */
	public <T> T getBean(String beanId){
		Class<?> beanClass = beanIdMap.get(beanId);
		if(beanClass == null){
			return null;
		}
		T bean = getBean(beanClass);
		return bean;
	}
}
