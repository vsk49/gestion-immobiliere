FROM eclipse-temurin:17-jre
WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd

COPY target/SAEA_3.01-1.0-SNAPSHOT.jar app.jar
COPY target/ojdbc11-21.5.0.0.jar ojdbc11.jar
COPY wait-for-oracle.sh /app/wait-for-oracle.sh
RUN chmod +x /app/wait-for-oracle.sh

ENTRYPOINT ["java", "-cp", "app.jar:ojdbc11.jar", "vue.IHMConnexion"]