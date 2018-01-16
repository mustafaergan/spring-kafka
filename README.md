CMD:
zkserver --zookeeper

.\bin\windows\kafka-server-start.bat .\config\server.properties --kafka

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic java_in_use_topic --from-beginning --consumer listener


