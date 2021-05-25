package com.programacion.config;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewCheck;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
public class InicializacionCdi {

	//public static final String ID = UUID.randomUUID().toString();

	//@Inject
	//@ConfigProperty(name = "configsource.consul.host", defaultValue = "127.0.0.1")
	//private String consulHost;

//	@Inject
	//@ConfigProperty(name = "app.name")
	//private String appname;

	//@Inject
	//@ConfigProperty(name = "quarkus.http.port", defaultValue = "9095")
	//private Integer appPort;

	public void init(@Observes @Initialized(ApplicationScoped.class) Object obj) throws Exception {
		//System.out.println("**********init");
		//ConsulClient cliente = new ConsulClient(consulHost);

		//NewService newService = new NewService();
		//newService.setId(ID);
		//newService.setName(appname);
		//newService.setPort(appPort);
		//newService.setAddress(InetAddress.getLocalHost().getHostAddress());
        
		//--------VERIFICACIÓN ESTADO DEL SERVIDOR
		//NewService.Check check = new NewService.Check();
		//check.setMethod("GET");
		//check.setHttp("http://"+consulHost+":"+appPort+"/health");
		//check.setInterval(5+"s");
		//check.setDeregisterCriticalServiceAfter(3+"s");
		//newService.setCheck(check);
		
		
		//----------------CONFIGURACIÓN GATEWAY ----
				//Traerfik toma la configuración de Consul , no es neecesario registrar
				//los servicios.
				//TGAs
				//RULE :traefik.http.roters.router_name.rule=PathPrefix('/mp-autor')
				//String rule=String.format("traefik.http.routers.%s.rule=PathPrefix(`/%s`)",appname,appname);
				//MIDDLEWARE
			    ///String middleware=String.format("traefik.http.middlewares.%s.stripprefix.prefixes=/%s",appname,appname);
			     //MIDS
				//String mids=String.format("traefik.http.routers.%s.middlewares=%s",appname,appname);
				
				//newService.setTags(Arrays.asList(rule,middleware,mids));
				//cliente.agentServiceRegister(newService);

	}

	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object obj) {

		//ConsulClient cliente = new ConsulClient("127.0.0.1");
		//System.out.println("**********destroy");
		//cliente.agentServiceDeregister(ID);

	}

}
