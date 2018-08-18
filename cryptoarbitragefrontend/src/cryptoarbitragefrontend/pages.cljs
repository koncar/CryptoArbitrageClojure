(ns cryptoarbitragefrontend.pages
  (:require [cryptoarbitragefrontend.comp_general :as comp_pages]
            [cryptoarbitragefrontend.comp_alert-messages :as comp_messages]
            [cryptoarbitragefrontend.comp_menus :as comp_menus]
            [cryptoarbitragefrontend.comp_sign_forms :as comp_forms]
            [reagent.core :as reagent]
            [cryptoarbitragefrontend.comp_profile :as comp_profile])
  )

(defonce form (reagent/atom (comp_forms/sign-up-form)))
(defonce other_form (reagent/atom "SIGN IN"))

(defn swap-form []
  (if (= @other_form "SIGN IN")
    (do
      (println "other form is sign in")
      (reset! form (-> (comp_forms/sign-in-form)))
      (reset! other_form (-> "SIGN UP"))
      )
    (do
      (println "otherform is sign up")
      (reset! form (-> (comp_forms/sign-up-form)))
      (reset! other_form (-> "SIGN IN"))))
  )
(defn home []
  [:div
   (comp_menus/home-navigation)
   (comp_messages/messages-holder)
   (comp_pages/home-panel)
   [:div.container.mt-4.text-center.col-xl-4
   @form
   [:input.btn.btn-link
    {:type     "button"
     :on-click #(swap-form)
     :value    @other_form
     }
    ]
    ;[:button {:on-click #(components/add_success_with_timeout "Ovo je test poruka")} "Test"]
    ]
   ]
  )

(defn home-logged []
  [:div
   (comp_menus/home-navigation)
   (comp_messages/messages-holder)
   (comp_pages/crypto-arbitrage-table)
   ])

(defn blog []
  [:div
   (comp_menus/home-navigation)
   (comp_messages/messages-holder)
   (comp_pages/blog)
   ]
  )

(defn write-blog []
  [:div
   (comp_menus/home-navigation)
   (comp_messages/messages-holder)
   (comp_pages/write-blog)
   ]
  )

(defn my-profile []
  [:div
   (comp_menus/home-navigation)
   (comp_messages/messages-holder)
   (comp_profile/my-profile)
   ])

(defn not-found []
  :div [:h1 "Page not found"])
