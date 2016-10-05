P&O CW 2016: Drone Autopilot & Virtual TestBed Wire Protocol
============================================================

This is a binary protocol. All multi-byte primitives are sent in big-endian byte order (most significant byte first). (Note: this is what Java’s DataOutputStream and DataInputStream support.) (Note: x86/x64 CPUs are little-endian. In C/C++, use htonl()/ntohl().)

This document uses Java’s types. That is, "int" means a 32-bit two’s-complement signed integer; "float" means a 32-bit IEEE single precision floating point number.

When a connection between a testbed and an autopilot is established, the testbed starts by sending the following constants, in the following order:

- camera information (only sent once because it is the same for both cameras):
  * float horizontalAngleOfView
  * float verticalAngleOfView
  * int width
  * int height
- drone and world information:
  * float cameraSeparation
  * float weight
  * float gravity
  * float drag
  * float maxThrust
  * float maxPitchRate
  * float maxRollRate
  * float maxYawRate

Then, initially, and after each simulation step (i.e., after simulated time is advanced), the testbed sends the current drone sensor information, and the autopilot responds with the new motion parameters. Specifically, the testbed sends the following information, in the following order:

- the left camera image
- the right camera image
- float pitch
- float yaw
- float currentTime (the amount of simulated time that has elapsed since the start of the simulation)

A camera image is sent as a sequence of width × height (see camera information) pixels, row by row, with the topmost row first, and the leftmost pixel first in each row. A pixel is sent as a sequence of three bytes: red, green, blue.

The autopilot responds with the following information, in the following order:

- float pitchRate
- float rollRate
- float yawRate
- float thrust

The testbed can end the conversation by closing the connection instead of sending a new set of drone sensor information.

This document does not specify how a connection is established, in particular, which party listens. The optimal choice depends on who is behind a firewall. It is recommended that each party support both roles.

A Java implementation of the wire protocol is provided, in the form of adaptors between the wire protocol and the Java API.
