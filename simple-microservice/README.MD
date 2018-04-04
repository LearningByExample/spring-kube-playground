# Simple Microservice

A Simple Microservice for testing the Spring Cloud Gateway

First you need to compile this project:

```bash
$ mvnw clean package
```

Before continue you need to have your local registry running on the cluster:

 [Local Registry](../local-registry/) 

Then, build the docker image and push it to a local registry

```bash
$ docker build . -t simple-microservice
$ docker tag simple-microservice localhost:5000/simple-microservice
$ docker push localhost:5000/simple-microservice
```

And finally add it to the kubernetes cluster with:

```bash
$ kubectl create -f simple-microservice-deploy.yml
```
Now we could invoke the Microservice in with:

```bash
$ minikube service simple-microservice
```

and change the url to `http://service-url/hello`
