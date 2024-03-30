export const staticRoutes = [
  {
    path: "/shit",
    component: () => import("@/components/test.vue")
  }
  // {
  //   path: "/redirect",
  //   component: Layouts,
  //   meta: {
  //     hidden: true
  //   },
  //   children: [
  //     {
  //       path: "/redirect/:path(.*)",
  //       component: () => import("@/views/redirect/index.vue")
  //     }
  //   ]
  // },
  // {
  //   path: "/403",
  //   component: () => import("@/views/error-page/403.vue"),
  //   meta: {
  //     hidden: true
  //   }
  // },
  // {
  //   path: "/404",
  //   component: () => import("@/views/error-page/404.vue"),
  //   meta: {
  //     hidden: true
  //   },
  //   alias: "/:pathMatch(.*)*"
  // },
  // {
  //   path: "/login",
  //   component: () => import("@/views/login/index.vue"),
  //   meta: {
  //     hidden: true
  //   }
  // },
  // {
  //   path: "/",
  //   component: Layouts,
  //   redirect: "/dashboard",
  //   children: [
  //     {
  //       path: "dashboard",
  //       component: () => import("@/views/dashboard/index.vue"),
  //       name: "Dashboard",
  //       meta: {
  //         title: "首页",
  //         svgIcon: "dashboard",
  //         affix: true
  //       }
  //     }
  //   ]
  // }
]
