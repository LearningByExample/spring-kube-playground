# Eureka Server

A Eureka Server for testing the new Spring Cloud Gateway

First you need to compile this project:

```bash
$ mvnw clean package
```

Before continue you need to have your local registry running on the cluster:

 [Local Registry](../local-registry/) 

Then, build the docker image and push it to a local registry

```bash
$ docker build . -t eureka-server
$ docker tag eureka localhost:5000/eureka-server
$ docker push localhost:5000/eureka-server
```

And finally add it to the kubernetes cluster with:

```bash
$ kubectl create -f eureka-server-deploy.yml
```
Now we could see the Eureka Server in our browser with:

```bash
$ minikube service eureka-server
```
