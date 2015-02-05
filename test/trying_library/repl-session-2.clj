(ns repl-session2
  (:require [clojure.test.check :as tc]
             [clojure.test.check.generators :as gen]
             [clojure.test.check.properties :as prop]
             [org.hamcrest.Matchers :as matcher]))

(def sort-idempotent-prop
  (prop/for-all [v (gen/vector gen/int)]
    (= (sort v) (sort (sort v)))))

(tc/quick-check 100 sort-idempotent-prop)
(def sample
  (gen/sample (gen/such-that #(< 0 %) gen/int) 10))
 sample
 (apply max sample)
 ;this gives an error:  Couldn't satisfy such-that predicate after 10 tries
 ;(def sample
;   (gen/sample (gen/such-that #(< 11 %) gen/int 10) 10))
; sample ;clojure.lang.ExceptionInfo: Couldn't satisfy such-that predicate after 10 tries. :: {}

 ;this no longer throws an error: we allow for more tries to satisfy the such-that clause
 (def sample
   (gen/sample (gen/such-that #(< 11 %) gen/int 100) 10))
sample

(Math/PI)
(. Math PI)
(macroexpand '(System/getProperty "java.vm.version"))

(if true
  1
  0)
(def a 5)
(macroexpand-1
  '(cond (= a 6) 3
         (= a 7) 3
    :else 2))

; https://speakerdeck.com/reiddraper/powerful-testing-with-test-dot-check
; https://github.com/clojure/test.check
; http://natpryce.com/articles/000807.html
; https://clojuredocs.org/clojure.set/union
; http://blog.jayfields.com/2010/07/clojure-destructuring.html
; http://garajeando.blogspot.com.es/2014/12/talk-about-clojure-destructuring.html
; http://blog.8thlight.com/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html
; http://clojure.org/java_interop


