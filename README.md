# CustomConfig
ConfigConfingのutilです。

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

## 他コンフィグの作成（例）  
```java

public static CustomConfig message;

@Override
public void onEnable()
{
    message = new CustomConfig(this, message); 
    message.saveDefault();
}

public static CustomConfig getCustomMessage()
{
    return message;
}
```  
