package be.seeseemelk.mealplanner.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FlywayService
{
	/*@ConfigProperty(name = "quarkus.datasource.reactive.url")
	String datasourceUrl;

	@ConfigProperty(name = "quarkus.datasource.username")
	String datasourceUsername;

	@ConfigProperty(name = "quarkus.datasource.password")
	String datasourcePassword;

	public void runFlywayMigrations(@Observes StartupEvent event)
	{
		Flyway flyway = Flyway.configure()
			.dataSource(getDatasourceUrl(), datasourceUsername, datasourcePassword)
			.validateMigrationNaming(true)
			.load();
		flyway.migrate();
	}

	public String getDatasourceUrl()
	{
		if (datasourceUrl.startsWith("vertx-reactive:"))
			return "jdbc:" + datasourceUrl.substring("vertx-reactive:".length());
		else
			return "jdbc:" + datasourceUrl;
	}*/
}
