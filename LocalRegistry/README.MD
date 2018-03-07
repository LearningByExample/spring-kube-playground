# Local Registry

A local registry to use for faster feedback on kubernete deployments

To create the registry run:

```bash
$ kubectl create -f registry.yml
$ minikube ssh
$ curl http://localhost:5000/v2/_catalog
```

To check that the registry is working in the kubernetes cluster
```bash
$ minikube ssh
$ curl http://localhost:5000/v2/_catalog
```
