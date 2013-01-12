(ns leiningen.test.mustache
  (:use leiningen.mustache
        midje.sweet)
  (:import java.io.File))

(defn- test-resource [path]
  (File. (str "test-resources/" path)))

(fact (from-file (test-resource "dummy-data.clj")) => {:one "alpha"
                                                       :two "beta"
                                                       :three "gamma"})

(fact (render-from-files
        (test-resource "dummy-template.mustache")
        (test-resource "dummy-data.clj"))
      => "alpha, beta, and gamma are Greek letters.\n")
