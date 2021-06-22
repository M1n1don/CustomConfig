# CustomConfig
コンフィグを生成しやすくする為に作ったutilです。

BungeeCordプラグインで使いたい方は[こちら](https://github.com/M1n1don/CustomConfig-for-BungeeCord)をご覧ください。

## コンフィグの作成  
```java

private CustomConfig config;

@Override
public void onEnable()
{
    config = new CustomConfig(this); 
    config.saveDefault();
}

public CustomConfig getCustomConfig()
{
    return config;
}
```  
※ resourcesにconfig.ymlを作成してください。  
※ config.yml内に記述したものはそのまま`plugins/<Plugin>/config.yml`として出力されます。

## 他コンフィグの作成（例）  
```java

private CustomConfig message;

@Override
public void onEnable()
{
    message = new CustomConfig(this, "message.yml"); 
    message.saveDefault();
}

public CustomConfig getCustomMessage()
{
    return message;
}
```  
