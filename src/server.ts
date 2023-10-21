import { PrismaClient } from "@prisma/client";
import express,{Express} from 'express'
import router from './router'

const app:Express = express()
const prisma = new PrismaClient()

app.use(express.json())
app.use('/User', router.user)

app.listen(3333, () => {
    console.log('Example app listening on port 3333')
  })