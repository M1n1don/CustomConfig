# CustomConfig
コンフィグを生成しやすくする為に作ったutilです。


## コンフィグの作成  
```java

public static CustomConfig config;

@Override
public void onEnable()
{
    config = new CustomConfig(this); 
    config.saveDefault();
}

public static CustomConfig getCustomConfig()
{
    return config;
}
```  
※ resourcesにconfig.ymlを作成してください。  
  config.yml内に記述したものはそのままplugins/<Plugin>/config.ymlとして出力されます。

## 他コンフィグの作成（例）  
```java

public static CustomConfig message;

@Override
public void onEnable()
{
    message = new CustomConfig(this, "message.yml"); 
    message.saveDefault();
}

public static CustomConfig getCustomMessage()
{
    return message;
}
```  
