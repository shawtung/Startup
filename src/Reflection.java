/**
 * Created by Shaw on 2015/10/19.
 */

import java.io.IOException;
import java.lang.reflect.*;
import java.rmi.AccessException;
import java.util.ArrayList;

public class Reflection {

	/**
	 *
	 *
	 * @param owner
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public Object getProperty(Object owner, String fieldName) throws Exception {
		Class ownerClass = owner.getClass();
		Field field  = ownerClass.getField(fieldName);
		Object property = field.get(owner);
		return property;
	}


	/**
	 *
	 *
	 * @param className
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public Object getStaticProperty(String className, String fieldName) throws Exception {
		Class ownerClass = Class.forName(className);
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(ownerClass);
		return property;
	}


	/**
	 *
	 * @param owner
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(owner, args);
	}







}
