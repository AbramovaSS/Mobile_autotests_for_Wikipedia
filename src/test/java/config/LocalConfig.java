package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})

public interface LocalConfig extends Config {
    @Key("device")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("localServerUrl")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String getServerUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}