## Android Dev Peru Website

We're Android developers, so of course we're Kotlin first! The official website of the community is built with 
[Kobweb](https://github.com/varabyte/kobweb), a framework that allows us to build a static (or fullstack) web with Compose.

## Project Structure

- `site/` - The main project folder. This is where you'll be spending most of your time.
  - `public` - The public files which are deployed to the server.
  - `src` - The source code of the project.

## Run the project

```bash
cd site
kobweb run
```

## Exporting the Project

When you are ready to ship, you should shutdown the development server and then export the project using:

```bash
kobweb export --layout static
```

When finished, you can run a Kobweb server in production mode:

```bash
kobweb run --env prod
```