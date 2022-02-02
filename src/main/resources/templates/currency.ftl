<!DOCTYPE html>
<html>
    <head>
        <title>Currency converter</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        </head>
    <body>
    <div class="container">
       <div class="panel panel-primary">
             <div class="panel-heading">
    <h2>Currency List</h2>
             </div>
    <p>
        <legend>Converter</legend>
        <form name="currency" action="read" method="GET">
            <p> From </p>
            <select name="currencyFrom" >
                <#list charCodes as charCodes>
                    <option value="${charCodes}">${charCodes}</option>
                </#list>
            </select>
            <input type="text" size="40" name="valueFrom" />
            <p> To </p>
            <select name="currencyTo">
                <#list charCodes as charCodes>
                    <option value="${charCodes}">${charCodes}</option>
                </#list>
            </select>
            <p> = </p>
            <p>Value: ${sumValueTo}  </p>
            <input type="submit" value="read" />
        </form>
    </p>
    <p>sumValueFromSum: ${sumValueFromSum}  sumValueToSum: ${sumValueToSum} conversionValueAvg: ${conversionValueAvg}</p>
    <div class="panel-body">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>charCodeFrom</th>
            <th>ValueFrom</th>
            <th>charCodeTo</th>
            <th>ValueTo</th>
            <th>conversionValue</th>
            <th>sumValueFrom</th>
            <th>sumValueTo</th>
          </tr>
        </thead>
        <tbody>
         <#list currencies as currency>
                          <tr>
                                <td>${currency.charCodeFrom}</td>
                                <td>${currency.valueFrom}</td>
                                <td>${currency.charCodeTo}</td>
                                <td>${currency.valueTo}</td>
                                <td>${currency.conversionValue}</td>
                                <td>${currency.sumValueFrom}</td>
                                <td>${currency.sumValueTo}</td>
                          </tr>
             </#list>
        </tbody>
      </table>
    </div>
  </div>
           </div>
     </body>
</html>