package br.com.nttdata.teste3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTeste3Application {

	public static void main(String[] args) {
		SpringApplication.from(Teste3Application::main).with(TestTeste3Application.class).run(args);
	}

}
