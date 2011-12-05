(ns processingtest2
  (:use [rosado.processing]
        [rosado.processing.applet]
        [com.evocomputing.colors :exclude [saturation hue red green blue alpha color]]))



;;
;;  ([xi yi]
;;    (for [x (range xi), y (range yi)]
;;                [x y]))

(def img (atom nil))
(def pxs (atom nil))
(def results (atom nil))

(defn pixel-list 
  [[x1 y1 x2 y2]]
  (for [x (range x1 x2), y (range y1 y2)]
    [x y]))

(defn getpx-hue [[x y]]
  (let [px (get-pixel x y)]
    (swap! results concat (list (vector (red px) (green px) (blue px))))))


(defn doscience [img-new x1 y1 x2 y2]
  (reset! img img-new) 
  (reset! pxs [x1 y1 x2 y2])
  (run example2)
  (Thread/sleep 1000)
  (stop example2)
  )

(defn draw
  []
  ;;(println img)
  (image(load-image (str @img)) 0 0)
  (doall (map getpx-hue (pixel-list @pxs)))
  )

(defn setup []
  "Runs once."
  (framerate 10))

(defapplet example2 :title "An example."
           :setup setup :draw draw :size [2000 2000])


(defn tests []
  (reset! results nil)
  (doscience "/Users/jacklaxson/Downloads/Ez0Y1.jpg" 0 0 10 10))