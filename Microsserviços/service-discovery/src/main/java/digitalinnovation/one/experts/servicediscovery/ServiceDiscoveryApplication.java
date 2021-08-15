package digitalinnovation.one.experts.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
Nesta classe usamos Service Discovery para descobrir dinamicamente a localização da rede (endereço IP e porta)
de outro serviço para se comunicar com ele.
Usamos tb o Eureka para adquirir informações sobre os serviços com os quais você deseja se comunicar
O Service Discovery se conectar com o Config Server e busca o arquivo de configuração (service-discovery)
no local: https://github.com/oswaldoneto/dio-experts-config/blob/master/service-discovery.yml que foi informado
no arquivo application.yml da classe config-server
* */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryApplication.class, args);
	}

}
