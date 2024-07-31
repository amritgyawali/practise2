//package com.amrit.blog.config;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import com.amrit.blog.security.CustomUserDetailService;
//import com.amrit.blog.security.JwtAuthenticationEntryPoint;
//import com.amrit.blog.security.JwtAuthenticationFilter;
//
//import java.nio.file.Paths;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.core.convert.support.DefaultConversionService;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.MutablePropertySources;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.cache.NullUserCache;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.context.support.StandardServletEnvironment;
//import org.springframework.web.filter.CorsFilter;
//
//@ContextConfiguration(classes = {SecurityConfig.class})
//@ExtendWith(SpringExtension.class)
//class SecurityConfigTest {
//    @MockBean
//    private CustomUserDetailService customUserDetailService;
//
//    @MockBean
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @MockBean
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Autowired
//    private SecurityConfig securityConfig;
//
//    /**
//     * Method under test: {@link SecurityConfig#securityFilterChain(HttpSecurity)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void SecurityFilterChain_Test() throws Exception {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface org.springframework.web.servlet.HandlerMapping
//        //   java.lang.IllegalStateException: Failed to load ApplicationContext
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'resourceHandlerMapping' defined in org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.util.Assert.state(Assert.java:76)
//        //       at org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.resourceHandlerMapping(WebMvcConfigurationSupport.java:591)
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange
//        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(null);
//
//        // Act
//        securityConfig.securityFilterChain(new HttpSecurity(null, authenticationBuilder, new HashMap<>()));
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#passwordEncoder()}
//     */
//    @Test
//    void PasswordEncoder_Test() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertTrue((new SecurityConfig()).passwordEncoder() instanceof BCryptPasswordEncoder);
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#passwordEncoder()}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void PasswordEncoder_Test2() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface org.springframework.web.servlet.HandlerMapping
//        //   java.lang.IllegalStateException: Failed to load ApplicationContext
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'resourceHandlerMapping' defined in org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.util.Assert.state(Assert.java:76)
//        //       at org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.resourceHandlerMapping(WebMvcConfigurationSupport.java:591)
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange and Act
//        securityConfig.passwordEncoder();
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#daoAuthenticationProvider()}
//     */
//    @Test
//    void DaoAuthenticationProvider_Test() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange and Act
//        DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new SecurityConfig())
//                .daoAuthenticationProvider();
//
//        // Assert
//        assertTrue(actualDaoAuthenticationProviderResult.getUserCache() instanceof NullUserCache);
//        assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
//        assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#daoAuthenticationProvider()}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void DaoAuthenticationProvider_Test2() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface org.springframework.web.servlet.HandlerMapping
//        //   java.lang.IllegalStateException: Failed to load ApplicationContext
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'resourceHandlerMapping' defined in org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.util.Assert.state(Assert.java:76)
//        //       at org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.resourceHandlerMapping(WebMvcConfigurationSupport.java:591)
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange and Act
//        securityConfig.daoAuthenticationProvider();
//    }
//
//    /**
//     * Method under test:
//     * {@link SecurityConfig#authenticationManagerBean(AuthenticationConfiguration)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void AuthenticationManagerBean_Test() throws Exception {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface org.springframework.web.servlet.HandlerMapping
//        //   java.lang.IllegalStateException: Failed to load ApplicationContext
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'resourceHandlerMapping' defined in org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.util.Assert.state(Assert.java:76)
//        //       at org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.resourceHandlerMapping(WebMvcConfigurationSupport.java:591)
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange and Act
//        securityConfig.authenticationManagerBean(new AuthenticationConfiguration());
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#coresFilter()}
//     */
//    @Test
//    void CoresFilter_Test() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange and Act
//        FilterRegistrationBean actualCoresFilterResult = (new SecurityConfig()).coresFilter();
//
//        // Assert
//        Collection<String> servletNames = actualCoresFilterResult.getServletNames();
//        assertTrue(servletNames instanceof Set);
//        Collection<ServletRegistrationBean<?>> servletRegistrationBeans = actualCoresFilterResult
//                .getServletRegistrationBeans();
//        assertTrue(servletRegistrationBeans instanceof Set);
//        Collection<String> urlPatterns = actualCoresFilterResult.getUrlPatterns();
//        assertTrue(urlPatterns instanceof Set);
//        Object filter = actualCoresFilterResult.getFilter();
//        Environment environment = ((CorsFilter) filter).getEnvironment();
//        assertTrue(((StandardServletEnvironment) environment).getConversionService() instanceof DefaultConversionService);
//        assertTrue(environment instanceof StandardServletEnvironment);
//        assertTrue(filter instanceof CorsFilter);
//        Map<String, Object> systemProperties = ((StandardServletEnvironment) environment).getSystemProperties();
//        assertEquals(73, systemProperties.size());
//        assertEquals("17", systemProperties.get("java.specification.version"));
//        Map<String, Object> systemEnvironment = ((StandardServletEnvironment) environment).getSystemEnvironment();
//        assertEquals(59, systemEnvironment.size());
//        assertEquals("6", systemEnvironment.get("PROCESSOR_LEVEL"));
//        assertEquals("AMRIT", systemEnvironment.get("USERDOMAIN_ROAMINGPROFILE"));
//        assertEquals("Console", systemEnvironment.get("SESSIONNAME"));
//        assertEquals("off", systemProperties.get("kotlinx.coroutines.debug"));
//        assertNull(((CorsFilter) filter).getFilterConfig());
//        assertEquals(-110, actualCoresFilterResult.getOrder());
//        assertEquals(0, environment.getActiveProfiles().length);
//        MutablePropertySources propertySources = ((StandardServletEnvironment) environment).getPropertySources();
//        assertEquals(4, propertySources.size());
//        assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
//        assertFalse(actualCoresFilterResult.isMatchAfter());
//        assertTrue(servletNames.isEmpty());
//        assertTrue(servletRegistrationBeans.isEmpty());
//        assertTrue(urlPatterns.isEmpty());
//        assertTrue(actualCoresFilterResult.getInitParameters().isEmpty());
//        assertTrue(actualCoresFilterResult.isAsyncSupported());
//        assertTrue(actualCoresFilterResult.isEnabled());
//        String expectedString = Paths
//                .get(System.getProperty("user.home"), "AppData", "Roaming", "JetBrains", "IdeaIC2024.1", "plugins",
//                        "diffblue-cover-ij", "META-INF", "cover-service-analyzer-2024.07.04.jar")
//                .toString();
//        assertEquals(expectedString, systemProperties.get("cover.jar.path"));
//        assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
//    }
//
//    /**
//     * Method under test: {@link SecurityConfig#coresFilter()}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void CoresFilter_Test2() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface org.springframework.web.servlet.HandlerMapping
//        //   java.lang.IllegalStateException: Failed to load ApplicationContext
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'resourceHandlerMapping' defined in org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerMapping]: Factory method 'resourceHandlerMapping' threw exception; nested exception is java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   java.lang.IllegalStateException: No ServletContext set
//        //       at org.springframework.util.Assert.state(Assert.java:76)
//        //       at org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.resourceHandlerMapping(WebMvcConfigurationSupport.java:591)
//        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.lambda$instantiate$2(ConstructorResolver.java:648)
//        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:647)
//        //       at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
//        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
//        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
//        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
//        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
//        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
//        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
//        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
//        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange and Act
//        securityConfig.coresFilter();
//    }
//}
