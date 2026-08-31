<p align="center">
  <h1 align="center">Sistema Web de Automatización de Reservas y Gestión de Señas</h1>
  <h3 align="center">Viringo's Bar 🍻</h3>
  <br>
  <img src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E" alt="JavaScript">
  <img src="https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white" alt="TypeScript">
  <img src="https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white" alt="Vite">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white" alt="MongoDB">
</p>

> **Trabajo Final Integrador** - Tecnicatura Universitaria en Programación (UTN)

## 👥 Equipo de Trabajo
- **D'Agostino Matías Julián**
- **Cufré Facundo Julián**
- **Tutor:** Londero Oscar

---

## 📋 Índice
- [Contexto y Problema](#-contexto-y-problema)
- [Solución Propuesta](#-solución-propuesta)
- [Stack Tecnológico](#-stack-tecnológico)
- [Arquitectura y Despliegue](#-arquitectura-y-despliegue)

---

## ⚠️ Contexto y Problema
El proyecto está pensado para **Viringo's Bar**, un establecimiento gastronómico que actualmente enfrenta serios cuellos de botella operativos debido a la falta de un canal digital automatizado.

Todo el sistema de reservas se maneja de forma manual a través de WhatsApp, Instagram y Facebook. Esto genera:
- **Saturación operativa:** El personal invierte demasiadas horas respondiendo consultas repetitivas y anotando reservas a mano, restando tiempo a la atención presencial y otras tareas.
- **Alto índice de ausentismo:** Al no existir compromiso económico o garantía previa, un porcentaje considerable de clientes reserva mesas y no se presenta. Esto se traduce en mesas vacías y una pérdida económica sustancial para el local.

## 💡 Solución Propuesta
Se desarrollará una aplicación web ágil donde los clientes puedan autogestionar la reserva de sus mesas de manera autónoma. 

La plataforma incluirá un sistema para requerir el pago o la simulación de una **seña previa** como condición obligatoria para confirmar el turno. Esto permitirá:
1. Filtrar a los clientes dubitativos o curiosos.
2. Reducir drásticamente el ausentismo.
3. Liberar por completo al personal de tener que gestionar reservas de forma artesanal.

---

## 🚀 Stack Tecnológico

### Frontend
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)
![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white)
- **Enfoque:** Interfaz de usuario intuitiva asegurando un tipado estricto de los datos durante el proceso de reserva.

### Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- **Enfoque:** Construcción de una API REST sólida encargada de procesar reglas de negocio, validar disponibilidad y gestionar estados aplicando los principios de POO.

### Base de Datos
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
- **Enfoque:** Almacenamiento NoSQL orientado a documentos, ideal para manejar estructuras dinámicas de reservas.

---

## ☁️ Arquitectura y Despliegue
- **Frontend:** Vercel
- **Backend:** Railway
- **Base de Datos:** MongoDB Atlas
