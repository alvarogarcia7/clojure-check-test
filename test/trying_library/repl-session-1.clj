(+ 1 1)

(clojure.set/union #{1 2 3} #{4 5 3})

(clojure.set/union [1 2] [2 3])
(concat [1 2] [2 3])
(clojure.set/union {:a 1 :b 2} {:a 3 :b 4 :c 4})
(merge {:a 1 :b 2} {:a 3 :b 4 :c 4})
(merge-with (fn [a  b] (* a 2)) {:a 1 :b 2} {:a 3 :b 4 :c 4})
; in merge-with, the first parameter is use to break the ties
; receives both values (not keys or the key-value pair)
(merge-with (fn [a  b] (* a 2)) {:a 1 :b 2} {:a 3 :b 4 :c 4})

; same as union
(merge-with (fn [a b] a) {:a 1 :b 2} {:a 3 :b 4 :c 4})


; same as merge - the newcomer wins
(merge-with (fn [a b] b) {:a 1 :b 2} {:a 3 :b 4 :c 4})


(merge-with (fn [a  b] (println a) (println b) a) {:a 1 :b 2} {:a 3 :b 4 :c 4})
