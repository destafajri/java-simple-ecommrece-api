run-app:
	@mvn clean compile package -DskipTests && java -jar core-module/target/core-module-0.0.1-SNAPSHOT.jar

clean-target:
	@mvn clean

build:
	@mvn clean compile package -DskipTests

build-test:
	@mvn clean compile test package

run-jar:
	@java -jar core-module/target/core-module-0.0.1-SNAPSHOT.jar