package spring.root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

public class RootConfig{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public TilesConfigurer tilesConfigurer() {
		System.out.println("@@@ rootconfig @@@");
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
		return tiles;
	}
}
