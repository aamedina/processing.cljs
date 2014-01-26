(defproject processing "0.1.0-SNAPSHOT"
  :description "thin ClojureScript veneer over processing.js"
  :url "https://github.com/aamedina/processing.cljs"
  :repositories {"sonatype"
                 "http://oss.sonatype.org/content/repositories/snapshots"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/core.match "0.2.1"]
                 [hiccup "1.0.5"]
                 [om "0.3.0"]
                 [sablono "0.2.3"]
                 [riddley "0.1.6"]
                 [prismatic/dommy "0.1.2"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [ring "1.2.0"]
                                  [compojure "1.1.6"]
                                  [enlive "1.1.4"]]
                   :plugins [[com.cemerick/austin "0.1.4-SNAPSHOT"]]
                   :source-paths ["dev"]}}
  :plugins [[lein-cljsbuild "1.0.1"]]
  :source-paths ["src" "test"]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src" "test"]
                :compiler {:output-to "resources/public/js/main.js"
                           :output-dir "resources/public/js/out"
                           :source-map "resources/public/js/main.js.map"
                           :source-map-path "resources/public/js/out"
                           :optimizations :none}}
               {:id "examples"
                :source-paths ["src" "test"]
                :compiler {:output-to "resources/public/js/main.js"
                           :optimizations :advanced
                           :pretty-print false
                           :preamble
                           ["react/react.min.js"
                            "resources/public/js/processing-1.4.1.js"]
                           :externs
                           ["react/externs/react.js"
                            "resources/public/js/processing-1.4.1.js"]}}
               {:id "prod"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/main.js"
                           :optimizations :advanced
                           :pretty-print false
                           :preamble
                           ["react/react.min.js"
                            "resources/public/js/processing-1.4.1.js"]
                           :externs
                           ["react/externs/react.js"
                            "resources/public/js/processing-1.4.1.js"]}}]})
