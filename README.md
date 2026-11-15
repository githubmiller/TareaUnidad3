# Tarea Unidad 3 – Sorteo de equipos

## Descripción del proyecto

Aplicación desarrollada en Java para realizar el sorteo de partidos de una liga profesional conformada inicialmente por 16 equipos.

El proyecto utiliza el patrón arquitectónico Modelo-Vista-Controlador (MVC), un algoritmo recursivo para generar los emparejamientos, excepciones personalizadas y serialización de objetos para guardar y recuperar el estado del torneo.

## Funcionalidades

- Registro de 16 equipos participantes.
- Sorteo aleatorio de enfrentamientos.
- Generación de las cuatro etapas:
  - Octavos de final.
  - Cuartos de final.
  - Semifinales.
  - Final.
- Emparejamiento mediante un algoritmo recursivo.
- Selección aleatoria de ganadores para avanzar entre etapas.
- Validación de la cantidad de equipos participantes.
- Manejo de excepciones personalizadas.
- Serialización y deserialización del torneo mediante archivos binarios.

## Tecnologías utilizadas

- Java.
- Eclipse IDE.
- Git.
- GitHub.

## Estructura del proyecto

El proyecto está organizado mediante paquetes que implementan la arquitectura MVC:

```text
TareaUnidad3/
│
├── src/
│   ├── controlador/
│   │   └── ControladorTorneo.java
│   │
│   ├── excepciones/
│   │   ├── NumeroEquiposInvalidoException.java
│   │   └── SorteoInvalidoException.java
│   │
│   ├── modelo/
│   │   ├── Equipo.java
│   │   ├── Partido.java
│   │   └── Torneo.java
│   │
│   ├── principal/
│   │   └── Main.java
│   │
│   └── vista/
│       └── VistaTorneo.java
│
├── torneo.ser
├── .classpath
├── .project
└── .gitignore
```

## Ejecución del proyecto

1. Abrir Eclipse IDE.
2. Seleccionar **File → Import → Git → Projects from Git**.
3. Seleccionar **Clone URI** e introducir la dirección del repositorio.
4. Importar el proyecto en el espacio de trabajo.
5. Abrir `principal/Main.java`.
6. Ejecutar mediante **Run As → Java Application**.

## Persistencia de datos

El proyecto implementa serialización y deserialización utilizando:

- `ObjectOutputStream`.
- `FileOutputStream`.
- `ObjectInputStream`.
- `FileInputStream`.

El estado del torneo se almacena en el archivo binario `torneo.ser`, permitiendo recuperar los equipos y el historial de partidos.

## Repositorio

[GitHub – TareaUnidad3](https://github.com/githubmiller/TareaUnidad3)

**Proyecto académico – Unidad 3**

Programación Orientada a Objetos.
