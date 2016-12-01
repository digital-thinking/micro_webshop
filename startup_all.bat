cd server_eureka
start mvn spring-boot:run
cd ..

cd server_zuul 
start mvn spring-boot:run
cd ..

cd category_service 
start mvn spring-boot:run
cd ..
cd product_service 
start mvn spring-boot:run
cd ..
cd security_service 
start mvn spring-boot:run
cd ..

cd user_proxy 
start mvn spring-boot:run
cd ..

cd product_proxy 
start mvn spring-boot:run
cd ..