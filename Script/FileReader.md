2019 10 10



참고 https://www.w3.org/TR/FileAPI/#dfn-filereader


### Constructors
```javaScript
<input type='file' accept='image/*' onchange='openFile(event)'><br>
<img id='output'>
<script>
  var openFile = function(event) {
    var input = event.target;

    var reader = new FileReader();
    reader.onload = function(){
      var dataURL = reader.result;
      var output = document.getElementById('output');
      output.src = dataURL;
    };
    reader.readAsDataURL(input.files[0]);
  };
</script>

```
### readyState 
```javaScript
<input type='file' onchange='openFile(event)'>
<script>
  var stateNames = {};
  stateNames[FileReader.EMPTY]   = 'EMPTY';
  stateNames[FileReader.LOADING] = 'LOADING';
  stateNames[FileReader.DONE]    = 'DONE';

  var openFile = function(event) {
    var input = event.target;

    var reader = new FileReader();
    reader.onload = function(){
      console.log('After load: ' + stateNames[reader.readyState]);
    };

    console.log('Before read: ' + stateNames[reader.readyState]);
    reader.readAsDataURL(input.files[0]);
    console.log('After read: ' + stateNames[reader.readyState]);
  };
</script>
```

다른 개발자의 소스를 이해할 때 바로 이해되는 소스보다 계속 봐야 이해되거나 이해되지 않는 소스가 더 많다

