# {{name}}

FIXME

## Usage

### Run the application locally

`lein ring server`
{{midje-readme}}{{cl-test-readme}}
### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/server.jar
```

### Packaging as war

`lein ring uberwar`

## License

Copyright © {{year}} FIXME
