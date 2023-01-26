## API Practice: Love Calculator

API Link: https://rapidapi.com/ajith/api/love-calculator

Take 2 inputs name1 & name2

Calculate and return json

store json in redis database

LoveCalculator API key (Macos)
```
export LOVE_CALCULATOR_KEY=<your api key>
```

X-RapidAPI-Key: 431350f947msh1d9b2c145f95c1cp115117jsneee91761942a
X-RapidAPI-Host: love-calculator.p.rapidapi.com


TODO 25/1/2023
1. extract info from redis (LoveRedis)
    - convert json string to object
2. return array to controller
3. use thymeleaf with for each loop in html
4. display all results (fname <3 sname <percentage> <results>)