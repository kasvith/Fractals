# Simple Fractal generator

## Builds

  - Travis-CI : [![Build Status](https://travis-ci.org/kasvith/Fractals.svg?branch=master)](https://travis-ci.org/kasvith/Fractals)

## Code quality

  - Codacy : [![Codacy Badge](https://api.codacy.com/project/badge/Grade/fbd8b9de9eeb4b058e73344221bda6ce)](https://www.codacy.com/app/alankasun/Fractals?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=kasvith/Fractals&amp;utm_campaign=Badge_Grade)

  - Better Code Hub : [![BCH compliance](https://bettercodehub.com/edge/badge/kasvith/Fractals?branch=master)](https://bettercodehub.com/)

## Compilation

- ### Ant
  Run `ant build.xml`
  
- ### Java Compiler
  Run `javac Fractal.java -d .`
  
## Running
  Run with :
  - `java Fractal`
  - `java Fractal [Mandelbrot|Julia]`
  - `java Fractal Mandelbrot [realmin, realmax, imagmin, imagmax] [iterations]`
  - `java Fractal Julia [real imag] [iterations]`
  
## Screenshot

- Mandelbrot
![image](https://user-images.githubusercontent.com/13379595/29001481-52bf052c-7aa9-11e7-974f-a0f750bf6704.png)

- Julia
![image](https://user-images.githubusercontent.com/13379595/29001485-77135e3c-7aa9-11e7-824a-b25b3236038b.png)
