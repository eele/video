package a;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class A {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String path2 = Thread.currentThread().getContextClassLoader().getResource("\\").getPath();  
//		System.out.println("path2 = " + path2);  
		
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client dynamicClient = clientFactory.createClient("http://localhost:8088/service/uploadInfo?wsdl");
		dynamicClient.invoke("addVID", "aa");
	}

}
