# Local Registry

A local registry to use for faster feedback on kubernete deployments

To create the registry run:

```bash
$ kubectl create -f registry.yml
```

To check that the registry is working in the kubernetes cluster
```bash
$ minikube ssh
$ curl http://localhost:5000/v2/_catalog
```
To configure docker to use the docker daemon on the kubernate cluster do:

- on mac / linux
```bash
$ eval $(minikube docker-env)
```

- on windows

```bat
> @for /f "tokens=*" %i IN ('minikube docker-env') DO @%i
```