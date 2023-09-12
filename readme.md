# Backend dev technical test

## Test Statement
We want to offer a new feature to our customers showing similar products to the one they are currently seeing. To do this we agreed with our front-end applications to create a new REST API operation that will provide them the product detail of the similar products for a given one. [Here](./similarProducts.yaml) is the contract we agreed.

To see the rest of the full Test Statement you can go check [Here](https://github.com/dalogax/backendDevTest).

## Implementation

I developed a new microservice api with hexagonal architecture that offers a new feature that returns a list of products with detaills given a product id.

#### Build and run
The product is integrated with the resources given with the test in docker, so you just need to up the compose:
```console
docker-compose up --build -d simulado influxdb grafana similar
```

After code is running, you can check the API Doc at:

Html: http://localhost:8080/swagger-ui/index.html

Yaml: http://localhost:5000/v3/api-docs

#### Test and Performance

To run the tests and see the results follow the given steps:
```console
docker-compose run --rm k6 run scripts/test.js
```

Browse http://localhost:3000/d/Le2Ku9NMk/k6-performance-test to view the results.
