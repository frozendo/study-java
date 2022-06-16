# Java 11

**Release Date:** 25/09/2018

**LTS version**

## New HTTP Client

The new Http Client was introduced in version 9 in incubator modules, a concept included in that version too. 
In version 11, this API was officially launched, with a some improvements made from user feedback. 
The new API is in _java.net.http_ package and bring support to _HTTP/1.1_ and _HTTP/2_.

There is three principals classes in this API:

* *HttpClient:* an abstract class used to send and receives requests and responses.
* *HttpRequest:* an abstract class that represent the HTTP requests.
* *HttpResponse:* an interface that represent the response HTTP given as an answer for a request.

This new API also has a class to work with web socket.

## To read more

For more details about Java 11, you can read these articles about:

[Novas APIs pós Java 8](https://frozendo.medium.com/novas-apis-p%C3%B3s-java-8-4a1a05a93a93#5d89)