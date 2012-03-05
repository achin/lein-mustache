This plugin evaluates [Mustache](http://mustache.github.com/) templates using the [Clostache](https://github.com/fhd/clostache) library. This library is in development and has been tested with Clojure 1.3.0 and Leiningen 1.6.2.

Installation
============

`lein-mustache` is available as a plugin.

    $ lein plugin install lein-mustache 0.1

Or you can include it in your `project.clj`:

    :dev-dependencies [[lein-mustache "0.1"]]

Use
===

To evaluate a Mustache template in file, `template`, with Clojure data in file, `data`, type this:

    $ lein mustache template data

Example
=======

If `resources/hello.mustache` in your Leiningen project contains the following:

    Hello, {{name}}, welcome to {{system}}.

And `resources/data.clj` contains:

    {:name "Alex"
     :system "Your Computer"}

Then running

    lein mustache resources/hello.mustache resources/data.clj

Will output

    Hello, Alex, welcome to Your Computer.

Contributors
============

[Alex Chin](https://github.com/achin)
