The following postman collection string can be used to call the rest service.

```yaml
{
  "info": {
    "_postman_id": "0953a8fd-8a00-4a2d-94f2-9a470d2c5323",
    "name": "interview-junior",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "http://localhost:8080/getCarType?carType=cabrio",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/getCarType?carType=cabrio",
          "protocol": "http",
          "host": [
              "localhost"
          ],
          "port": "8080",
          "path": [
              "getCarType"
          ],
          "query": [
            {
              "key": "carType",
              "value": "cabrio"
            }
          ]
        }
      },
      "response": []
    },
    {
      "name": "http://localhost:8080/getCarType?carType=sedan",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/getCarType?carType=sedan",
          "protocol": "http",
          "host": [
              "localhost"
          ],
          "port": "8080",
          "path": [
              "getCarType"
          ],
          "query": [
            {
              "key": "carType",
              "value": "sedan"
            }
          ]
        }
      },
      "response": []
    }
  ],
  "protocolProfileBehavior": {}
}
```

Example input
```
sedan
```



Example output
```
Sedan Car has produced.
```
