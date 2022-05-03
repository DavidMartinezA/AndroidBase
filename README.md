## Autor

Ceiba Software Mayo de 2022 - [Cristian Martinez](https://github.com/DavidMartinezA)

## Descripción

Este proyecto cuenta con las mejores prácticas y herramientas de desarrollo,
además de tecnologías vanguardistas del desarrollo mobile en Android,
entre las cuales se encuentran clean code,clean architecture, inyección de dependencias, MVVM,
entre otros; buscando construir una base sólida sobre la cual los desarrolladores 
puedan basarse para construir aplicaciones bien estructuradas y fácilmente escalables,
facilitando los tiempos iniciales de un proyecto, y definiendo un marco arquitectónico 
y de desarrollo dentro de la familia CEIBA.

## Alcance

Proyecto con las siguientes características:
Aplicación que muestra un listado de películas, al dar tap en alguna de ellas muestra un detalle de la misma.

## especificaciones:

-Cuandose abre la aplicación busca la información de manera local.
-Cuando no se encuentra información de manera local se consulta mediante el servicio web.
-Cuando la información encontrada localmente fue almacenada hace más de un dia, debe buscarse en el servicio web 
y persistir la nueva información encontrada.

## Abrir código fuente

Para abrir el código fuente se requiere:

-[Android Studio](https://developer.android.com/studio/) 

-Android SDK

-Java 8

## Herramientas Empleadas

1. [Kotlin](https://developer.android.com/kotlin)
2. [Git](https://git-scm.com/)
3. [GitHub](https://github.com/)

## Librerias

1. [Hilt](https://dagger.dev/hilt/)
2. [Room](https://developer.android.com/training/data-storage/room)
3. [Junit](https://junit.org/junit5/)
4. [Espresso](https://developer.android.com/training/testing/espresso)
5. [Retrofit](https://square.github.io/retrofit/)

## Arquitectura

Arquitectura limpia como DDD enfocada en el modelo de dominio y en el apartado de aplicación se usará MVVM
Se usará el diseño guiado por el dominio ya que provee una estructura de prácticas y terminologías para tomar decisiones
de diseño que enfoquen y aceleren el manejo de dominios complejos en los proyectos de software.

## Licencia

Ceiba Software House 2022
