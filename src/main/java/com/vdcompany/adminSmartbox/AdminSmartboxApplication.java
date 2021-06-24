package com.vdcompany.adminSmartbox;

import com.vdcompany.adminSmartbox.utils.LoggingLine;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdminSmartboxApplication extends SpringBootServletInitializer {
	@Getter@Setter
	private static String profile;
	@Getter@Setter
	private static String SERVER_IP;
	@Getter@Setter
	private static String SERVER_PROTOCOL;

	@Getter@Setter
	private static String imageCommonURL = "http://smartbox.vdcompany.co.kr/images/smartbox/goods/";
	// 실행 방법 메모
	// -Dspring.profiles.active : (prod : 상용 , local : local, dev : dev)
	// -Dserver.port            : 웹 서비스 포트 3만번대 사용, 매장별 프로세스에 따라 1씩 증가 예정
	// 매장 코드 args            : 고유 매장 코드 파라메터 입력
	// java -jar -Dspring.profiles.active=prod -Dserver.port=8888 ./adminSmartbox-x.x.x.war

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AdminSmartboxApplication.class);
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(AdminSmartboxApplication.class);
		SERVER_PROTOCOL = "http";
		if (args.length == 0) {
			SERVER_IP = "localhost";
		}else if (args.length == 1) {
			SERVER_IP = "localhost";
			if (!args[0].equals("")) {
				SERVER_IP = args[0];
			}
		}else{
			System.out.println("args : attach BOOTH_CODE ex)B0001");
			System.exit(1);
		}

		profile = System.getProperty("spring.profiles.active");
		if(profile == null) {
			System.setProperty("spring.profiles.active", "dev");
		}

		logger.info(LoggingLine.LOG_1DOTT_LINE);
		logger.info("profile:"+profile);
		logger.info("SERVER_IP:"+SERVER_IP);
		logger.info(LoggingLine.LOG_1DOTT_LINE);

		//System.setProperty("log.config.path", "/logs");
		ApplicationContext ctx = SpringApplication.run(AdminSmartboxApplication.class, args);
	}

}
