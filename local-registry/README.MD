# Local Registry

A local registry to use for faster feedback on kubernete deployments using minikube

This registry will persist when you stop and start your cluster

To create the registry run:

```bash
$ kubectl create -f registry.yml
```

To check that the registry is working in the kubernetes cluster

```bash
$ minikube ssh
$ curl http://localhost:5000/v2/_catalog
```
To configure your local docker to use the docker daemon on the kubernate cluster do:

- on mac / linux
```bash
$ eval $(minikube docker-env)
```

- on windows

```bat
> @for /f "tokens=*" %i IN ('minikube docker-env') DO @%i
```

now you could build your docker and publishin in the registry inside the cluster

for example to publish a image named hello:

```bash
$ docker build . -t hello
$ docker tag hello localhost:5000/hello
$ docker push localhost:5000/hello
```

now to run the image in the kubernetes cluster

```bash
$ kubectl.exe run hello --image=localhost:5000/hello --port=8080
```

to expose as a service

```bash
$ kubectl.exe expose deployment hello --type=NodePort
```

and finally to show it on your browser

```bash
$ minikube service hello
```

This service will be enable back again after stoping / starting your cluster

You could check the contents of the registry doing

```bash
$ minikube ssh
$ curl http://localhost:5000/v2/_catalog
{"repositories":["hello"]}
```
