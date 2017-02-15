World Description File Format v2
================================

This is a binary format. All multi-byte primitives are written in big-endian byte order (most significant byte first). (Note: this is what Java’s DataOutputStream and DataInputStream support.) (Note: x86/x64 CPUs are little-endian. In C/C++, use htonl()/ntohl().)

"float" means a 32-bit IEEE single precision floating point number; "uN" means an N-byte unsigned integer.

```
WorldDescriptionFile_v2 {
    u1 magic[4] = {'W','D','F','F'}; // The first four bytes of the file are the ASCII characters 'W', 'D', 'F', 'F'.
    u1 version = 2;
    float horizontalAngleOfView;
    float verticalAngleOfView;
    u2 imageWidth;
    u2 imageHeight;
    float cameraSeparation;
    float weight;
    float gravity;
    float drag;
    float maxThrust;
    float maxPitchRate;
    float maxRollRate;
    float maxYawRate;
    u2 windSpeedXPointsCount;
    float windSpeedXPoints[2*windSpeedXPointsCount];
    u2 windSpeedYPointsCount;
    float windSpeedYPoints[2*windSpeedYPointsCount];
    u2 windSpeedZPointsCount;
    float windSpeedZPoints[2*windSpeedZPointsCount];
    u2 windRotationAroundXCount;
    float windRotationAroundXPoints[2*windRotationAroundXPointsCount];
    u2 windRotationAroundYCount;
    float windRotationAroundYPoints[2*windRotationAroundYPointsCount];
    u2 windRotationAroundZCount;
    float windRotationAroundZPoints[2*windRotationAroundZPointsCount];
    u2 objectCount;
    object objects[objectCount];
}

object {
    u2 vertexCount;
    vertex vertices[vertexCount];
    u2 faceCount;
    face faces[faceCount];
}

vertex {
    float x;
    float y;
    float z;
}

face {
    // The three vertices are sorted clockwise when viewed from outside the object
    u2 vertex1; // 0-based index into array 'vertices'
    u2 vertex2;
    u2 vertex3;
    // Outline color
    u1 red;
    u1 green;
    u1 blue;
    // The inside color should be a desaturated version of the outline color. A future version of the file format may allow separately specifying the color or texture of the inside. 
}
```
