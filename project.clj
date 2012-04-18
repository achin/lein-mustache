(defproject lein-mustache "0.2-SNAPSHOT"
  :description "Leiningen plugin for evaluating Mustache templates"
  :eval-in-leiningen true
  :min-lein-version "2.0.0"
  :dependencies [[de.ubercode.clostache/clostache "1.0.0"]]
  :profiles {:dev {:resource-paths ["test-resources"]
                   :dependencies [[midje "1.3.1"]]}}
  :plugins [[lein-midje "2.0.0-SNAPSHOT"]])
