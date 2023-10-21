/*
  Warnings:

  - You are about to drop the `user` table. If the table is not empty, all the data it contains will be lost.

*/
-- DropTable
DROP TABLE "user";

-- CreateTable
CREATE TABLE "User" (
    "id" SERIAL NOT NULL,
    "nome" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "idade" INTEGER,
    "linguagens" TEXT[],
    "idiomas" TEXT[],

    CONSTRAINT "User_pkey" PRIMARY KEY ("id")
);
