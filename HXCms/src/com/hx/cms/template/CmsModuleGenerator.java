package com.hx.cms.template;


public class CmsModuleGenerator {
	private static String packName = "com.hx.cms.template";
	private static String fileName = "hx.properties";

	public static void main(String[] args) {
		new ModuleGenerator(packName, fileName).generate();
	}
}
