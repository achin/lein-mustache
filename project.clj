(defproject lein-mustache "0.3"
  :description "Leiningen plugin for evaluating Mustache templates"
  :eval-in-leiningen true
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [de.ubercode.clostache/clostache "1.0.0"]]
  :profiles {:dev {:dependencies [[midje "1.4.0"]]
                   :plugins [[lein-midje "2.0.4"]]}})
