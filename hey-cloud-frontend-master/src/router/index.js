import {createRouter} from "vue-router";
import {routeRule} from "@/router/helper-router.js";
import {staticRoutes} from "@/router/static-routes.js";


const router = createRouter({
  routes: staticRoutes,
  history: routeRule,
})

export default router