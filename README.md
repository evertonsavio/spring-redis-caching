## Redis Caching in Spring Webflux  

---
* Run:
```bash
java -jar city-api.jar
```
* All data will be cached in redis for 10 seconds:
````json
HTTP GET localhost:8080/city/10001
Response
{
    "zip":"10002",
    "city":"New York",
    "stateName":
    "New York",
    "temperature":83
}
````