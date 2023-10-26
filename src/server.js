const express  =  require ("express");
const middleware = require("./middleware");

const app = express()
const port = 5000

app.use("/", middleware);

app.get('/', (req,res) =>{
  return res.send('Logado')
})

app.listen(port, () =>{
  console.log(port)
})