#What is reactive processing?
Reactive processing is a paradigm that enables developers build non-blocking, asynchronous applications that can handle back-pressure (flow control).

#Core features - 
sending data as stream and not as object
1. Asynchronus and non blocking
2. Functional style code
3. Data flow a  s event driven stream
4. Backpressure on data stream

Synchronus - even if we cancel the request from front end, backend process continue to produce data.
Reactive programming - even if we cancel the request from front end, backend process stop producing data.

Functional endpoint - RouterFunction - route & handler method

#Create a WebClient
###https://spring.io/guides/gs/reactive-rest-service/
###https://projectreactor.io/docs/core/release/reference/
The Spring RestTemplate class is, by nature, blocking. Consequently, we do not want to use it in a reactive application. For reactive applications, Spring offers the WebClient class, which is non-blocking. We use a WebClient-based implementation to consume our RESTful service

##Reactive event streaming
@Autowired
private Sinks.Many<bean-name> event;

event.tryEmitNext(bean-name);

#Difference between flatMap & concatMap
 - flatMap used when return type is flux or mono, it does not maintain ordering of stream elements
 - concatMap maintains ordering of elements/preserving of order
 - both are used for asynchrous oprations.