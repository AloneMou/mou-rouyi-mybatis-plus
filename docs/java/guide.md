```
mkdir -p /volumes/es7/logs
mkdir -p /volumes/es7/data
mkdir -p /volumes/es7/plugins/ik


docker pull elasticsearch:7.3.0

docker run -p 9200:9200 -p 9300:9300 -d  --restart=always \
-e "cluster.name=elasticsearch" \
-e "discovery.type=single-node" \
--log-driver json-file --log-opt max-size=100m \
-v /www/env/docker/es/ik:/usr/share/elasticsearch/plugins/ik \
--name es7 elasticsearch:7.3.0
```

```
docker pull docker.elastic.co/kibana/kibana:7.3.0

docker run -p 5601:5601 -d  --restart=always \
--net stack \
--name kibana docker.elastic.co/kibana/kibana:7.3.0
```



```
docker pull logstash:7.3.0

docker run -p 4560:4560 -d  --restart=always \
--net stack \
-v /volumes/logstash/config/logstash-springboot.conf:/usr/share/logstash/pipeline/logstash.conf \
--name logstash logstash:7.3.0
```

```
docker pull foxiswho/rocketmq:server-4.7.0
docker network create rocketmq

docker run -p 9876:9876 -d  --restart=always \
--net rocketmq \
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m -Xmn128m"  \
-v /volumes/rocket/broker/logs:/home/rocketmq/store/commitlog \
-v /volumes/rocket/broker/store:/home/rocketmq/store  \
--name rocket-server foxiswho/rocketmq:server-4.7.0
```

```
 docker pull foxiswho/rocketmq:broker-4.7.0
 
 docker run -p 10909:10909 -p 10911:10911 -d  --restart=always \
-e "JAVA_OPTS:=-Duser.home=/opt"  \
-e "NAMESRV_ADDR=119.23.106.43:9876" \
-e "JAVA_OPT_EXT=-server -Xms64m -Xmx64m -Xmn64m" \
-v /www/docker/rocket-broker/broker/logs:/opt/logs \
-v /www/docker/rocket-broker/store:/opt/rmqstore \
-v /www/docker/rocket-broker/config/broker.conf:/etc/rocketmq/broker.conf \
--name rocket-broker foxiswho/rocketmq:broker-4.7.0
```

```
 docker run -p 8180:8180  -d  --restart=always \
-e "JAVA_OPTS=-Drocketmq.config.namesrvAddr=47.113.105.186:9876 -Dserver.port=8180 -Drocketmq.config.isVIPChannel=false"  \
-e "JAVA_OPT_EXT=-Xms128m -Xmx128m -Xmn128m" \
--name rocket-console styletang/rocketmq-console-ng:latest

 mkdir -p /volumes/rocket/broker/logs
 mkdir -p /volumes/rocket/broker/store
```

```
xuxueli/xxl-job-admin:2.3.0

docker run -p 9001:9001  -d  --restart=always \
-v /volumes/xxl-job:/data/applogs \
-e "PARAMS=--spring.datasource.url=jdbc:mysql://120.76.40.77:3306/lilishop?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=UTC --spring.datasource.username=root --spring.datasource.password=shop@3306 --server.port=9001" \
--name xxl-job xuxueli/xxl-job-admin:2.3.0

docker run -p 6379:6379 --name redis \
-v /www/env/docker/redis/conf/redis.conf:/etc/redis/redis.conf  \
-v /www/env/docker/redis/data:/data \
-d redis:6.0.6 redis-server /etc/redis/redis.conf

yum -y install openssl openssl-devel   gd gd-devel pcre-devel zlib-devel

./configure --prefix=/www/env/nginx \
--with-pcre \
--with-http_ssl_module \
--with-http_v2_module \
--with-http_realip_module \
--with-http_addition_module \
--with-http_sub_module \
--with-http_dav_module \
--with-http_flv_module \
--with-http_mp4_module \
--with-http_gunzip_module \
--with-http_gzip_static_module \
--with-http_random_index_module \
--with-http_secure_link_module \
--with-http_stub_status_module \
--with-http_auth_request_module \
--with-http_image_filter_module \
--with-http_slice_module \
--with-mail \
--with-threads \
--with-file-aio \
--with-stream \
--with-mail_ssl_module \
--with-stream_ssl_module 
```

```
docker run -p 3306:3306 --name mysql \
-v /www/env/docker/mysql/conf:/etc/mysql/conf.d \
-v /www/env/docker/mysql/logs:/logs \
-v /www/env/docker/mysql/data:/var/lib/mysql \
-v /www/env/docker/mysql/dump:/dump \
-e MYSQL_ROOT_PASSWORD=sgV338MYkM1 -d mysql:5.7
```