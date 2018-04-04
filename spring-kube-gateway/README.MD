# Spring Kubernetes Gateway
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

First you need to compile this project:

```bash
$ mvnw clean package
```

Before continue you need to have your local registry running on the cluster:

 [Local Registry](../local-registry/)

Then, build the docker image and push it to a local registry

```bash
$ docker build . -t gateway
$ docker tag gateway localhost:5000/gateway
$ docker push localhost:5000/gateway
```

And finally add it to the kubernetes cluster with:

```bash
$ kubectl create -f gateway-deploy.yml
```
Now we could invoke the Microservice in with:

```bash
$ minikube service gateway
```

and change the url to `http://service-url/NAME-IN-EUREKA/method`, for example:

```bash
$ curl http://192.168.99.100:30418/simplemicroservice/hello
```
