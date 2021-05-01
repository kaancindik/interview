The following postman collection string can be used to call the rest service.

```yaml
{
   "info": {
      "_postman_id": "2d9ab027-5ba4-464c-bd3c-0634218c6771",
      "name": "interview",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
   },
   "item": [
      {
         "name": "http://localhost:8080/processParking",
         "request": {
            "method": "POST",
            "header": [],
            "body": {
               "mode": "raw",
              "raw": "park 34-SO-1988 Black Car\r\npark 34-BO-1987 Red Truck\r\npark 34-VO-2018 Blue Jeep\r\npark 34-HBO-2020 Black Truck\r\nleave 3\r\npark 34-LO-2000 White Car\r\nstatus"
            },
            "url": {
               "raw": "http://localhost:8080/processParking",
               "protocol": "http",
               "host": [
                  "localhost"
               ],
               "port": "8080",
               "path": [
                  "processParking"
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
park 34-SO-1988 Black Car
park 34-BO-1987 Red Truck
park 34-VO-2018 Blue Jeep
park 34-HBO-2020 Black Truck
leave 3
park 34-LO-2000 White Car
status
```



Example output
```
Allocated 1 slot.
Allocated 4 slot.
Allocated 2 slot.
Garage is full.
Allocated 1 slot.


Status:
34-SO-1988 Black [1]
34-BO-1987 Red [3, 4, 5, 6]
34-LO-2000 White [8]
```
