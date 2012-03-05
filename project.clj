(defproject lein-mustache "0.1-SNAPSHOT"
  :description "Leiningen plugin for evaluating Mustache templates"
  :eval-in-leiningen true
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [de.ubercode.clostache/clostache "1.0.0"]]
  :dev-dependencies [[midje "1.3.1"]
                     [lein-midje "1.0.8"]])
