World description file format
=============================

World description files must be text files of the following form:

```c
horizontalAngleOfView verticalAngleOfView imageWidth imageHeight cameraSeparation weight gravity drag maxThrust maxPitchRate maxRollRate maxYawRate
windSpeedXPoints
windSpeedYPoints
windSpeedZPoints
windRotationRateAroundXPoints // the wind causes the drone to rotate around an axis through its center parallel to the world X axis at this rate. Positive means clockwise when looking at 1 0 0 from 0 0 0. In degrees per second.
windRotationRateAroundYPoints
windRotationRateAroundZPoints
"target_ball" x y z // one or more lines
"obstacle_ball" x y z // zero or more lines; not applicable to Milestones 1.3 and 1.4
```

The wind lines are sequences of the form
```
time1 value1 time2 value2 time3 value3 ... timeN valueN
```
These lines must satisfy `0 < time1 < time2  < ... < timeN`. Such a line defines a piecewise linear function which starts at value 0 at time 0, evolves linearly to `value1` at time `time1`, etc. After `timeN` it evolves again to `value1` at time `timeN + time1`, etc.

The drone is initially at position 0 0 0, has speed 0, pitch 0 and roll 0, and is looking towards 1 0 0. An arrow from the left camera to the right camera points towards 0 0 1, and the gravity vector points towards 0 -1 0. All balls have radius 0.5. The radius of the drone is 0.25. The drone touches a ball if the distance between the center of the ball and the point between the camera pinholes is less than the sum of the radii.

Example file (merely illustrates the format; does not necessarily define a "nice" world):

```
120.0 120.0 100 100 0.25 1.0 9.81 0.2 100.0 100.0 100.0 100.0
1.0 1.0 2.0 0.0 3.0 1.0 4.0 0.0
1.0 0.0 2.0 1.0 3.0 0.0 4.0 1.0
1.0 1.0 2.0 0.0 3.0 1.0 4.0 0.0
1.0 0.0 2.0 1.0 3.0 0.0 4.0 1.0
1.0 1.0 2.0 0.0 3.0 1.0 4.0 0.0
1.0 0.0 2.0 1.0 3.0 0.0 4.0 1.0
target_ball 10.0 0.0 0.0
target_ball 0.0 10.0 0.0
obstacle_ball 5.0 0.0 0.0
obstacle_ball 0.0 5.0 0.0
```
