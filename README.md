# SpringCloudAlibaba
Spring Cloud Alibaba Study

## 其他人的笔记
[笔记](https://www.yuque.com/books/share/31d864d1-b6ff-4bd1-8569-2dec720e8306?#%20%E3%80%8Ajava%E7%AC%94%E8%AE%B0%E3%80%8B)

[仓库](https://gitee.com/lixiaogou/cloud2020)

<br/>

## 模块说明
> TODO

<br/>

## 联动的微服务模块
Eureka 集群：
- cloud-consumer-order7999
- cloud-eureka-server7001
- cloud-eureka-server7002
- cloud-provider-payment-8001
- cloud-provider-payment-8002
    
<br/><br/>  

OpenFeign-测试1-服务调用：
- cloud-consumer-order7996
- cloud-eureka-server7001
- cloud-eureka-server7002
- cloud-provider-payment-8001
- cloud-provider-payment-8002
        
<br/><br/>  

OpenFeign-测试2-hystrix 服务降级和熔断：
- cloud-eureka-server7001
- cloud-consumer-feign-hystrix-order-7995
- cloud-provider-hystrix-payment-8005
    
<br/><br/>  

Hystrix Dashboard 测试：
- cloud-eureka-server7001
- cloud-consumer-hystrix-dashboard-9001
- cloud-provider-hystrix-payment-8005
    
<br/><br/>
  
配置中心与服务总线：
- cloud-eureka-server7001
- cloud-config-center-3344
- cloud-config-client-3355
- cloud-config-client-3366
  
<br/><br/>

消息驱动：
- cloud-eureka-server7001
- cloud-stream-rabbitmq-provider-8006
- cloud-stream-rabbitmq-consumer-8007
- cloud-stream-rabbitmq-consumer-8008
  
<br/><br/>

链路追踪：
- cloud-eureka-server7001
- cloud-consumer-order7999
- cloud-provider-payment-8001
  
<br/><br/>

Nacos 服务注册：
- 本地 Nacos
- cloud-alibaba-provider-payment-9001
- cloud-alibaba-provider-payment-9002
- cloud-alibaba-consumer-order-9101
  
<br/><br/>

Nacos 单点配置中心：
- 本地 Nacos
- cloud-alibaba-config-nacos-client-3377
  
<br/><br/>

Nacos 单点服务降级熔断：
- 本地 Nacos
- 本地 sentinel
- cloud-alibaba-sentinel-service-3355
  
<br/><br/>

