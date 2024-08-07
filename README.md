## Android Dev Peru Website

We're Android developers, so of course we're Kotlin first! The official website of the community is built with 
[Kobweb](https://github.com/varabyte/kobweb), a framework that allows us to build a static (or fullstack) web with Compose.

## Project Structure

- `site/` - The main project folder. This is where you'll be spending most of your time.
  - `public` - The public files which are deployed to the server.
  - `src` - The source code of the project.
    - `jsMain`
      - `pages`: the pages of the website
      - `components` shared components (layouts, widgets, etc.)
      - `data`: static data sources and models
    - `commonMain`
      - `libres`: localized resources (strings, images)

## Run the project

First, you have to install `kobweb` binary. Follow the test [installation steps in the official docs](https://github.com/varabyte/kobweb?tab=readme-ov-file#install-the-kobweb-binary).

Once installed locally, execute the project with:

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
