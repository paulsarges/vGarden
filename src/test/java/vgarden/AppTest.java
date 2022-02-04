package vgarden;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vgarden.config.AppConfig;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
