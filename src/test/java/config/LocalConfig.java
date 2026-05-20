package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})

public interface LocalConfig extends Config {
    @Key("device")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("localServerUrl")
    String getServerUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}