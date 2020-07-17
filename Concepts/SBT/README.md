# [Scala Build Tool (SBT)](https://www.scala-sbt.org/1.x/docs/index.html)

### Create directory structure
``` bash
mkdir HelloWorld
cd HelloWorld
mkdir -p src/{main,test}/{java,resources,scala}
mkdir project target
```

### Run
- https://www.scala-sbt.org/1.x/docs/Running.html
```bash
sbt run
```

### Run with open debug socket connection
```bash
sbt run -jvm-debug 9999
```