# Spring Kubernates Playground
A Spring Cloud Kubernetes Playground

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](/LICENSE)

## info

This project aim to use the new Spring Cloud Gateway using Kubernates

Currently it has several subprojects:

- [Local Registry](local-registry/) : A local docker registry that will run in the kubernetes cluster to get fast feedback of deployments
- [Eureka Server](eureka-server/) : A Eureka Server as a temporary service discovery server for testing the gateway
- [Simple Microservice](simple-microservice/) : A Simple Microservice to test the gateway
- [Spring Kubernetes Gateway](spring-kube-gateway/) : Our Spring Cloud Gateway with Kubernetes support

TBC