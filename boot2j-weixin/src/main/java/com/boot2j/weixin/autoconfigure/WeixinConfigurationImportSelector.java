/**
 * 
 */
package com.boot2j.weixin.autoconfigure;

import java.util.List;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class WeixinConfigurationImportSelector implements
		DeferredImportSelector, BeanClassLoaderAware {

	private ClassLoader classLoader;

	/**
	 * @see com.boot2j.weixin.EnableWeixin
	 * @see org.springframework.context.annotation.ImportSelector#selectImports(org.springframework.core.type.AnnotationMetadata)
	 */
	@Override
	public String[] selectImports(AnnotationMetadata metadata) {

		List<String> configurations = loadFactoryNames();
		return configurations.toArray(new String[configurations.size()]);
	}

	protected List<String> loadFactoryNames() {
		return SpringFactoriesLoader.loadFactoryNames(
				WeixinConfiguration.class, this.classLoader);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

}
