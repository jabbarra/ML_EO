package ar.com.mleo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("ar.com.mleo.dao")
@SpringBootApplication
public class MleoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MleoApplication.class, args);
	}
}
