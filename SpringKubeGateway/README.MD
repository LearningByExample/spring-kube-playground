# SpringKubeGateway
A Spring Cloud Gateway with Kubernetes support

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](/LICENSE)

## info

This is a simple edge server using the new spring cloud gateway.

The gateway could be run locally or expose in a kubernetes cluster.


## run it locally

First, you need to have running the Eureka on your computer, for example the provided [EurekaServer](../EurekaServer/).

Then, you need some microservices running in eureka, such the provide [SimpleMicroservice](../SimpleMicroservice/)

Finally, start the gateway with:

```bash
$ mvnw spring-boot:run
```

You could invoke any server in eureka in the format off `http://localhost/NAME-IN-EUREKA/method`, for example:

```bash
$ curl http://localhost/simplemicroservice/hello
```

## run it in the kubernertes cluster

TBD
