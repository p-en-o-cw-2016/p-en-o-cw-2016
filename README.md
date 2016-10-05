P&O CW 2016 Shared Artifacts
============================

This repository contains the following:
- in `api`: a Java API for interaction between a Drone Autopilot and a Drone Autopilot Virtual Testbed, both running in the same Java Virtual Machine
- in `wireprotocol.md`: a definition of a wire protocol for interaction between a Drone Autopilot and a Drone Autopilot Virtual Testbed, running in different processes or on different machines.
- in `adaptors`:
  - a TestbedStub class for connecting a Testbed that implements the wire protocol to an Autopilot that implements the Java API
  - an AutopilotProxy class for connecting a Testbed that implements the Java API to an Autopilot that implements the wire protocol
