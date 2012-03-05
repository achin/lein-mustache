(ns leiningen.mustache
  (:require [clostache.parser :as parser]
            [clojure.string :as string])
  (:import java.io.File
           java.io.FileReader
           java.io.PushbackReader))

(defn from-file [path]
  (with-open [r (PushbackReader. (FileReader. path))]
    (read r)))

(defn render-from-files [template-path data-path]
  (let [template (slurp template-path)
        data (from-file data-path)]
    (string/trim-newline (parser/render template data))))

(defn mustache
  "Evaluate a Mustache template.
  Run this plugin by using the following command:
  
  `lein mustache template data`
  `template` must be a Mustache template, and `data` must be a Clojure map
  that is used to render `template`."
  [project template data]
  (println (render-from-files template data)))
