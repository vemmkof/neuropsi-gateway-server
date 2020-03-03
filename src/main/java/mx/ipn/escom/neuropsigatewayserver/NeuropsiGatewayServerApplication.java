package mx.ipn.escom.neuropsigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "neuropsi-gateway-server")
public class NeuropsiGatewayServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NeuropsiGatewayServerApplication.class, args);
  }

}
