import {Router, Request, Response} from 'express'
import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient()
const  router = Router()

router.post('/Create',async (req:Request, res:Response) => {
    try {
        const {nome, email, idade, linguagens, idiomas} = req.body
        const user = await prisma.user.create({
            data:{
                nome, 
                email, 
                idade, 
                linguagens, 
                idiomas
            }
        })
        res.json(user)
    }catch(error){
        res.status(400).json()
        console.log(error)
    }
})

router.get('/ReadAll',async (req:Request, res:Response) => {
    try{
        const users = await prisma.user.findMany();
        res.json(users)
    }catch(error){
        res.status(400).json()
        console.log(error)
    }
})

router.get('/Read/:userId',async (req:Request, res:Response) => {
    const {userId} = req.params
    try{
        const userRead = await prisma.user.findUniqueOrThrow({
            where:{
                id: Number(userId),
            },
        });
        res.json(userRead)
    }catch(error){
        res.status(400).json()
        console.log(error)
    }
})

router.put('/Update/:userId',async (req:Request, res:Response) => {
    const {userId} = req.params
    const {nome, email, idade, linguagens, idiomas} = req.body
    try{
        const userUpdate = await prisma.user.update({
            where: {
              id: Number(userId),
            },
            data:{
                nome, 
                email, 
                idade, 
                linguagens, 
                idiomas
            }
          })
        res.json(userUpdate)
    }catch(error){
        res.status(400).json()
        console.log(error)
    }
})

router.delete('/Delete/:userId',async (req:Request, res:Response) => {
    const {userId} = req.params
    try{
        const deleteUser = await prisma.user.delete({
            where:{
                id: Number(userId),
            },
        })
        res.json(deleteUser)
    }catch(error){
        res.status(400).json()
        console.log(error)
    }
})

export default router