(ns leiningen.mustache
  (:require [clostache.parser :as parser]
            [clojure.string :as string])
  (:import java.io.PushbackReader))

(defn from-file [path]
  (with-open [r (java.io.PushbackReader. (clojure.java.io/reader path))]
    (read r)))

(defn- render-from-file
  [template-path data]
  (let [template (slurp template-path)]
    (string/trim-newline (parser/render template data))))

(defn render-from-files [template-path data-path]
  (render-from-file template-path (from-file data-path)))

(defn render-project-entry
  "Renders a single entry from the value of a :mustache entry in project.clj."
  [{:keys [template-path destination-path]} data]
  (let [dst (parser/render destination-path data)]
    (do
      (clojure.java.io/make-parents dst)
      (spit dst
            (render-from-file template-path data)))))

(defn mustache
  "Evaluate a Mustache template.
  Run this plugin by using one of the following commands:
  
  `lein mustache template data`
  `template` must be a Mustache template, and `data` must be a Clojure map
  that is used to render `template`.
  
  or:
  
  `lein mustache data`
  `data` must be a Clojure map and one or more templates are specified in
  project.clj."
  ([project data]
   (let [d (from-file data)]
     (doseq [tmpl (:mustache project)]
       (render-project-entry tmpl d))))
  ([project template data]
   (println (render-from-files template data))))
