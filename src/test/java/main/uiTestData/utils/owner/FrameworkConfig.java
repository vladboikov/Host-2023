package main.uiTestData.utils.owner;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(value = "file:/${user.dir}/src/test/resources/config/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    @DefaultValue("CHROME")
    String browser();

    @DefaultValue("https://pp86.hostco.ru/")
    String url();

    @DefaultValue("10")
    long timeout();

    @Key("username")
    String username();
    @Key("password")
    String password();

}
