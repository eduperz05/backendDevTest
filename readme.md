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


#### Thought process

I started by reading the test statement and the contract, then I started to think about the architecture as I've decided to work with **_java 17_** and **_springboot3_** since I  actually work with them. I've decided to use **_hexagonal architecture_** because the test statement of the test was work with clean architectures, I'm not working with Hexagonal architecture for a long time, so I decided to use this as a challenge to improve my skills and refresh my knowledge.

I started by working on the domain layer, made the model of the products and the contract (ports) and then from here jumped to the adapter to connect with the foreign microservice given, after connection was coded, I followed and inverse path of develop until reach the endpoint for the similar products. After the endpoint was done, I started to work on the error handling and some unit and integration tests and logs.

I've never worked with **_k6_** so I focused on trying my code to overcome the performance tests. I noted that the code is still far from being optimal and I still can do a lot of improvements if we talk about performance, but I think it's a good start. Implementing reactive programming with **_spring webflux_** could be a good improvement, using **_resilience4j_** to handle the **_circuit breaker pattern_** could be another one and adding a **_cache layer_** could be another one. I invested some time to investigate about these techs but I decided to not implement them as I feel like they are mayor changes in the architecture and I should have planned them from the beginning.

My final thoughts are that I enjoyed the process of taking this test, I think I could have done a better job with the performance tests, but I'm happy with the result. I'm also happy with the architecture and the code, I think it's clean, easy to understand and maintain.