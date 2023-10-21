-- CreateTable
CREATE TABLE "usuario" (
    "id" SERIAL NOT NULL,
    "nome" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "idade" INTEGER,
    "linguagens" TEXT[],
    "idiomas" TEXT[],

    CONSTRAINT "usuario_pkey" PRIMARY KEY ("id")
);
