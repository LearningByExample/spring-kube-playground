# Spring Kubernates Playground
A Spring Cloud Kubernetes Playground

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](/LICENSE)

## info

This project aim to use the new Spring Cloud Gateway using Kubernates

Currently it has several subprojects:

- [LocalRegistry](LocalRegistry/) : A local docker registry that will run in the kubernetes cluster to get fast feedback of deployments
- [EurekaServer](EurekaServer/) : A Eureka Server as a temporary service discovery server for testing the gateway
- [SimpleMicroservice](SimpleMicroservice/) : A Simple Microservice to test the gateway
- [SpringKubeGateway](SpringKubeGateway/) : Our Spring Cloud Gateway with Kubernetes support

TBC